package com.proyectoJee.REST;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.apache.camel.Consume;
import org.jboss.logging.Logger;

import com.practico.DAO.NoticiaDaoImp;
import com.practico.DAO.PublicacionDaoImp;
import com.practico.datatype.Helper;
import com.practico.datatype.NoticiaDataType;
import com.practico.datatype.PublicacionDataType;
import com.practico.entyties.Noticia;
import com.practico.entyties.Publicacion;
import com.practico.negocio.NegocioI;
import com.practico.negocio.NegocioImp;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@Path("/")
public class RESTServiceI {

	public static final Logger logger = Logger.getLogger(Noticia.class);
	
	JsonParser parser = new JsonParser();

	@Context
	private UriInfo context;
	
	@EJB
	NegocioI negocio;


	public RESTServiceI() {
		super();
	}

	@GET
	@Path("/noticias")
	@Produces({ "application/json" })
	public List<NoticiaDataType> listarNoticias() {


	//	List<Noticia> noticias = (List<Noticia>) q.getResultList();

		List<NoticiaDataType> listaDataNoticia = negocio.listarNoticias();

		// verificar que la lista tenga al menos un elemento

		return listaDataNoticia;
	}

	@GET
	@Path("/pubicaciones")
	public List<Publicacion> listarPublicaciones() {
		return null;
	}

	@POST
	@Path("/crearNoticia")
	@Consumes({ "application/json" })
	public void crearNoticia(String json) throws Exception {
		String message = "OK";
		try {
				
	            JsonElement jsonTree = parser.parse(json);

	            if (jsonTree.isJsonObject()) {
	                JsonObject jsonObject = jsonTree.getAsJsonObject();
	                String titulo = jsonObject.get("titulo").getAsString();
	                String descripcion = jsonObject.get("descripcion").getAsString();

	                Noticia noticia = new Noticia();
	                List<Publicacion> p = new ArrayList<>();
	                noticia.setDescripcion(descripcion);
	                noticia.setTitulo(titulo);
	                noticia.setPublicaciones(p);
              
	                negocio.ingresarNoticia(noticia.toDataType());;
			

	            }else {
                message = "Esto no es un json o no lo entiendo: " + json;
            }
        } catch (JsonSyntaxException ex) {
            System.out.println("Class:EstudianteServiceImpl: " + ex.getMessage() + " " + json);
            message = ex.getMessage() + " " + json;
        }

	}
	
	@POST
	@Path("/creaPublicacion")
	@Consumes({ "application/json" })
	public void crearPublicacion(String json) throws Exception {
		String message = "OK";
		try {				
	            JsonElement jsonTree = parser.parse(json);

	            if (jsonTree.isJsonObject()) {
	                JsonObject jsonObject = jsonTree.getAsJsonObject();
	                String tipo = jsonObject.get("tipo").getAsString();
	                String url = jsonObject.get("url").getAsString();
	                
	                PublicacionDataType publicacionData = new PublicacionDataType();
	                publicacionData.setTipo(tipo);
	                publicacionData.setUrl(url);
	              
	                long id = jsonObject.get("idNoticia").getAsLong();
	               negocio.ingresarPublicacion(publicacionData, id);
	                
	            }else {
	                message = "Esto no es un json o no lo entiendo: " + json;
	            }

		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}

	}

}
