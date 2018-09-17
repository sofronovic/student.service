'use strict';

angular.module('studentServiceApp').
	controller('students-ctrl', ['$scope', '$log', '_', 'StudentResource', 
		function($scope, $log, _, StudentResource) {
			StudentResource.getStudents().then(function(item){
				$scope.students = item;
			});

			$scope.removeStudent = function(id){
				StudentResource.removeStudent(id);
			};
			$scope.addStudentForm = false;
			$scope.showForm = function(){
				$scope.addStudentForm = !$scope.addStudentForm;
			};

			$scope.saveStudent = function(student){
				$log.info("student" + $scope.student.userName);
				StudentResource.saveStudent($scope.student);
			}
}]);
