package br.ufc.model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private long id;
	@Column(name = "role", nullable = false)
	private String role;
	
	@ManyToMany(mappedBy="roleList", fetch=FetchType.EAGER)
	private Collection<Usuario> users;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
