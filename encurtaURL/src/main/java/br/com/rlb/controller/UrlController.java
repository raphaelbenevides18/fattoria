package br.com.rlb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.rlb.entity.Url;
import br.com.rlb.repository.UrlRepository;



@Controller
public class UrlController {
	
	@Autowired
	private UrlRepository urldao;
	
	@GetMapping("/")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("index");
		List<Url> lista = (List<Url>) urldao.findAll();
		mv.addObject("msg", "Bem-vindo ao encurtador de URL");
		mv.addObject("lista", lista);
		return mv;
	}
	
	@PostMapping("/gravar")
	public ModelAndView gravar(@RequestParam ("url") String url,
			@RequestParam ("shorturl_hidden") String shorturl_hidden
			) {
		ModelAndView mv = new ModelAndView("index");
				
		try {
			Url u = new Url(null, url, shorturl_hidden);

			urldao.save(u);
			mv.addObject("lista", urldao.findAll());
			mv.addObject("msg", "URL gravada");

		}catch (Exception ex) {
			mv.addObject("msg", "Dados inválidos");
			mv.addObject("lista", urldao.findAll());
		}
		return mv;
	}
	
	@GetMapping(value="/excluir/{idurl}")
	public ModelAndView excluirID(@PathVariable Long idurl) {
		ModelAndView mv = new ModelAndView("index");
		try {
			Url resposta = urldao.findById(idurl).get();
			urldao.delete(resposta);
			List<Url> lista = (List<Url>) urldao.findAll();
			mv.addObject("msg", "Exclusão pelo ID");
			mv.addObject("lista", lista);
			
		}catch (Exception ex) {	
		}
		return mv;
	}
	
	@GetMapping(value="/editar/{idurl}")
	public ModelAndView editar(@PathVariable Long idurl) {
		ModelAndView mv = new ModelAndView("alterarUrl");
		try {
			Url resposta = urldao.findById(idurl).get();
			
			mv.addObject("url", resposta);
			mv.addObject("msg", "Alteração de URLs");
			
		}catch (Exception ex) {	
		}
		return mv;
	}
	
	@PostMapping(value="/editar/alterar", 
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces=MediaType.TEXT_PLAIN_VALUE)
			
		public ModelAndView alterar(@RequestParam String idurl,
				@RequestParam String url,
				@RequestParam String shorturl_hidden
				) {
			ModelAndView mv = new ModelAndView("index");
			try {
				Url u = new Url(new Long(idurl), url, shorturl_hidden);
				urldao.save(u);
				mv.addObject("lista", urldao.findAll());
				mv.addObject("msg", "Dados alterados");
				
			}catch (Exception ex) {
				mv.addObject("msg", "Erro");
				
			}
			

			return mv;
		} 


}
