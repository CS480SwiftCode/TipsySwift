angular.module("app").controller('mapController', ['$rootScope', '$document', 'Map', '$scope', '$location', '$cookies', '$http', '$window', function($rootScope, $document, Map, $scope, $location, $cookies, $http, $window) {
$scope.place = {};
var resl;
var marks = [];
if($rootScope.reload == true){
    $window.location.reload(true);
}
var message2 = $cookies.getObject('locationChoice');
var message3 = $cookies.getObject('locationChoice2');
if(message3 != undefined){var message = message2.concat(message3);}
else{var message = message2;}
console.log(message);
Map.init()
drop();
$scope.search = function() {
    console.log('swag'); //swaggy
    $scope.apiError = false;
    Map.search($scope.searchPlace)
    .then(
        function(res) { // success
            $scope.place.name = res.name;
            $scope.place.lat = res.geometry.location.lat();
            $scope.place.lng = res.geometry.location.lng();
            resl = new google.maps.LatLng($scope.place.lat, $scope.place.lng);
            message = {};
            Map.removeMarker(marks);
            Map.center(resl);
            $cookies.putObject('geoPlace', resl);
            marks = [];
            message = [];
            var swaggy = '/map?location=' + $scope.place.lat + "_" + $scope.place.lng;
            console.log(swaggy);
            $http.get(swaggy)
                .then(function(res){
                    var yolo = [];
                    if(Papa.parse(res.data).data.length > 10){
                      for(i = 0; i <10; i++){
                        yolo.push(Papa.parse(res.data).data[i]);
                        message.push(Papa.parse(res.data).data[i]);
                      }
                      var rekt = [];
                      for(i = 10; i < (Papa.parse(res.data).data.length -1); i++){
                        rekt.push(Papa.parse(res.data).data[i]);
                        message.push(Papa.parse(res.data).data[i]);
                      }
                      $cookies.putObject('locationChoice', yolo);
                      $cookies.putObject('locationChoice2', rekt);
                    }
                    else{
                      for(i = 0; i < (Papa.parse(res.data).data.length-1); i++){
                        yolo.push(Papa.parse(res.data).data[i]);
                        message.push(Papa.parse(res.data).data[i]);
                      }
                      $cookies.putObject('locationChoice', yolo);
                      $cookies.putObject('locationChoice2', []);
                    }
                    drop();
            });

        },
        function(status) { // error
            $scope.apiError = true;
            $scope.apiStatus = status;
        }
    );
}


    
$scope.send = function() {
    alert($scope.place.name + ' : ' + $scope.place.lat + ', ' + $scope.place.lng);    
}
    
function drop() {
    for(i = 0; i < message.length; i++){
        console.log("YASSSS");
        var pos = new google.maps.LatLng(message[i][9], message[i][10]);
        res = {position : pos,
                url : message[i][6],
                name: new google.maps.InfoWindow({ content: '<div id="content" style="color:black">' + message[i][0] + '<div> <div id="content" style="color:black">' + message[i][3] + '<div>', position : pos})};
        marks.push(Map.addMarker(res));
    }
}

var dm = this;

activate();

function activate() {
    dm.open = open;
    dm.pages = [{
    'tpl': '/map',
    'icon': 'fa-map'
    }, {
    'tpl': '/table',
    'icon': 'fa-table'
    }, {
    'tpl': '/dataentry',
    'icon': 'fa-pencil'
    }];
    dm.active = dm.pages[0].tpl;
}

function open(page) {
    $location.path(page);
}


}]);