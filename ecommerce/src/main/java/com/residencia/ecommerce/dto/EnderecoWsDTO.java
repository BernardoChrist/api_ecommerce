package com.residencia.ecommerce.dto;

public class EnderecoWsDTO {
	private String logradouro;
	private String bairro;
	private String localicade;
	private String uf;
	
	
	
	public EnderecoWsDTO(String logradouro, String bairro, String localicade, String uf) {
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localicade = localicade;
		this.uf = uf;
	}
	
	
	
	public EnderecoWsDTO() {
	
	}



	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalicade() {
		return localicade;
	}
	public void setLocalicade(String localicade) {
		this.localicade = localicade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
