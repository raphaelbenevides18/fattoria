package br.com.rlb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rlb.entity.URL;

@Repository
public interface URLRepository extends JpaRepository<URL, Long>{
	
	public URL findByOriginalURL(String originalURL);
	

}
