package org.proyecto.clases;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Publicacion
 *
 */
@Entity
@NamedQuery(name="Publicacion.getAll", query="SELECT p FROM Publicacion p")
public class Publicacion implements Serializable {

	
	@Id
	//Se debe adicionar estas dos notaciones para configurar un secuencial que esté en la base de datos, para este caso Oracle.
	//El secuencial creado en la base de oracle tiene el nombre GUIA.curso_desarrollador
	//@SequenceGenerator(name="proyecto_publicacion", sequenceName="proyecto_publicacion", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PUBLICACION")
	private long id;
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="URL")
	private String url;
	
	@ManyToOne
	private Noticia noticia;

	public Publicacion() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	
   
}
