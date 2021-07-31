package br.com.rvz.pedidos.domains;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table("clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 45, nullable = false)
	private String nameComplete;
	
	@Column(nullable = false)
	private LocalDate dateBirthday;
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@Column(nullable = false, length = 15)
	private String cpf;
	
	@ManyToOne
	private Endereco endereco;
	
	@ManyToMany
	private List<Cartoes> cartoes;

	public Long getId() {
		return id;
	}

	public Cliente() {
		
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Cartoes> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartoes> cartoes) {
		this.cartoes = cartoes;
	}
}
