package org.proyecto.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.proyecto.clases.Noticia;
import org.proyecto.clases.Publicacion;

@Stateless
public class PublicacionDaoImp implements PublicacionDaoI{
	
	public static final Logger logger = Logger.getLogger(Publicacion.class);
	
	@PersistenceContext(unitName="practicoJava")
	EntityManager em;
	
	@Override
	public void adicionarPublicacion(Noticia noticia, Publicacion publicacion) {
		try {
			
			noticia.getPublicaciones().add(publicacion);
			
			em.merge(noticia);
			
			
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
	
	
	@Override
	public List<Publicacion> obtenerPublicaciones(){
		try {
			
			Query q = em.createNamedQuery("Publicacion.getAll");
			List<Publicacion> publicaciones = (List<Publicacion>)q.getResultList();
			
			return publicaciones;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			throw e;
		}
		
		
	}

}
