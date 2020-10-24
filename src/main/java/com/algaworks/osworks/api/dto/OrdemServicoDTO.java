package com.algaworks.osworks.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.osworks.domain.model.enums.StatusOrdemServico;

public class OrdemServicoDTO {
	
	private Long id;
	private String descricao;
	private ClienteDTO cliente;
	private BigDecimal preco;
	private StatusOrdemServico statusOrdemServico;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public StatusOrdemServico getStatusOrdemServico() {
		return statusOrdemServico;
	}
	public void setStatusOrdemServico(StatusOrdemServico statusOrdemServico) {
		this.statusOrdemServico = statusOrdemServico;
	}
	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	

}
