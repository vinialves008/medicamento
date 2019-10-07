package com.medicamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicamento.domain.Estado;
import com.medicamento.repository.EstadoRepository;
import com.medicamento.service.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public void create(Estado estado) {
		repo.save(estado);
	}
	public List<Estado> read() {
		return repo.findAll();
	}
	public Estado readById(Integer id) {
		Optional<Estado> oestado = repo.findById(id);
		
		if (oestado.isPresent()) {
			return oestado.get();
		}
		throw new ObjectNotFoundException("Estado não encontrado!");
	}
	public void update(Estado estado) {
		Estado est = this.readById(estado.getId());
		updateData(est, estado);
		
		repo.save(est);
	}
	
	public void delete(Integer id) {
		Estado estado = this.readById(id);
		repo.delete(estado);
	}
	private void updateData(Estado est, Estado estado) {
		est.setNome(estado.getNome());
	}
}
