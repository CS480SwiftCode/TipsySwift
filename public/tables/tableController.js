angular.module("app").controller('tableController', ['$rootScope', '$location', '$scope', '$http', '$window', '$cookies', function($rootScope, $location, $scope, $http, $window, $cookies) {

$scope.sortType = 'name'; //set the default sort type
$scope.softReverse = false; // set the default sort order
$scope.searchName = ''; //the the default sort filter
var message = $cookies.getObject('locationChoice');
$scope.resturants = []
var json = {};
var dist = [];
distance();
function setTable(){
    for(i = 1; i < message.length; i++)
    {
        json = { name : message[i][0],
        		rating : message[i][8],
        		hhours : "NA",
        		dist : dist[(i-1)]
        		};
        $scope.resturants.push(json);
    }
    console.log($scope.resturants);
    $scope.$apply();
}
$scope.test = "";
$scope.submit = function(){
    console.log($scope.test);
};
function distance() {
    var dat = $cookies.getObject('geoPlace');
    var resO = new google.maps.LatLng(dat.lat, dat.lng);
    var res = []
    for(i = 1; i < message.length; i++){
        res.push(new google.maps.LatLng(message[i][9], message[i][10]));
    }
    console.log(res);
    var service = new google.maps.DistanceMatrixService();
    service.getDistanceMatrix(
      {
        origins: [resO],
        destinations: res,
        travelMode: google.maps.TravelMode.DRIVING,
        unitSystem : google.maps.UnitSystem.IMPERIAL,
        avoidHighways: false,
        avoidTolls: true,
      }, callback);

    function callback(response, status) {
        for(i = 0; i < response.rows[0].elements.length; i++)
        {
            dist.push(response.rows[0].elements[i].distance.text);
        }
        setTable();
    }
};
var lm = this;
activate();

    function activate() {
      lm.open = open;
      lm.pages = [{
        'tpl': '/map',
        'icon': 'fa-map'
      }, {
        'tpl': '/table',
        'icon': 'fa-table'
      }, {
        'tpl': '/dataentry',
        'icon': 'fa-pencil'
      }];
      lm.active = lm.pages[0].tpl;
    }

    function open(page) {
        $location.path(page);
    }

 }]);