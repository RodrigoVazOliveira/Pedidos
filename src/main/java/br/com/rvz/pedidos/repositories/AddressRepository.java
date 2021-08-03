package br.com.rvz.pedidos.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.rvz.pedidos.domains.client.Address;

/**
 * 
 * Repositŕio do endereço do cliente
 * 
 * @author thomas
 *
 */
public interface AddressRepository extends CrudRepository<Address, Long>{

}
