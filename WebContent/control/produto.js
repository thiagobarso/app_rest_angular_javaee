var produtoModule = angular.module('produtoModule',[]);

produtoModule.controller("produtoControl",function($scope){
	
	console.log('Fornecedores');
	$scope.fornecedores = [
		{codigo:1, nome: 'Alpargatas'},
		{codigo:2, nome: 'Sádia'},
		{codigo:3, nome: 'Nestle'}
	];

	console.log('Produtos');
	$scope.produtos = [
		{codigo:1, nome: 'Sandalia Havaiana', fornecedor: {codigo:1, nome: 'Alpargatas'}},
		{codigo:2, nome: 'Bombom Nestle', fornecedor: {codigo:3, nome: 'Nestle'}}		
	];

	$scope.selecionaProduto = function(produto){
		$scope.produto = produto;		
	}

	$scope.salvar = function(){
		$scope.produtos.push($scope.produto);
		$scope.novo();
	}

	$scope.excluir = function(){
		$scope.produtos.splice($scope.produtos.indexOf($scope.produto),1);
		$scope.novo();
	}

	$scope.novo = function(){
		$scope.produto = "";
	}

});