var produtoModule = angular.module('produtoModule',[]);

produtoModule.controller("produtoControl",function($scope,$http){
	
	urlFornecedor = 'http://localhost:8080/SCP/rs/fornecedor';	

	urlProduto = 'http://localhost:8080/SCP/rs/produto';
	
		
	$scope.pesquisarFornecedor = function(){
		console.log('pesquisando fornecedores');
		$http.get(urlFornecedor).success(function (fornecedores){
			$scope.fornecedores = fornecedores;
		}).error(function(erro){
			alert(erro);
		});
	}
	
	$scope.pesquisarProduto = function(){
		console.log('pesquisando produto');
		$http.get(urlProduto).success(function (produtos){
			$scope.produtos = produtos;
		}).error(function(erro){
			alert(erro);
		});
	}	

	$scope.salvar = function(){
		
		var requisicaoPOST = {method: 'POST',url: urlProduto,headers: { 'Content-Type': 'application/json'},data: $scope.produto};
		var requisicaoPUT = {method: 'PUT',url: urlProduto,headers: { 'Content-Type': 'application/json'},data: $scope.produto};
		
		if($scope.produto.codigo == ''){
			$http(requisicaoPOST).then(function successCallback(response) {
				$scope.produtos.push($scope.produto);
				$scope.novo();
			  }, function errorCallback(response) {
				  console.log("Deu Erro:");
					alert(response);
			  });
		}else{
			$http(requisicaoPUT).then(function successCallback(response) {
				$scope.produtos.push($scope.produto);
				$scope.novo();
			  }, function errorCallback(response) {
				  console.log("Deu Erro:");
					alert(response);
			  });
		}			
	}
	
	$scope.excluir = function(){
		if($scope.produto.codigo == ''){
			alert('Selecione um produto');
		}else{
			var urlExcluir = urlProduto + "/" + $scope.produto.codigo;
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarProduto();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
			
		}
		$scope.produtos.splice($scope.produtos.indexOf($scope.produto),1);
		$scope.novo();
	}

	$scope.selecionaProduto = function(produto){
		$scope.produto = produto;		
	}


	$scope.novo = function(){
		$scope.produto = "";
	}
	
	$scope.pesquisarProduto();
	$scope.pesquisarFornecedor();

});