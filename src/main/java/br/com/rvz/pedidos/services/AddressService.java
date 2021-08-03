package br.com.rvz.pedidos.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.rvz.pedidos.domains.client.Address;
import br.com.rvz.pedidos.repositories.AddressRepository;

@Service
public class AddressService {
	
	private final AddressRepository addressRepository;
	private final Logger LOG = LogManager.getLogger(AddressService.class);

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	public void saveAddress(Address address) throws IllegalArgumentException {
		LOG.info("Gravando novo endereço na base de dados!");
		this.addressRepository.save(address);
	}
}
