package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.dto.EnderecoDto;
import com.example.service.utils.CalculoFrete;

@SpringBootTest
class ViacepApplicationTests {
	
	@Test
	public void TestCalculaFreteRegiaoSudeste() {
		EnderecoDto enderecoDto =  CalculoFrete.calculaFrete(builEndereco("SP"));
		
		assertEquals(enderecoDto.getFrete(), BigDecimal.valueOf(7.85));
		
	}
	
	@Test
	public void TestCalculaFreteRegiaoNorte() {
		EnderecoDto enderecoDto =  CalculoFrete.calculaFrete(builEndereco("AM"));
		
		assertEquals(enderecoDto.getFrete(), BigDecimal.valueOf(20.83));
		
	}
	
	@Test
	public void TestCalculaFreteRegiaoCentroOeste() {
		EnderecoDto enderecoDto =  CalculoFrete.calculaFrete(builEndereco("MT"));
		
		assertEquals(enderecoDto.getFrete(), BigDecimal.valueOf(12.50));
		
	}
	
	@Test
	public void TestCalculaFreteRegiaoSul() {
		EnderecoDto enderecoDto =  CalculoFrete.calculaFrete(builEndereco("PR"));
		
		assertEquals(enderecoDto.getFrete(), BigDecimal.valueOf(17.30));
		
	}
	
	@Test
	public void TestCalculaFreteRegiaoNordeste() {
		EnderecoDto enderecoDto =  CalculoFrete.calculaFrete(builEndereco("MA"));
		
		assertEquals(enderecoDto.getFrete(), BigDecimal.valueOf(15.98));
		
	}
	
	
	public EnderecoDto builEndereco(String estado) {
		EnderecoDto enderecoDto = new EnderecoDto();
		
		enderecoDto.setEstado(estado);
		
		return enderecoDto;
	}

}
