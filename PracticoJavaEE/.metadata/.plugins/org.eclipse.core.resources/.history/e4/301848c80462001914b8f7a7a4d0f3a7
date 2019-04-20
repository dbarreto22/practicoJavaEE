package org.proyecto.datatype;

import java.util.ArrayList;
import java.util.List;

import org.proyecto.clases.Noticia;
import org.proyecto.clases.Publicacion;

public class Helper {
	
	public static Noticia convertorDataTypeEntidadNoticia(NoticiaDataType data) {
		
		Noticia noticiaEntidad = new Noticia();
		
		noticiaEntidad.setDescripcion(data.getDescripcion());
		
		noticiaEntidad.setTitulo(data.getTitulo());

		
		//Crear la entidad publicacion
		List<Publicacion> publicaciones = new ArrayList();
		
		publicaciones = data.getPublicaciones();
		
		//setear el sexo		
		noticiaEntidad.setPublicaciones(publicaciones);;
		

		
		return noticiaEntidad;
		
	}
	
	/**
	 * Convertor de Entidad a DataType
	 * @param entidad
	 * @return
	 */
	public static NoticiaDataType convertorDataTypeEntidadNoticia(Noticia entidad) {
		
		NoticiaDataType data = new NoticiaDataType();
		
		data.setDescripcion(entidad.getDescripcion());
		
		data.setTitulo(entidad.getTitulo());
		
		data.setPublicaciones(entidad.getPublicaciones());	

		
		return data;
		
	}
	
	public static PublicacionDataType convertorDataTypeEntidadPublicacion (Publicacion entidad) {
		
		PublicacionDataType data = new PublicacionDataType();
		
		data.setTipo(entidad.getTipo());
		
		data.setUrl(entidad.getUrl());
		
		Noticia p = new Noticia();
		
		p.setDescripcion(entidad.getNoticia().getDescripcion());
		
		p.setTitulo(entidad.getNoticia().getTitulo());
		
		p.setPublicaciones(entidad.getNoticia().getPublicaciones());
		
		data.setNoticia(p);
		
		return data;
		
	}
	
	
	public static Publicacion convertorDataTypeEntidadpublicacion(PublicacionDataType data) {
		
		Publicacion p = new Publicacion();
		
		p.setTipo(data.getTipo());
		
		p.setUrl(data.getUrl());
		
		Noticia n = new Noticia();
		
		n.setDescripcion(data.getNoticia().getDescripcion());
		
		n.setTitulo(data.getNoticia().getTitulo());
		
		n.setPublicaciones(data.getNoticia().getPublicaciones());
		
		p.setNoticia(n);
		
		return p;
		
		
	}

}
