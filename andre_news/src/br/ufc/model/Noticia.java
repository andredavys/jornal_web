package br.ufc.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="noticia")
public class Noticia {

	@Id
	@Column(name = "id_noticia")
	@GeneratedValue
	private long idNoticia;
	
	@Column(name="titulo", nullable = false)
	private String titulo;
	@Column(name="subtitulo")
	private String subtitulo;
	@Column(name="texto", nullable = false)
	private String texto;
	
	@Column(name="data_noticia")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_secao", referencedColumnName = "id_secao")
	private Secao secao;
	
	@OneToMany(mappedBy="noticia", targetEntity=Comentario.class, fetch=FetchType.LAZY)
	private Collection<Comentario> comentarios;
	
	@OneToOne
	@JoinColumn(name="id_autor")
	private Usuario usuario;
	
	public long getId_noticia() {
		return idNoticia;
	}
	public void setId_noticia(long id) {
		this.idNoticia = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData_noticia() {
		return data;
	}
	public void setData_noticia(Date data_noticia) {
		this.data = data_noticia;
	}
}
