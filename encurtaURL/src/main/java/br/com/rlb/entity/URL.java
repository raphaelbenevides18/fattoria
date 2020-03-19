package br.com.rlb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_url")
public class URL implements Serializable{

	private static final long serialVersionUID = -7657531918696346692L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long idURL;
	
	@NotNull(message = "url não pode ser nula.")
	@Size(min=6, max=2000)
	@Column(unique = true)
	private String originalURL;
	@Column
	@Size(min=1)
	private String shortURL;
	
	public URL() {
		
	}

	public URL(Long idURL, @NotNull(message = "url não pode ser nula.") @Size(min = 6, max = 2000) String originalURL,
			@Size(min = 1) String shortURL) {
		super();
		this.idURL = idURL;
		this.originalURL = originalURL;
		this.shortURL = shortURL;
	}

	@Override
	public String toString() {
		return "URL [idURL=" + idURL + ", originalURL=" + originalURL + ", shortURL=" + shortURL + "]";
	}

	public Long getIdURL() {
		return idURL;
	}

	public void setIdURL(Long idURL) {
		this.idURL = idURL;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	
	
	
	

}
