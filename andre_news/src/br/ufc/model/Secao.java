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
	
	public Collection<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(Collection<Noticia> noticias) {
		this.noticias = noticias;
	}
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
	public long getIdSecao() {
		return idSecao;
	}
	public void setIdSecao(long idSecao) {
		this.idSecao = idSecao;
	}
	@Override
	public String toString() {
		return "Secao [idSecao=" + idSecao + ", titulo=" + titulo
				+ ", descricao=" + descricao + ", noticias=" + noticias + "]";
	}
	
}
