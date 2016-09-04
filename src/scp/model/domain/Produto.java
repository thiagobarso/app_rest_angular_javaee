package scp.model.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -953009850092914530L;

	private Integer codigo;
	
	private String nome;
	
	private Fornecedor fonecedor;

	public Produto(Integer codigo, String nome, Fornecedor fonecedor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.fonecedor = fonecedor;
	}

	public Produto() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Fornecedor getFonecedor() {
		return fonecedor;
	}

	public void setFonecedor(Fornecedor fonecedor) {
		this.fonecedor = fonecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
