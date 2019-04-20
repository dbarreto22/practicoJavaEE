package org.proyecto.clases;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Noticia
 *
 */
@Entity
@NamedQuery(name="Noticia.getAll", query="SELECT n FROM Noticia n")
public class Noticia implements Serializable {

	@Id
	//Se debe adicionar estas dos notaciones para configurar un secuencial que esté en la base de datos, para este caso Oracle.
	//El secuencial creado en la base de oracle tiene el nombre GUIA.curso_desarrollador
//	@SequenceGenerator(name="proyecto_noticia", sequenceName="proyecto_noticia", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_NOTICIA")
	private long id;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	


	@OneToMany
	private List<Publicacion> publicaciones;

	public Noticia() {
		super();
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
	
   
}
