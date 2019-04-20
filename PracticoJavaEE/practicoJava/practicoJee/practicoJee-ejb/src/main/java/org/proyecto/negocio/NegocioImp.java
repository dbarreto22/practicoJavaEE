package org.proyecto.negocio;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import org.jboss.logging.Logger;
import org.proyecto.DAO.NoticiaDaoI;
import org.proyecto.DAO.PublicacionDaoI;
import org.proyecto.clases.Noticia;
import org.proyecto.clases.Publicacion;
import org.proyecto.datatype.Helper;
import org.proyecto.datatype.NoticiaDataType;
import org.proyecto.datatype.PublicacionDataType;


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
			
			Noticia noticiaEntidad = Helper.convertorDataTypeEntidadNoticia(noticia);
			
			noticiadao.adicionarNoticia(noticiaEntidad);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			logger.error(e);
		}
		
	}
	
	@Override
	public void ingresarPublicacion (NoticiaDataType noticiaData, PublicacionDataType publicacionData) {
		
		try {
			logger.info(publicacionData);
			
			Noticia noticiaentidad = Helper.convertorDataTypeEntidadNoticia(noticiaData);			
			
			Publicacion publicacionEntidad = Helper.convertorDataTypeEntidadpublicacion(publicacionData);
			
			
			publicacionDao.adicionarPublicacion(noticiaentidad, publicacionEntidad);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}
		
	}

}
