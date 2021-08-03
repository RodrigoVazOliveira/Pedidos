package br.com.rvz.pedidos.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.rvz.pedidos.domains.client.Address;
import br.com.rvz.pedidos.dto.client.entrada.AddressDTO;
import br.com.rvz.pedidos.services.AddressService;

/**
 * Controle de endpoint address (endereço)
 * 
 * @author Rodrigo Vaz
 *
 */
@RestController
@RequestMapping("address/")
public class AddressController {
	
	private final AddressService addressService;
	private final Logger LOG = LogManager.getLogger(AddressController.class);
	
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Address recordNewAddress(@RequestBody AddressDTO addressDTO) {
		LOG.info("Iniciando processo para salvar os dados");
		try {
			return callServiceSaveAddress(addressDTO.convertDtoToModel());
		} catch (RuntimeException e) {
			LOG.error("Ocorreu um erro no processo de gravar os dados : " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	private Address callServiceSaveAddress(Address address) {
		LOG.info("Chamamndo serviço para persistes os dados");
		return addressService.recordddress(address);
	}
}
