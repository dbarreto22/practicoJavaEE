package com.practico.datatype;



import com.practico.entyties.Noticia;

public class PublicacionDataType {

	private String id;
	private String tipo;
	private String url;
	private NoticiaDataType noticia;

	
	public PublicacionDataType() {
		super();
	}
	
	public PublicacionDataType(String id,String tipo, String url,NoticiaDataType noticia ) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.url = url;
		this.noticia= noticia;
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
	public NoticiaDataType getNoticia() {
		return noticia;
	}
	public void setNoticia(NoticiaDataType noticia) {
		this.noticia = noticia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
}
