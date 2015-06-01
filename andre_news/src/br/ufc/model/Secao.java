package br.ufc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="secao")
public class Secao {
	
	@Id
	@Column(name = "id_secao")
	@GeneratedValue
	private long idSecao;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToMany(mappedBy="secao", targetEntity = Noticia.class, fetch=FetchType.EAGER)
	private Collection<Noticia> noticias;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getId() {
		return idSecao;
	}
	public void setId(long id) {
		this.idSecao = id;
	}
}
