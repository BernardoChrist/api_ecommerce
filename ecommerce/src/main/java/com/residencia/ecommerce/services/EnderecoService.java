package com.residencia.ecommerce.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.ecommerce.dto.EnderecoWsDTO;
import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepo;

	public List<Endereco> listarEnderecos() {
		return enderecoRepo.findAll();
	}

	public Endereco buscarEnderecoPorId(Long id) {

		return enderecoRepo.findById(id).orElse(null);
	}

	public Endereco salvarEndereco(Endereco endereco) {
		return enderecoRepo.save(endereco);
	}

	public Endereco atualizarEndereco(Endereco endereco) {
		return enderecoRepo.save(endereco);
	}

	public Boolean deletarEndereco(Endereco endereco) {
		if (endereco == null) {
			return false;
		}
		Endereco enderecoExistente = buscarEnderecoPorId(endereco.getIdEndereco());

		if (enderecoExistente == null) {
			return false;
		}

		enderecoRepo.delete(endereco);

		Endereco enderecoContinuaExistindo = buscarEnderecoPorId(endereco.getIdEndereco());

		if (enderecoContinuaExistindo == null) {
			return true;
		}

		return false;
	}

	public EnderecoWsDTO consultaCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "viacep.com.br/ws/{cep}/json/";

		Map<String, String> params = new HashMap<String, String>();

		params.put("cep", cep);

		EnderecoWsDTO receitaDto = restTemplate.getForObject(uri, EnderecoWsDTO.class, params);

		return receitaDto;
	}
	
	public EnderecoWsDTO getEnderecoResumidoPorId(Long id) {

		Endereco endereco = enderecoRepo.findById(id).orElse(null);

		if (endereco != null) {
			EnderecoWsDTO enderecoResDTO = new EnderecoWsDTO(endereco.getRua(), endereco.getBairro(), endereco.getCidade(), endereco.getUf());
			
			return enderecoResDTO;
		}
		return null;
	}
}
