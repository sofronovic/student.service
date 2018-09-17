angular.module('studentServiceApp')
	.factory('StudentResource', ['Restangular', '_', 
		function(Restangular, _){
	
			var students = [];
			var returnValue = {};

			returnValue.getStudents = function(){
				return Restangular.all("students").getList().then(function(entries){
					students = entries;
					return students;
				});
			};

			returnValue.saveStudent = function(student){
				return Restangular.all("students").post(student)
					.then(function (data){
						students.push(data);
					});
			}

			returnValue.removeStudent = function(id){
				return Restangular.one("students", id).remove().then(function(){
					_.remove(students, {
						id: id
					});
				});
			};	

		return returnValue;
	}]);
	
	