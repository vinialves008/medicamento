package com.medicamento.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.medicamento.domain.Estado;
import com.medicamento.service.EstadoService;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Estado estado){
		service.create(estado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
