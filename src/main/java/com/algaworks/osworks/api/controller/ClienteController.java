package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar(){
		
		var cliente1 = new Cliente();
		cliente1.setEmail("digo.15rj@gmail.com");
		cliente1.setId(1L);
		cliente1.setNome("Rodrigo");
		cliente1.setTelefone("21997990276");
		var cliente2 = new Cliente();
		cliente2.setEmail("astor.regina@gmail.com");
		cliente2.setId(2L);
		cliente2.setNome("Regina");
		cliente2.setTelefone("21966700951");
		
		return Arrays.asList(cliente1, cliente2);
	}

}
