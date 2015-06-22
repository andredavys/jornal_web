package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentario")
public class Comentario {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private long id;
	
	@Column(name = "texto")
	private String texto;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="id_autor",referencedColumnName="id")
	private Usuario autor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="id_noticia", referencedColumnName = "id_noticia")
	private Noticia noticia;
	
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}


}
