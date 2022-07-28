const app = angular.module("shopping-cart-app",[])
app.controller("shopping-cart-ctrl",function ($scope,$http) {
    // Mananer shopping-cart
    $scope.cart = {
        items:[],
        //Add item
        add(id){
            var item = this.items.find(item => item.product_ID == id)
            if (item){
                item.qty++;
                this.saveToLocalStorage();
            }else {
                $http.get(`/rest/product/${id}`).then(resp =>{
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        //Delete item
        remove(id){
            var index = this.items.findIndex(item => item.product_ID == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        },
        //Delete all item
        clear(){
            this.items = [];
            this.saveToLocalStorage();
        },
        //Charge of a product
        amt_of(item){},
        //Total product
        get count(){
            return this.items
                .map(item => item.qty)
                .reduce((total,qty)=>total += qty,0);
        },
        //Total charge of product
        get amount(){
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total,qty)=>total += qty,0);
        },
        //Save to localstorage
        saveToLocalStorage(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },
        //Read data from localstorage
        loadFromLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json):[];
        }
    }

    $scope.cart.loadFromLocalStorage();
})