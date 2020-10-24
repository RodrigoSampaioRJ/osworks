package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.api.dto.OrdemServicoDTO;
import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;
import com.algaworks.osworks.domain.service.GestaoOrdemServicoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServico;
	
	@Autowired
	private OrdemServicoRepository repo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico adicionar(@Valid @RequestBody OrdemServico ordemServico) {
		return gestaoOrdemServico.salvar(ordemServico);
		
	}
	
	
	@GetMapping
	public List<OrdemServicoDTO> listar(){

		return toListDTO(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoDTO> buscar (@PathVariable Long id){
		Optional<OrdemServico> ordemServico = repo.findById(id);
		
		if(ordemServico.isPresent()) {
			OrdemServicoDTO ordemDTO = toDTO(ordemServico.get());
			return ResponseEntity.ok(ordemDTO);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	private OrdemServicoDTO toDTO(OrdemServico ordemServico) {
		
		return modelMapper.map(ordemServico, OrdemServicoDTO.class);
	}
	
	private List<OrdemServicoDTO> toListDTO(List<OrdemServico> ordemServicoList){
		
		return ordemServicoList.stream()
				.map(ordemServico -> toDTO(ordemServico))
				.collect(Collectors.toList());
	}
}
