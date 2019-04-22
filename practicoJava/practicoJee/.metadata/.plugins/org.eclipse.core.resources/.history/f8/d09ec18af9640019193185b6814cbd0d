package com.practico.DAO;

import java.util.List;

import javax.ejb.Local;

import com.practico.datatype.PublicacionDataType;
import com.practico.entyties.Noticia;
import com.practico.entyties.Publicacion;

@Local
public interface PublicacionDaoI {
	
	void adicionarPublicacion(PublicacionDataType publicacionData,long id) throws Exception;	
	
	public List<Publicacion> obtenerPublicaciones() throws Exception;
	
	public Publicacion findById(long id);

}
