package br.com.rlb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Url implements Serializable{

	private static final long serialVersionUID = -7657531918696346692L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long idurl;
	
	@NotNull(message = "url não pode ser nula.")
	@Size(min=6, max=2000)
	@Column(unique = true)
	private String url;
	@Column
	@Size(min=1)
	private String shorturl;
	
	public Url() {
	
	}
	
	public Url(Long idurl, @NotNull(message = "url não pode ser nula.") @Size(min = 6, max = 2000) String url,
			@Size(min = 1) String shorturl) {
		super();
		this.idurl = idurl;
		this.url = url;
		this.shorturl = shorturl;
	}

	public Url(Long idurl, @NotNull(message = "url não pode ser nula.") @Size(min = 6, max = 2000) String url) {
		super();
		this.idurl = idurl;
		this.url = url;
	}

	@Override
	public String toString() {
		return "Url [idurl=" + idurl + ", url=" + url + ", shorturl=" + shorturl + "]";
	}

	public Long getIdurl() {
		return idurl;
	}

	public void setIdurl(Long idurl) {
		this.idurl = idurl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShorturl() {
		return shorturl;
	}

	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}
	
	
	
	
	
	

}
