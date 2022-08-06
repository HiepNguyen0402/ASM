
const app = angular.module("app",[]);
app.controller("ctrl",function($scope,$http){
  $scope.form = {}
  $scope.items = []
  $scope.reset = function () {
    $scope.form = {
      role: false,
    }
  }

  $scope.run = function () {
    // Thuc hien tai toan bo Account
    $http.get(`/user/account`).then(resp => {
      $scope.items = resp.data;
      
    });
    $scope.reset();

  }
  $scope.edit = function (item) {
	
    $scope.form = angular.copy(item); 
	$(".nav-tabs a:eq(0)").tab('show');
  }
  $scope.create = function () {
    var item = angular.copy($scope.form);
    $http.post(`/user/account`, item).then(resp => {
      $scope.items.push(resp.data);
      $scope.reset();
      alert("Them moi account thanh cong !!");
    }).catch(error => {
      alert("Loi them moi account !!")
      console.log("Error", error);
    });
  }
  $scope.update = function (item) {
    var item = angular.copy($scope.form);
    $http.put(`/user/account/${item.userID}`, item).then(resp => {
      var index = $scope.items.findIndex(item => item.userID == userID);
      $scope.items[index] = item;
      alert("Success");
    }).catch(error => {
      alert("Fail");
      console.log("Error", error);
    });
  }
  $scope.delete = function (id) {
    var id = angular.copy($scope.form);
    $http.delete(`/user/account/${id.userID}`).then(resp => {
      var index = $scope.items.findIndex(item => item.userID == id.userID);  
      $scope.items.splice(index, 1);
      $scope.reset();
      alert("Xoa thanh cong !");
    }).catch(error => {
      alert("xoa khong thanh cong");
      console.log("Error", error);
    });
  }

  $scope.run();

});