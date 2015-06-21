package br.ufc.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="id", nullable = false)
	@GeneratedValue
	private long id;
	
	@Column(name="login", nullable = false, unique = true)
	private String login;
	@Column(name="senha", nullable = false)
	private String senha;
	@Column(name="nome")
	private String nome;
	@Column(name="email")
	private String email;
	
	@OneToOne(optional=false,cascade=CascadeType.ALL, mappedBy="usuario", targetEntity=Noticia.class)
	private Noticia noticia;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="Usuario_Role",
			joinColumns = @JoinColumn(name="id_usuario", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name="id_role", referencedColumnName="id") 
			)
	private Collection<Role> roleList;
	
	@OneToMany(mappedBy = "usuario", targetEntity = Classificado.class, fetch=FetchType.LAZY)
	private Collection<Classificado> listClass;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Collection<Role> getRoleList(){
		return roleList;
	} 
	public void setRoleList(Collection<Role> roleList){
		this.roleList = roleList;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha
				+ ", nome=" + nome + ", email=" + email + "]";
	}
	
}
