'use strict';

angular.module('studentServiceApp').controller('login-ctrl', ['$rootScope', '$scope', '$http', '$log', '$location', 
	function ($rootScope, $scope, $http, $log, $location) {

		$scope.credentials = {};

		$scope.login = function() {

			var param = "Basic " + btoa("trusted-app:secret");
			var data = { "username": $scope.credentials.username, "password": $scope.credentials.password, "grant_type" : "password"};
			var config = { headers: { "Authorization": param}};
		}
	}
	])