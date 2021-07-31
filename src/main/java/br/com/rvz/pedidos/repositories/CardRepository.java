package br.com.rvz.pedidos.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.rvz.pedidos.domains.Card;

public interface CardRepository extends CrudRepository<Card, Long> {

}