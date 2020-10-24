package com.algaworks.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.model.enums.StatusOrdemServico;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository repo;
	
	@Autowired
	private ClienteRepository clienteRepo;

	
	public OrdemServico salvar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepo.findById(ordemServico.getCliente().getId()).orElseThrow(() -> new NegocioException("Cliente não encontrado!"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return repo.save(ordemServico);
		
	}
}
