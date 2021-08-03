package br.com.rvz.pedidos.dto.client.entrada;

import javax.persistence.Column;

import br.com.rvz.pedidos.domains.client.Address;

/**
 * Entrada de dados para gravar o endereço
 * 
 * @author Rodrigo Vaz
 *
 */
public class AddressDTO {
	
	private String publicPlace;
	private String zipCode;
	private String district;
	private String city;
	private String number;
	private String complement;
	private String state;
	
	public AddressDTO() {
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
	
	public Address convertDtoToModel() {
		Address address = new Address();
		address.setPublicPlace(this.publicPlace);
		address.setZipCode(this.zipCode);
		address.setDistrict(this.district);
		address.setCity(this.city);
		address.setNumber(this.number);
		address.setComplement(this.complement);
		address.setState(this.state);
		
		return address;
	}
}
