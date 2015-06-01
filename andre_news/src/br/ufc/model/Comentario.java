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
	
	@Column(name = "id_autor", nullable = false)
	private long id_autor;
	
	@Column(name = "texto")
	private String texto;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="id_noticia", referencedColumnName = "id_noticia")
	private Noticia noticia;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_autor() {
		return id_autor;
	}
	public void setId_autor(long id_autor) {
		this.id_autor = id_autor;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
