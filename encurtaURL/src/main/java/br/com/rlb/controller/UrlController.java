package br.com.rlb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rlb.entity.URL;
import br.com.rlb.repository.URLRepository;

@ResponseBody
@RequestMapping({"/url"})
@RestController
public class UrlController {
	
	@Autowired
	URLRepository dao;
	
	@GetMapping
	public List<URL> findAll(){
		return dao.findAll();
	}
	
	@GetMapping(path = {"/{idURL}"})
	public ResponseEntity<?> findById(@PathVariable Long idURL) {
		return dao.findById(idURL).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.badRequest().build());
		
	}
	
	@PostMapping
	public URL gravar(@RequestBody URL url) {
		return dao.save(url);
		
	}
	
	@PutMapping(value = "/{idURL}")
	public ResponseEntity update(@PathVariable("idURL") Long idURL, @RequestBody URL url) {
		return dao.findById(idURL).map(record -> {
			record.setIdURL(url.getIdURL());
			record.setOriginalURL(url.getOriginalURL());
			record.setShortURL(url.getShortURL());
			URL update = dao.save(record);
			return ResponseEntity.ok().body(update);
		}).orElse(ResponseEntity.badRequest().build());
		
	}
	
	@DeleteMapping(path = {"/{idURL}"})
	public ResponseEntity<?> delete(@PathVariable("idURL") Long idURL){
		return dao.findById(idURL).map(record ->{
			dao.deleteById(idURL);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.badRequest().build());
	}
	
	

}
