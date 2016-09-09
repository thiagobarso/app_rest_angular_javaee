package scp.model.service;

import java.util.List;

import scp.model.domain.Produto;

public interface ProdutoService {

	void excluir(Produto produto);

	void atualizar(Produto produto);

	Produto salvar(Produto produto);

	List<Produto> getProdutos();

}