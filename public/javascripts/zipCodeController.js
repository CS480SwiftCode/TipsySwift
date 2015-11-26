angular.module("app").controller('zipCodeController', ['$rootScope', '$location', '$scope', '$http', '$cookies', function($rootScope, $location, $scope, $http, $cookies) {
  $scope.location = "";
  $http.get('/map')
      .then(function(res){
      $cookies.putObject('locationChoice', Papa.parse(res.data).data);
      //$rootScope.$broadcast('eventSwag', { message: Papa.parse(res.data) });
    });
  $scope.go = function(){
	var geocoder = new google.maps.Geocoder();
	geocoder.geocode( { 'address': $scope.location}, function(results, status) {
  	if (status == google.maps.GeocoderStatus.OK)
  	{
      // do something with the geocoded result
      var geoCords = {
       	lat: results[0].geometry.location.lat(),
      	lng : results[0].geometry.location.lng()
      };
      $cookies.putObject('geoPlace', geoCords);
      $location.path('/map');
      $scope.location = "";
      $scope.$apply();
  	}
  	else{
  		alert("invalid Address");
  	}
  	
	});

  };
 }]);