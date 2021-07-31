package br.com.rvz.pedidos.domains.client;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.rvz.pedidos.domains.Card;

@Entity
@Table("clientes")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 60, nullable = false)
	private String nameComplete;
	
	@Column(nullable = false)
	private LocalDate dateBirthday;
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@Column(nullable = false, length = 15)
	private String cpf;
	
	@ManyToOne
	private Address endereco;
	
	@ManyToMany
	private List<Card> cards;

	public Long getId() {
		return id;
	}

	public Client() {
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNameComplete() {
		return nameComplete;
	}

	public void setNameComplete(String nameComplete) {
		this.nameComplete = nameComplete;
	}

	public LocalDate getDateBirthday() {
		return dateBirthday;
	}

	public void setDateBirthday(LocalDate dateBirthday) {
		this.dateBirthday = dateBirthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Address getEndereco() {
		return endereco;
	}

	public void setEndereco(Address endereco) {
		this.endereco = endereco;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}
