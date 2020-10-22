package com.eventoapp.eventoapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eventoapp.eventoapp.controller.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{
	
	Evento findByCodigo (Integer codigo);
	
 
 
}
