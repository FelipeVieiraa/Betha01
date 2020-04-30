var appBetha = angular.module("appBetha", ['ngRoute']);

appBetha.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: 'pages/Logon.html',
		controller: 'sessionController'
	});
	$routeProvider.when('/register', {
		templateUrl: 'pages/Register.html',
		controller: 'registerController'
	});
	$routeProvider.when('/default', {
		templateUrl: 'pages/Default.html',
		controller: 'defaultController'
	});
	$routeProvider.when('/clients', {
		templateUrl: 'pages/Clients.html',
		controller: 'clientsController'
	});
	
	$routeProvider.otherwise({ redirectTo: '/' });
});



appBetha.controller('sessionController', function($scope, $http, $location) {

	$scope.sessionUser = function() {
		$http({
			method: 'POST',
			url: "/",
			data: {
				"grant_type": "password",
				"username": $scope.username,
				"password": $scope.password
			},
			headers: { 'Content-Type': 'application/json' }
		})
		.then(function succesCallback(res) {
			console.log(res);
			$location.path("/default");
		}, function errorCallback(res) {
			alert("Erro de login."+ res);
		})
	};
});

appBetha.controller('registerController', function($scope, $http, $location) {
	
	$scope.saveUser = function() {
		$http({
			method: 'POST',
			url: "/users",
			data: {
				"username": $scope.username,
				"userpass": $scope.userpass
			},
			headers: { 'Content-Type': 'application/json' }
		})
		.then(function succesCallback(res) {
			alert("Usuário "+$scope.username+" cadastrado com sucesso!");
			$location.path("/");
		}, function errorCallback(res) {
			alert("Erro de cadastro.");
		})
	};
	
});

appBetha.controller('defaultController', function($scope, $location) {

	$scope.message = "Bem Vindo(a), para usar o serviço cadastre alguns clientes."
	
	$scope.redirectRegister = function() {
		$location.path("/clients");
	}
		
});