package com.practico.datatype;

import java.util.List;

import com.practico.entyties.Publicacion;

public class NoticiaDataType {

	private String id;
	private String titulo;
	private String descripcion;
	private List<PublicacionDataType> publicaciones;
	
	
	public NoticiaDataType() {
		super();
	}
	
	public NoticiaDataType(String id,String titulo, String descripcion, List<PublicacionDataType> publicaciones) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.publicaciones = publicaciones;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<PublicacionDataType> getPublicaciones() {
		return publicaciones;
	}
	public void setPublicaciones(List<PublicacionDataType> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	
	
}
