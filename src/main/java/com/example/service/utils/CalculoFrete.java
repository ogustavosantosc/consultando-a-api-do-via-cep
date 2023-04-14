package com.example.service.utils;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.example.model.dto.EnderecoDto;

public class CalculoFrete {

	public static EnderecoDto calculaFrete(EnderecoDto enderecoDto) {
		if (enderecoDto.getEstado().equals("SP") || enderecoDto.getEstado().equals("RJ")
				|| enderecoDto.getEstado().equals("MG") || enderecoDto.getEstado().equals("ES")) {

			enderecoDto.setFrete(BigDecimal.valueOf(7.85));

			return enderecoDto;

		}

		if (enderecoDto.getEstado().equals("AM") || enderecoDto.getEstado().equals("PA")
				|| enderecoDto.getEstado().equals("AC") || enderecoDto.getEstado().equals("RO")
				|| enderecoDto.getEstado().equals("RR") || enderecoDto.getEstado().equals("AP")
				|| enderecoDto.getEstado().equals("TO")) {

			enderecoDto.setFrete(BigDecimal.valueOf(20.83));

			return enderecoDto;
		}

		if (enderecoDto.getEstado().equals("GO") || enderecoDto.getEstado().equals("MT")
				|| enderecoDto.getEstado().equals("MS") || enderecoDto.getEstado().equals("DF")) {

			enderecoDto.setFrete(BigDecimal.valueOf(12.50));

			return enderecoDto;

		}

		if (enderecoDto.getEstado().equals("PR") || enderecoDto.getEstado().equals("SC")
				|| enderecoDto.getEstado().equals("RS")) {

			enderecoDto.setFrete(BigDecimal.valueOf(17.30));

			return enderecoDto;

		}

		enderecoDto.setFrete(BigDecimal.valueOf(15.98));

		return enderecoDto;
	}

}
