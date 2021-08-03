package br.com.rvz.pedidos.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.rvz.pedidos.domains.client.Client;

/**
 * Repositório do cliente
 * 
 * @author thomas
 *
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

}
