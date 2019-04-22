package com.practico.datatype;

import java.util.ArrayList;
import java.util.List;

import com.practico.entyties.Noticia;
import com.practico.entyties.Publicacion;

public class Helper {

	/**
	 * Convertor de Entidad a DataType
	 * 
	 * @param entidad
	 * @return
	 */
	public static Noticia ToEntidadN(NoticiaDataType data) {

		List<Publicacion> publicaciones = new ArrayList<Publicacion>();

		if (data.getPublicaciones() != null && !data.getPublicaciones().isEmpty()) {
			
			for (Publicacion pub : publicaciones) {
				publicaciones
				.add(new Publicacion(pub.getId(), pub.getTipo(), pub.getUrl(), new Noticia()));
			}

			

		}

		long id;
		if (data.getId() == null) {
			id = 0;
		} else {
			id = Long.parseLong(data.getId());
		}

		Noticia entidad = new Noticia(id, data.getTitulo(), data.getDescripcion(), publicaciones);

		return entidad;

	}

	public static Publicacion ToEntidadP(PublicacionDataType data) {

		List<Publicacion> publicaciones = new ArrayList<Publicacion>();

		if (data.getNoticia().getPublicaciones() != null && !data.getNoticia().getPublicaciones().isEmpty()) {
			
			for (Publicacion pub : publicaciones) {
				publicaciones.add(new Publicacion(pub.getId(), pub.getTipo(), pub.getUrl(), new Noticia()));
			}

		}
		long id;
		Noticia n;
		
		if (data.getId() == null) {
			id = 0;
		} else {
			id = Long.parseLong(data.getId());
		}

		
		if (data.getNoticia() != null) {
		
		 n = new Noticia(Long.parseLong(data.getNoticia().getId()), data.getNoticia().getTitulo(),
				data.getNoticia().getDescripcion(), publicaciones);
		
		}else {
			n = new Noticia();
		}

		Publicacion entidad = new Publicacion(id, data.getTipo(), data.getUrl(), n);

		return entidad;

	}

}
