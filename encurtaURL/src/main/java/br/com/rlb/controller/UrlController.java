package br.com.rlb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@GetMapping("/editar")
	public ModelAndView editar(HttpServletResponse response,
	HttpServletRequest request, HttpSession session) {
	session = request.getSession(true);
	ModelAndView mv = new ModelAndView("alterarUrl");
	mv.addObject("msg", "Edicao de Url");
	mv.addObject("lista", urldao.findAll());
	mv.addObject("url", session.getAttribute("passe"));

	return mv;
	}
	
	@PostMapping("/gravar")
	public void gravar(@RequestParam ("url") String url,
			@RequestParam ("shorturl_hidden") String shorturl_hidden, HttpServletResponse response,
			HttpServletRequest request, HttpSession session) {
		session = request.getSession(true);
	
		try {
			ModelAndView mv = new ModelAndView("index");
			Url u = new Url(null, url, shorturl_hidden);
			urldao.save(u);
			session.setAttribute("lista", urldao.findAll());
			session.setAttribute("msg", "URL gravada");
			response.sendRedirect("/");

		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@GetMapping(value="/excluir/{idurl}")
	public void excluirID(@PathVariable Long idurl,  HttpServletResponse response,
			HttpServletRequest request, HttpSession session) {
		session = request.getSession(true);
		try {
			
			Url resposta = urldao.findById(idurl).get();
			urldao.delete(resposta);
			List<Url> lista = (List<Url>) urldao.findAll();
			session.setAttribute("msg", "Exclusão pelo ID");
			session.setAttribute("lista", lista);
			response.sendRedirect("/");
			
		}catch (Exception ex) {	
			ex.printStackTrace();
		}
	}
	
	@GetMapping(value="/editar/{idurl}")
	public void editar(@PathVariable Long idurl, HttpServletResponse response, 
			HttpServletRequest request, HttpSession session) {
		session = request.getSession(true);
		
		try {
			
			Url resposta = urldao.findById(idurl).get();
			session.setAttribute("url", resposta);
			session.setAttribute("msg", "Alteração de URLs");
			session.setAttribute("passe", resposta);
			response.sendRedirect("/editar");
		}catch (Exception ex) {	
			ex.printStackTrace();
		}
	}
	
	@PostMapping(value="/editar/alterar", 
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces=MediaType.TEXT_PLAIN_VALUE)
		public void alterar(@RequestParam String idurl,
				@RequestParam String url,
				@RequestParam String shorturl_hidden, HttpServletResponse response, 
				HttpServletRequest request, HttpSession session) {
			session = request.getSession(true);
			try {
				Url u = new Url(new Long(idurl), url, shorturl_hidden);
				urldao.save(u);
				session.setAttribute("lista", urldao.findAll());
				session.setAttribute("msg", "Dados alterados");
				response.sendRedirect("/");
			}catch (Exception ex) {
				ex.printStackTrace();
				
			}
		} 


}
