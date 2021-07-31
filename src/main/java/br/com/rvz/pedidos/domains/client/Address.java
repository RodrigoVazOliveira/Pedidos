package br.com.rvz.pedidos.domains.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class para modelo de endereços do cliente 
 * @author Rodrigo Vaz De Oliveira
 * @category modelos
 *
 */
@Entity
@Table("enderecos")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 150, nullable = false)
	private String publicPlace;
	
	@Column(length = 10, nullable = false)
	private String zipCode;
	
	@Column(length = 45, nullable = false)
	private String district;
	
	@Column(length = 45, nullable = false)
	private String city;
	
	@Column(length = 10, nullable = false)
	private String number;
	
	@Column(length = 45, nullable = false)
	private String complement;
	
	@Column(length = 45, nullable = false)
	private String state;

	public Address() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
