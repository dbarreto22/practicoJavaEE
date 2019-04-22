package com.practico.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import org.jboss.logging.Logger;

import com.practico.DAO.NoticiaDaoI;
import com.practico.DAO.PublicacionDaoI;
import com.practico.datatype.Helper;
import com.practico.datatype.NoticiaDataType;
import com.practico.datatype.PublicacionDataType;
import com.practico.entyties.Noticia;
import com.practico.entyties.Publicacion;


@Singleton
public class NegocioImp implements NegocioI{
	
	public static final Logger logger = Logger.getLogger(NegocioImp.class);
	
	@EJB
	NoticiaDaoI noticiadao;
	
	@EJB
	PublicacionDaoI publicacionDao;
	
	@Override
	public void ingresarNoticia(NoticiaDataType noticia) {
		
		try {
			
			logger.info(noticia);
			
			Noticia noticiaEntidad = Helper.ToEntidadN(noticia);
			
			
			noticiadao.adicionarNoticia(noticiaEntidad);
			

		} catch (Exception e) {
			// TODO: handle exception
			
			logger.error(e);
		}
		
	}
	
	@Override
	public void ingresarPublicacion (PublicacionDataType publicacionData) {
		
		try {
			logger.info(publicacionData);
			
					
			
			Publicacion publicacionEntidad = Helper.ToEntidadP(publicacionData);
			
			
			publicacionDao.adicionarPublicacion(publicacionEntidad);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}
		
	}
	

	
	
	@Override
	public List<NoticiaDataType> listarNoticias(){
		
		try {
			
			List<Noticia> listaEntidad = noticiadao.obtenerNoticias();
			
			List<NoticiaDataType> listaDataNoticia = new ArrayList<>();
			
			//verificar que la lista tenga al menos un elemento
			if(listaEntidad!=null && listaEntidad.size()>0) {
				
				//Utilizar la pontencialidad de java 8 lambda
				for (Noticia n : listaEntidad) {
					listaDataNoticia.add(n.toDataType());
				}
				
				for (int i = 0; i < listaEntidad.size(); i++) {
					listaDataNoticia.add(listaEntidad.get(i).toDataType());
				}
				return listaDataNoticia;
			}
			
	
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}
		return null;
		

	}
	

	@Override
	public List<PublicacionDataType> listarPublicaciones(){
		
		try {
			
			List<Publicacion> listaEntidad = publicacionDao.obtenerPublicaciones();
			
			List<PublicacionDataType> listaDataPublicacion = new ArrayList<>();
			
			//verificar que la lista tenga al menos un elemento
			if(listaEntidad!=null && listaEntidad.size()>0) {
				
				for (Publicacion p : listaEntidad) {
					listaDataPublicacion.add(p.toDataType());
				}
				
				return listaDataPublicacion;
			}
			
	
		} catch (Exception e) {
			// TODO: handle exception
	//		logger.error(e);
		}
		return null;
		

	}
	
	@Override
	public PublicacionDataType getByIdP(long id) {
		
		PublicacionDataType dataPublicacion = new PublicacionDataType();
		
		try {
			
			Publicacion publicacion = publicacionDao.findById(id);
			
			if (publicacion != null) {
				
				dataPublicacion = publicacion.toDataType();
				
				
			}
			
	
			
		} catch (Exception e) {
			// TODO: handle exception
			
			logger.error(e);
		}
		
		return dataPublicacion;
		
	}
	
	@Override
	public NoticiaDataType getByIdN(long id) {
		
		NoticiaDataType dataNoticia = new NoticiaDataType();
		
		try {
			
			Noticia noticia = noticiadao.findById(id);
			
			if (noticia != null) {
				
				dataNoticia = noticia.toDataType();
			
			}

			
		} catch (Exception e) {
			// TODO: handle exception
			
			logger.error(e);
		}
		
		return dataNoticia;
		
	}


}
