angular.module("app").controller('zipCodeController', ['$rootScope', '$location', '$scope', '$http', '$cookies', '$window', function($rootScope, $location, $scope, $http, $cookies, $window) {
  $scope.location = "";
  $rootScope.reload = true;
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
      var swaggy = '/map?location=' + geoCords.lat + "_" + geoCords.lng;
      console.log(swaggy);
      $http.get(swaggy)
      .then(function(res){
        //sessionStorage.setItem('locationChoice', Papa.parse(res.data).data);
        var yolo = [];
        if(Papa.parse(res.data).data.length > 10){
          for(i = 0; i <10; i++){
            yolo.push(Papa.parse(res.data).data[i]);
          }
          var rekt = [];
          for(i = 10; i < (Papa.parse(res.data).data.length -1); i++){
            rekt.push(Papa.parse(res.data).data[i]);
          }
          $cookies.putObject('locationChoice', yolo);
          $cookies.putObject('locationChoice2', rekt);
        }
        else{
          for(i = 0; i < (Papa.parse(res.data).data.length-1); i++){
            yolo.push(Papa.parse(res.data).data[i]);
          }
          $cookies.putObject('locationChoice', yolo);
          $cookies.putObject('locationChoice2', []);
        }
        //$rootScope.$broadcast('eventSwag', { message: Papa.parse(res.data) });
      });
      $rootScope.reload  = true;
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