package br.com.rvz.pedidos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import br.com.rvz.pedidos.domains.client.Address;
import br.com.rvz.pedidos.dto.client.entrada.AddressDTO;
import br.com.rvz.pedidos.exceptions.InputError;
import br.com.rvz.pedidos.exceptions.ResponseArgsInvalid;
import br.com.rvz.pedidos.services.AddressService;

@WebMvcTest
public class AddressControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AddressService service;
	
	private AddressDTO addressDtoSend;
	private Address addressResponseSucess;
	private ResponseArgsInvalid responseArgsInvalid;
	private List<InputError> inputsErrors;
	
	private final static Logger log = LogManager.getLogger(AddressControllerTest.class);

	
	@BeforeEach
	public void init() {
		log.info("Montando objetos para testes");
		this.addressDtoSend = new AddressDTO();
		this.addressDtoSend.setCity("Uberlândia!");
		this.addressDtoSend.setComplement("Casa");
		this.addressDtoSend.setDistrict("Bairro");
		this.addressDtoSend.setNumber("2121");
		this.addressDtoSend.setPublicPlace("Rua dos bobos");
		this.addressDtoSend.setState("Minas Gerais");
		this.addressDtoSend.setZipCode("123213");
		
		this.addressResponseSucess = this.addressDtoSend.convertDtoToModel();
		this.addressResponseSucess.setId(1L);
		
		this.responseArgsInvalid = new ResponseArgsInvalid();
		this.inputsErrors = new ArrayList<>();
		
		InputError inputError3 = new InputError();
		inputError3.setInput("city");
		inputError3.setMessage("Nome do city em branco");
		
		InputError inputError4 = new InputError();
		inputError4.setInput("city");
		inputError4.setMessage("Campo city vazio!");
		
		this.inputsErrors.add(inputError4);
		this.inputsErrors.add(inputError3);
		
		this.responseArgsInvalid.setInputs(this.inputsErrors);
	}
	
	@Test
	public void testMockEndPointPostAddressWithSucess() throws Exception {
		log.info("teste com sucesso do endpoint post addresses");
		JsonMapper helper = new JsonMapper();
		String jsonRequest = helper.writeValueAsString(this.addressDtoSend);
		String jsonResponse = helper.writeValueAsString(this.addressResponseSucess);
		
		Mockito.when(this.service.recordddress(Mockito.any(Address.class))).thenReturn(this.addressResponseSucess);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/address/")
				.contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
		.andExpect(MockMvcResultMatchers.content().json(jsonResponse))
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(201));
	}
	
	@Test
	public void testMockEndPointAddressWithErrorBadRequest() throws Exception {
		log.info("Teste com dados incorretos no endpoint post address");
		JsonMapper helper = new JsonMapper();
		this.addressDtoSend.setCity("");
		String jsonRequest = helper.writeValueAsString(this.addressDtoSend);
		String jsonResponse = helper.writeValueAsString(this.responseArgsInvalid);
		
		Mockito.when(this.service.recordddress(Mockito.any(Address.class))).thenReturn(this.addressResponseSucess);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/address/")
				.contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
		.andExpect(MockMvcResultMatchers.content().json(jsonResponse))
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400));
	}
}
