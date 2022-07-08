var app = angular.module('myApp',["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
    .when("/64",{
        templateUrl: "general/64.html"
    })
    .when("/128",{
        templateUrl: "general/128.html"
    })
    .when("/256",{
        templateUrl: "general/256.html"
    })
    .when("/tim",{
        templateUrl: "general/tim.html"
    })
    .when("/trang",{
        templateUrl: "general/64.html"
    })
    .when("/vang",{
        templateUrl: "general/vang.html"
    })
    .when("/den",{
        templateUrl: "general/64.html"
    })
    .when("/do",{
        templateUrl: "general/do.html"
    })
    .otherwise({
        redirectTo: "/64"
    })
})
app.run(function ($rootScope) {
    $rootScope.$on('$routeChangeStart',function () {
        $rootScope.loading = true
    })
    $rootScope.$on('$routeChangeSuccess',function () {
        $rootScope.loading = false
    })
    $rootScope.$on('$routeChangeError',function () {
        $rootScope.loading = false
        alert("Lỗi, Không tải được tameplate")
    })
})
app.controller('myCtrl', function ($scope) {
    $scope.products = [
        {
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        },{
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        },{
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        },{
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        },{
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        },{
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        },{
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        },{
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        },{
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        },{
            Name: "Iphone 11",
            image: "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/small_image/220x175/9df78eab33525d08d6e5fb8d27136e95/p/h/photo_2020-10-13_22-12-24.jpg_1_2.png",
            Price: 15000000,
            qty: 1
        }
        
    ]
    $scope.begin = 0;
    $scope.pageCount = Math.ceil($scope.products.length / 8);
    $scope.prev = function () {
        if ($scope.begin>0) {
            $scope.begin -= 8;
        }
    }
    $scope.page1 = function () {
            $scope.begin += 8;
        
    }
    $scope.page2 = function () {
            $scope.begin += 2+8;
        
    }
    $scope.page3 = function () {
            $scope.begin += 3+8;
        
    }
    $scope.next = function () {
        if ($scope.begin<($scope.pageCount - 1)*8) {
            $scope.begin += 8;
        }
    }
    $scope.last = function () {
        $scope.begin = ($scope.pageCount - 1)*8;
    }
    $scope.cart = [];
          
          var findItemById = function(products, Name) {
            return _.find(products, function(product) {
              return product.Name=== Name;
            });
          };
          
          $scope.getCost = function(product) {
            return product.qty * product.Price;
          };

          $scope.addItem = function(itemToAdd) {
            var found = findItemById($scope.cart, itemToAdd.Name);
            if (found) {
              found.qty += itemToAdd.qty;
            }
            else {
              $scope.cart.push(angular.copy(itemToAdd));}
          };
          
          $scope.getTotal = function() {
            var total =  _.reduce($scope.cart, function(sum, product) {
              return sum + $scope.getCost(product);
            }, 0);
            console.log('total: ' + total);
            return total;
          };
          
          $scope.clearCart = function() {
            $scope.cart.length = 0;
          };
          
          $scope.removeItem = function(product) {
            var index = $scope.cart.indexOf(product);
            $scope.cart.splice(index, 1);
          };
          
});

