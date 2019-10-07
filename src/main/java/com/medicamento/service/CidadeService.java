package com.medicamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicamento.domain.Cidade;
import com.medicamento.domain.Estado;
import com.medicamento.repository.CidadeRepository;


@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> findAll(){
		return repo.findAll();
	}
	
	public Cidade findById(Integer id) {
		Optional<Cidade> ocidade = repo.findById(id);
		
		if(!ocidade.isPresent()) {
			throw new IllegalArgumentException("Cidade não encontrada: " + id);
		}
		
		return ocidade.get();
	}

	public List<Cidade> findByEstado(Estado estado) {
		return repo.findByEstado(estado);
	}

	public void save(Cidade cidade) {
		repo.save(cidade);
	}

}
