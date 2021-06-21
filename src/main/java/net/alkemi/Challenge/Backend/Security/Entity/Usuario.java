package net.alkemi.Challenge.Backend.Security.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import net.alkemi.Challenge.Backend.entity.postB;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nombre;
	@NotNull
	@Column(unique=true)
	private String nombreUsuario;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	//tabla intermedia de usuario y rol
	@JoinTable(name="usuario_rol", joinColumns = @JoinColumn(name= "usuario_id"), inverseJoinColumns = @JoinColumn(name="rol_id"))
	private Set<Rol> roles = new HashSet<>();
	
	/*@OneToMany(mappedBy="Usuario")
	@JsonIgnore
	private List<postB> post;*/
	public Usuario() {
	
	}

	public Usuario(@NotNull String nombre,@NotNull String nombreUsuario,@NotNull String email,@NotNull String password) {
		
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) { 
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	} 
	
	 
	
	
	
}
