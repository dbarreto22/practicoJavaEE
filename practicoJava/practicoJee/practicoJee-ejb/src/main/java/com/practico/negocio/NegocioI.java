package com.practico.negocio;

import java.util.List;

import com.practico.datatype.NoticiaDataType;
import com.practico.datatype.PublicacionDataType;
import com.practico.entyties.Publicacion;

public interface NegocioI {
	
	public void ingresarNoticia(NoticiaDataType noticia);
	
	public void ingresarPublicacion (PublicacionDataType publicacionData, long id);
	
	public List<NoticiaDataType> listarNoticias();
	
	public List<PublicacionDataType> listarPublicaciones();
	
	public PublicacionDataType getByIdP(long id) ;
	
	public NoticiaDataType getByIdN(long id) ;

}
