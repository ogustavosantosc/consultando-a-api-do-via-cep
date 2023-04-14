package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.exception.EnderecoForaLimiteException;
import com.example.exception.EnderecoInvalidoException;
import com.example.model.Endereco;
import com.example.model.EnderecoRequest;
import com.example.model.dto.EnderecoDto;
import com.example.service.utils.CalculoFrete;

@Service
public class EnderecoService {

	public EnderecoDto buscaEndereco(EnderecoRequest enderecoRequest) {

		try {

			String url = "https://viacep.com.br/ws/" + enderecoRequest.getCep() + "/json/";

			RestTemplate restTemplate = new RestTemplate();

			Endereco endereco = restTemplate.getForObject(url, Endereco.class);

			EnderecoDto enderecoResponse = converter(endereco);

			enderecoResponse = CalculoFrete.calculaFrete(enderecoResponse);

			return enderecoResponse;

		} catch (NullPointerException e) {
			throw new EnderecoInvalidoException();

		} catch (HttpClientErrorException e) {
			throw new EnderecoForaLimiteException();
		}

	}

	private EnderecoDto converter(Endereco endereco) {
		EnderecoDto enderecoDto = new EnderecoDto();

		enderecoDto.setCep(endereco.getCep());
		enderecoDto.setRua(endereco.getLogradouro());
		enderecoDto.setComplemento(endereco.getComplemento());
		enderecoDto.setBairro(endereco.getBairro());
		enderecoDto.setCidade(endereco.getLocalidade());
		enderecoDto.setEstado(endereco.getUf());

		return enderecoDto;
	}

}
