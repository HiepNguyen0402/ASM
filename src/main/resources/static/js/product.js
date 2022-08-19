const app = angular.module("myapp",[]);
app.controller("product-ctrl",function ($scope,$http) {
    $scope.items=[];
    $scope.cates=[];
    $scope.form={};

    $scope.initializez=function () {
        $http.get("/rest/products").then(resp=>{
            $scope.items=resp.data;
            $scope.items.forEach(item=>{
                item.create_date = new Date(item.create_date)
            })
        });

        $http.get("/rest/categories").then(resp=>{
            $scope.cates = resp.data;
        })
    }
    $scope.initializez();
    
    $scope.reset=function () {
        $scope.form={
            createDate: new Date(),
            available:true,
        }
    }
    
    $scope.edit=function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }
    
    $scope.create=function () {
        var item = angular.copy($scope.form)
        $http.post(`/rest/products`,item).then(resp=>{
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.date);
            $scope.reset();
            alert("Thêm mới sản phẩm thành công")
        }).catch(error=>{
            alert("Lỗi thêm mới sản phẩm");
            console.log("Error",error);
        })
    }
    
    $scope.update=function () {
        var item = angular.copy($scope.form)
        $http.put(`/rest/products/${item.product_ID}`,item).then(resp=>{
            var index = $scope.items.findIndex(p=> p.id == item.product_ID);
            $scope.items[index]=item;
            alert("Cập nhập sản phẩm thành công")
        }).catch(error=>{
            alert("Lỗi cập nhập sản phẩm");
            console.log("Error",error);
        })
    }


    $scope.delete=function (item) {
        $http.delete(`/rest/products/${item.product_ID}`).then(resp=>{
            var index = $scope.items.findIndex(p=> p.id == item.product_ID);
            $scope.items.splice(index,1);
            $scope.reset();
            alert("Xóa sản phẩm thành công")
        }).catch(error=>{
            alert("Xóa sản phẩm thất bại");
            console.log("Error",error);
        })
    }

    $scope.imageChanged=function (files) {
        const data = new FormData();
        data.append('file',files[0]);
        $http.post('/rest/upload/images',data,{
            transformRequest: angular.identity,
            headers:{'Content-Type':undefined}
        }).then(resp=>{
            $scope.form.product_Image = resp.data.name;
        }).catch(error=>{
            alert("Lối upload hình ảnh");
            console.log("Error",error);
        })
    }
})