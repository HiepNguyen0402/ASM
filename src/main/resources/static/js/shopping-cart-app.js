const app = angular.module("shopping-cart-app",[])
app.config(['$qProvider', function ($qProvider) {
    $qProvider.errorOnUnhandledRejections(false);
}]);
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
                $http.get(`/rest/products/${id}`).then(resp =>{
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

    $scope.show_checkout = false;
    $scope.show = function (){
        $scope.show_checkout = true;
    }

    $scope.order={
        create_date: new Date(),
        address:"",
        account:{userID: $("#username").text()},
        get orderDetails(){
            return $scope.cart.items.map(item =>{
                return{
                    product:{id:item.id},
                    price:item.price,
                    quantity:item.qty
                }
            });
        },
        purchase(){
            var order = angular.copy(this);
            $http.post("/rest/orders",order).then(resp =>{
                alert("Đặt hàng thành công")
                $scope.cart.clear();
                location.href="/order/detail/"+resp.data.id;
            }).catch(error =>{
                alert("Đặt hàng lỗi")
                console.log(error)
            })
            $scope.show_checkout = false;
        }
    }
})