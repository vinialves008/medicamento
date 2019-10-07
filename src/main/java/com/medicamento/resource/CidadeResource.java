package com.medicamento.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medicamento.domain.Cidade;
import com.medicamento.domain.Estado;
import com.medicamento.service.CidadeService;
import com.medicamento.service.EstadoService;


@RestController
@RequestMapping(value = "/cidade")
public class CidadeResource {
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Cidade> findAll(){
		return cidadeService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Cidade getCidade(@PathVariable Integer id) {
		return cidadeService.findById(id);
	}
	
	@RequestMapping(value = "/{id}/estado", method = RequestMethod.GET)
	public List<Cidade> getCidadesByEstado(@PathVariable Integer id) {
		Estado estado = estadoService.readById(id);
		
		if(estado.getNome() == null) {
			return new ArrayList<Cidade>();
		}
		
		return cidadeService.findByEstado(estado);
	}
	@RequestMapping(method =  RequestMethod.POST)
	public void save(@RequestBody Cidade cidade) {
		cidadeService.save(cidade);
	}
	

}
