package org.proyecto.datatype;



import org.proyecto.clases.Noticia;

public class PublicacionDataType {

	private String tipo;
	private String url;
	private Noticia noticia;

	
	public PublicacionDataType() {
		super();
	}
	
	public PublicacionDataType(String tipo, String url, Noticia noticia) {
		super();
		this.tipo = tipo;
		this.url = url;
		this.noticia = noticia;
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
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	
	
	
}
