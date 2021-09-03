package mz.com.soto.junior.bean;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import mz.com.soto.junior.domain.Produto;


@ManagedBean
@ViewScoped
public class ProdutoBean2  {
	private Produto produto;
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
}
