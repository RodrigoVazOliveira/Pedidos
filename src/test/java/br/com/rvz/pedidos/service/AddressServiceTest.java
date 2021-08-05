package br.com.rvz.pedidos.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import br.com.rvz.pedidos.domains.client.Address;
import br.com.rvz.pedidos.repositories.AddressRepository;
import br.com.rvz.pedidos.services.AddressService;

@SpringBootTest
@ContextConfiguration(classes = AddressService.class)
public class AddressServiceTest {
	
	
	private static final Logger LOG = LogManager.getLogger(AddressServiceTest.class);
	
	@MockBean
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressService addressService;
	
	private Address addressSend;
	private Address addressReturn;
	
	@BeforeEach
	public void setup() {
		this.addressSend = new Address();
		this.addressSend.setCity("Uberlãndia");
		this.addressSend.setComplement("CASA");
		this.addressSend.setDistrict("Jardim Brasília");
		this.addressSend.setNumber("21");
		this.addressSend.setPublicPlace("Rua Plutao");
		this.addressSend.setState("Minas Gerais");
		
		this.addressReturn = new Address();
		this.addressReturn.setCity("Uberlãndia");
		this.addressReturn.setComplement("CASA");
		this.addressReturn.setDistrict("Jardim Brasília");
		this.addressReturn.setNumber("21");
		this.addressReturn.setPublicPlace("Rua Plutao");
		this.addressReturn.setState("Minas Gerais");
		this.addressReturn.setId(1L);
	}

	@Test
	public void testRecordAddressWithSuccess() {
		LOG.info("Iniciando teste com sucesso do método recordAddress!");
		when(this.addressRepository.save(any())).thenReturn(this.addressReturn);
		Address testActual = this.addressService.recordddress(this.addressSend);
		Assertions.assertEquals(testActual, this.addressReturn);
	}
	
	@Test
	public void testRecordAddressWithErrorException() {
		LOG.info("Iniciando teste com erro do método recordAddress!");
		when(addressRepository.save(any())).thenThrow(IllegalArgumentException.class);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.addressService.recordddress(null);
		});
	}
	
	@Test
	public void testFindAllAddressByIdWithSuccess() {
		LOG.info("Iniciando teste de buscar todos endereços do cliente com id do endereco ecom sucesso!");
		Optional<Address> addressOptional = Optional.of(this.addressReturn);
		when(addressRepository.findById(Mockito.anyLong())).thenReturn(addressOptional);
		Address expectActual = this.addressService.findAddressById(1L);
		Assertions.assertEquals(expectActual, this.addressReturn);
	}
 }
