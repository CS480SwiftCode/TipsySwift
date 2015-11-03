angular.module("app").controller('zipCodeController', ['$rootScope', '$location', '$scope', function($rootScope, $location, $scope) {
  $scope.location = "";


  $scope.go = function(){
    $location.path("/map");
  };
 }]);