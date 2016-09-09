package scp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import scp.model.domain.Produto;

public class ProdutoDaoImpl implements ProdutoDao {

	@PersistenceContext(unitName = "SCPPU")
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see scp.model.dao.ProdutoDao#getProdutos()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> getProdutos() {
		Query query = entityManager.createQuery("from Produto", Produto.class);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see scp.model.dao.ProdutoDao#salvar(scp.model.domain.Produto)
	 */
	@Override
	public Produto salvar(Produto produto) {
		entityManager.persist(produto);
		return produto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see scp.model.dao.ProdutoDao#excluir(scp.model.domain.Produto)
	 */
	@Override
	public void excluir(Produto produto) {
		Produto produto2 = entityManager.merge(produto);
		entityManager.remove(produto2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see scp.model.dao.ProdutoDao#atualizar(scp.model.domain.Produto)
	 */
	@Override
	public void atualizar(Produto produto) {
		Produto produto2 = entityManager.merge(produto);
		entityManager.persist(produto2);
	}

}
