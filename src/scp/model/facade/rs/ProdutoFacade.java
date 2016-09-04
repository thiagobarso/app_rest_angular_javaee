package scp.model.facade.rs;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import scp.model.domain.Fornecedor;
import scp.model.domain.Produto;

@Path("/produto")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_XML)
public class ProdutoFacade {
	
	static ArrayList<Produto> produtos = new ArrayList<>();
	
	static{
		produtos.add(new Produto(1,"Sandália Havaina", new Fornecedor(1,"Alpargatas")));
	}
	
	@GET
	public List<Produto> getProdutos(){
		return produtos;
	}
	
	@POST
	public Produto salvar(Produto produto){
		produtos.add(produto);
		produto.setCodigo(777);
		return produto;
	}
	
	@PUT
	public void atualizar(Produto produto){
		produtos.remove(produto);
	 	produtos.add(produto);		
	}
		
	@DELETE
	@Path("/{codigoProduto}")
	public void excluir(@PathParam("codigoProduto") Integer codigoProduto){
		Produto produto = new Produto();
		produto.setCodigo(codigoProduto);
		produtos.remove(produto);
	}
}
