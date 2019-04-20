package org.proyectoJee.REST;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.proyecto.DAO.NoticiaDaoImp;
import org.proyecto.clases.Noticia;

@Path("/noticia")
@RequestScoped
public class RESTServiceNoticia {
	
	@Inject
    NoticiaDaoImp noticiaDao;

    @GET
    @Produces
    public List<Noticia> listAllMembers() {
        return noticiaDao.obtenerNoticias();
    }

}
