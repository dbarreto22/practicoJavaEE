package com.proyectoJee.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.inject.Model;

import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.jboss.logging.Logger;

import com.practico.datatype.NoticiaDataType;
import com.practico.datatype.PublicacionDataType;
import com.practico.negocio.NegocioI;

//@Named("noticiaJSF")
// @ManagedBean(name="noticiaJSF")
//@ViewScoped
@Model
@RequestScoped
public class noticiaBeanManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = org.jboss.logging.Logger.getLogger(noticiaBeanManager.class);

	@EJB
	private NegocioI negocio;

	private String titulo;

	private String descripcion;

	private String tipo;

	private String url;

	private long id ;

	// Lista para guardar as noticias
	private List<NoticiaDataType> listaNoticias = new ArrayList<>();

	private List<SelectItem> listaNoticiasSelected = new ArrayList<SelectItem>();

	private List<PublicacionDataType> listaPublicacion = new ArrayList<>();

	// Vamos a crear un data noticia en la clase controladora para utilizarlo
	// directamente desde la Pagina JSF
	private NoticiaDataType dataNoticia;

	private PublicacionDataType dataPublicacion;

	

	private List<SelectItem> items = new ArrayList<SelectItem>();

	/**
	 * Vamos a inicializar el desarrollador Este metodo siempre se ejecuta luego del
	 * constructor de la clase controladora
	 */
	@PostConstruct
	public void init() {

		this.dataNoticia = new NoticiaDataType();

		this.dataPublicacion = new PublicacionDataType();

		this.listaNoticias = negocio.listarNoticias();

		// ListaNoticiasSelected();

		logger.info("Init");
	}

	/**
	 * Ingresa Notocia
	 * 
	 * @return
	 */
	public String agregarNoticia() {

		logger.info("Adicionar Publicacion");

		logger.info("Titulo: " + this.dataNoticia.getTitulo() + " Descripcion: " + this.dataNoticia.getDescripcion());

		dataNoticia.setTitulo(this.titulo);
		dataNoticia.setDescripcion(this.descripcion);

		negocio.ingresarNoticia(dataNoticia);

		// Resert de la instancia actual, para crear nuevo desarrollador
		dataNoticia = new NoticiaDataType();

		return "success";
	}

	public String agregarPublicacion() {

		NoticiaDataType dataNoticiaP = negocio.getByIdN(this.id);

		logger.info("Adicionar Publicacion");

		if (dataNoticiaP != null) {

		//	if (dataNoticiaP.getPublicaciones().size() < 11 ) {

				dataPublicacion.setTipo(this.tipo);

				dataPublicacion.setUrl(this.url);
				
				dataPublicacion.setNoticia(dataNoticiaP);

				logger.info("Tipo: " + this.dataPublicacion.getTipo() + " URL: " + this.dataPublicacion.getUrl());

				logger.info(dataNoticiaP);

				negocio.ingresarPublicacion(dataPublicacion);

				// Resert de la instancia actual, para crear nuevo desarrollador
				dataNoticia = new NoticiaDataType();
			//}
		}else {
			// mensaje de error y detener la continuidad del programa
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccionar Noticia", null));

		}
		return "success";
	}

	public List<SelectItem> ListaNoticiasSelected() {

		for (NoticiaDataType noticia : negocio.listarNoticias()) {
			items.add(new SelectItem(noticia.getId(), noticia.getTitulo(), noticia.getDescripcion()));
		}
		return items;
	}

	public String navegar() {

		return "listar";
	}


	public List<PublicacionDataType> listarPublicaciones() {

		// Validaciones de Pantalla de Presentación del lado del servidor Ej: Sexo
		if (!this.listaPublicacion.isEmpty()) {

			this.listaPublicacion = negocio.listarPublicaciones();

			logger.info(listaPublicacion);
			return listaPublicacion;

		} else {

			// mensaje de error y detener la continuidad del programa
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No existen datos a mostrar", null));

			return null;

		}
	}

	public noticiaBeanManager() {
		super();
	}

	public NoticiaDataType getNoticia() {
		return dataNoticia;
	}

	public void setNoticia(NoticiaDataType noticia) {
		this.dataNoticia = noticia;
	}

	public List<NoticiaDataType> getListaNoticias() {
		return listaNoticias;
	}

	public void setListaNoticias(List<NoticiaDataType> listaNoticias) {
		this.listaNoticias = listaNoticias;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public List<PublicacionDataType> getListaPublicacion() {
		return listaPublicacion;
	}

	public void setListaPublicacion(List<PublicacionDataType> listaPublicacion) {
		this.listaPublicacion = listaPublicacion;
	}

	public NoticiaDataType getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(NoticiaDataType dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

	public PublicacionDataType getDataPublicacion() {
		return dataPublicacion;
	}

	public void setDataPublicacion(PublicacionDataType dataPublicacion) {
		this.dataPublicacion = dataPublicacion;
	}

	public List<SelectItem> getListaNoticiasSelected() {
		return listaNoticiasSelected;
	}

	public void setListaNoticiasSelected(List<SelectItem> listaNoticiasSelected) {
		this.listaNoticiasSelected = listaNoticiasSelected;
	}

	public List<SelectItem> getItems() {
		return items;
	}

	public void setItems(List<SelectItem> items) {
		this.items = items;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
