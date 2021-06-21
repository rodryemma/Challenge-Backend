package net.alkemi.Challenge.Backend.entity;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.alkemi.Challenge.Backend.Security.Entity.Usuario;

@Entity
@Table(name="postB")
public class postB {

	@JsonProperty(value="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonProperty(value="titulo")
	private String titulo;
	@JsonProperty(value="contenio")
	private String contenido;
	@JsonProperty(value="imagen")
	private String imagen;
	@JsonProperty(value="categoria")
	private String categoria;
	@JsonProperty(value="fechadecreacion")
	private Date fechadecreacion;
	
	@JsonIgnore
	@JsonProperty(value="Usuario")
	@ManyToOne
	@JoinColumn(name = "idusers")
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Date getFechadecreacion() {
		return fechadecreacion;
	}

	public void setFechadecreacion(Date fechadecreacion) {
		this.fechadecreacion = fechadecreacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "postB [id=" + id + ", titulo=" + titulo + ", contenido=" + contenido + ", imagen=" + imagen
				+ ", categoria=" + categoria + ", fechadecreacion=" + fechadecreacion + ", usuario=" + usuario
				+ ", getId()=" + getId() + ", getTitulo()=" + getTitulo() + ", getContenido()=" + getContenido()
				+ ", getImagen()=" + getImagen() + ", getCategoria()=" + getCategoria() + ", getFechadecreacion()="
				+ getFechadecreacion() + ", getUsuario()=" + getUsuario() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

	
	
	
}
