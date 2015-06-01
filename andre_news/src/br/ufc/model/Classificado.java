package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="classificado")
public class Classificado {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="texto")
	private String texto;
	
	@Column(name="preco")
	private double preco;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="melhor_oferta")
	private double melhorOferta;
	
	@Column(name="data_oferta")
	private Date dataOferta;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_autor", referencedColumnName = "id")
	private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getMelhor_oferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(double melhor_oferta) {
		this.melhorOferta = melhor_oferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date data_oferta) {
		this.dataOferta = data_oferta;
	}
	

}
