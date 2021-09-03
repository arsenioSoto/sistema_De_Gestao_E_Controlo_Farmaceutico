package mz.com.soto.junior.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

//					erdando a chace primaria do genericdomain				
@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain{
	//vou ter um atributo chamado codigo que vem por eranca
	
	@Column(length = 2, nullable = false)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
