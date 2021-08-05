package br.com.rvz.pedidos.services;

import java.util.Optional;

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
	
	public Address recordddress(Address address) throws IllegalArgumentException {
		this.LOG.info("Gravando novo endereço na base de dados!");
		return this.addressRepository.save(address);
	}

	public Address findAddressById(Long id) {
		Optional<Address> addressOptional = addressRepository.findById(id);
		
		if (addressOptional.isEmpty()) {
			throw new RuntimeException("nenhum endereço localizado com o id " + id);
		}
		
		return addressOptional.get();
	}
}
