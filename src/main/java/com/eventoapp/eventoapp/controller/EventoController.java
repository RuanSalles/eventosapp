package com.eventoapp.eventoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping("/index")
	public String index () {
		return "index";
	}
	
	@RequestMapping (value="/CadastroEvento", method = RequestMethod.GET)
	public String cadEvento () {
		return "/cadastrar_evento";
	}
	
	@RequestMapping(value="/CadastroEvento", method=RequestMethod.POST)
	public String exibirPagina (Evento evento) {
		er.save(evento);
		return "cadastrar_evento";
	}
	
	@RequestMapping("/eventos")
	public ModelAndView listarEventos () {
		
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
		
	}

}
