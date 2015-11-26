angular.module("app").controller('mapController', ['$rootScope', '$document', 'Map', '$scope', '$location', '$cookies', function($rootScope, $document, Map, $scope, $location, $cookies) {
$scope.place = {};
var res;
var marks = [];
var message = $cookies.getObject('locationChoice');
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
            res = new google.maps.LatLng($scope.place.lat, $scope.place.lng);
            message = {};
            Map.removeMarker(marks);
            Map.center(res);
            marks = [];
            var swaggy = '/map?location=' + $scope.place.lat + "," + $scope.place.lng;
            $http.get()
                .then(function(res){
                message = Papa.parse(res.data).data;
                $cookies.putObject('locationChoice', Papa.parse(res.data).data);
            });
            drop();

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
    for(i = 1; i < message.length; i++){
        var pos = new google.maps.LatLng(message[i][9], message[i][10]);
        res = {position : pos,
                url : message[i][6],
                name: new google.maps.InfoWindow({ content: '<div id="content" style="color:black">' + message[i][0] + '<div>', position : pos})};
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