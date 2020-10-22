package com.algaworks.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository repo;

	
	public Cliente salvar(Cliente cliente) {
		
		Cliente clienteExistente = repo.findByEmail(cliente.getEmail());
		
		if(clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente com este email cadastrado");
		}
		
		return repo.save(cliente);
	}
	
	public void deletar(Long id) {
		repo.deleteById(id);
	}
}
