angular.module("app").controller('formController', ['$rootScope', '$location', '$scope', '$http', function($rootScope, $location, $scope, $http) {
	$scope.data = {
		hourModel : [],
    	city : null,
    	name : null,
    	daysModel : []
   };
   $rootScope.reload = true;
   $scope.submit = function(){
   		alert("Thank you for your contribution it will be reviewed and added");
   };
   $scope.settings = {enableSearch: true};
   $scope.settingsMore = {enableSearch: true, showCheckAll : false, showUncheckAll : false};
   $scope.daysData = [ {id: 'M', label: "Monday"}, {id: 'T', label: "Tuesday"}, {id: 'W', label: "Wednesday"}, {id: 'Th', label: "Thursday"}, {id: 'F', label: "Friday"}, {id: 'Sat', label: "Saturday"}, {id: 'Sun', label: "Sunday"}];
   $scope.hourData = [ {id: '1a', label: "1 A.M."}, {id: '2a', label: "2 A.M."}, {id: '3a', label: "3 A.M."}, {id: '4a', label: "4 A.M."}, {id: '5a', label: "5 A.M."}, {id: '6a', label: "6 A.M."}, {id: '7a', label: "7 A.M."}, {id: '8a', label: "8 A.M."}, {id: '9a', label: "9 A.M."}, {id: '10a', label: "10 A.M."}, {id: '11a', label: "11 A.M."}, {id: '12a', label: "12 A.M."}, {id: '1p', label: "1 P.M."}, {id: '2p', label: "2 P.M."}, {id: '3p', label: "3 P.M."}, {id: '4p', label: "4 P.M."}, {id: '5p', label: "5 P.M."}, {id: '6p', label: "6 P.M."}, {id: '7p', label: "7 P.M."}, {id: '8p', label: "8 P.M."}, {id: '9p', label: "9 P.M."}, {id: '10p', label: "10 P.M."}, {id: '11p', label: "11 P.M."}, {id: '12p', label: "12 P.M."}];
   $scope.customTexts = {buttonDefaultText: 'Check Happy Days'};
   $scope.customText = {buttonDefaultText: 'Check Start to End Time'};
    var vm = this;

    activate();

    function activate() {
      vm.open = open;
      vm.pages = [{
        'tpl': '/map',
        'icon': 'fa-map'
      }, {
        'tpl': '/table',
        'icon': 'fa-table'
      }, {
        'tpl': '/dataentry',
        'icon': 'fa-pencil'
      }];
      vm.active = vm.pages[0].tpl;
    }

    function open(page) {
        $location.path(page);
    }
}]);