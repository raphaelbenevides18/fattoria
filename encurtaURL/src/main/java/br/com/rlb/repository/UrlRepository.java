package br.com.rlb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rlb.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{
	
	public Url findByUrl(String url);
	

}
