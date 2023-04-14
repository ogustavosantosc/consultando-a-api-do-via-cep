package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.EnderecoForaLimiteException;
import com.example.exception.EnderecoInvalidoException;
import com.example.model.EnderecoRequest;
import com.example.model.dto.EnderecoDto;
import com.example.service.EnderecoService;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@PostMapping
	ResponseEntity<EnderecoDto> buscarEndereco(@RequestBody @Valid EnderecoRequest enderecoRequest) {

		try {

			EnderecoDto enderecoResponse = enderecoService.buscaEndereco(enderecoRequest);

			return ResponseEntity.ok(enderecoResponse);

		} catch (EnderecoInvalidoException e) {

			return ResponseEntity.notFound().build();
		} catch (EnderecoForaLimiteException e) {

			return ResponseEntity.badRequest().build();
		}

		}
	}

