package br.com.rvz.pedidos.dto.client.entrada;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.rvz.pedidos.domains.client.Address;

/**
 * Entrada de dados para gravar o endereço
 * 
 * @author Rodrigo Vaz
 *
 */
public class AddressDTO {
	
	@NotNull(message = "Nome do publicPlace não informado")
	@NotBlank(message = "Nome do publicPlace em branco")
	@NotEmpty(message = "Campo publicPlace vazio!")
	@Max(value = 150, message = "O máximo de caractere é de 150 no publicPlace!")
	private String publicPlace;
	
	@NotNull(message = "Nome do publicPlace não informado")
	@NotBlank(message = "Nome do publicPlace em branco")
	@NotEmpty(message = "Campo publicPlace vazio!")
	@Max(value = 10, message = "O máximo de caractere é de 10 no publicPlace!")
	private String zipCode;
	
	@NotNull(message = "Nome do district não informado")
	@NotBlank(message = "Nome do district em branco")
	@NotEmpty(message = "Campo district vazio!")
	@Max(value = 45, message = "O máximo de caractere é de 45 no district!")
	private String district;
	
	@NotNull(message = "Nome do city não informado")
	@NotBlank(message = "Nome do city em branco")
	@NotEmpty(message = "Campo city vazio!")
	@Max(value = 45, message = "O máximo de caractere é de 45 no city!")
	private String city;
	
	@NotNull(message = "Nome do number não informado")
	@NotBlank(message = "Nome do number em branco")
	@NotEmpty(message = "Campo number vazio!")
	@Max(value = 10, message = "O máximo de caractere é de 10 no number!")
	private String number;
	
	@NotNull(message = "Nome do complement não informado")
	@NotBlank(message = "Nome do complement em branco")
	@NotEmpty(message = "Campo complement vazio!")
	@Max(value = 45, message = "O máximo de caractere é de 45 no complement!")
	private String complement;
	
	@NotNull(message = "Nome do state não informado")
	@NotBlank(message = "Nome do state em branco")
	@NotEmpty(message = "Campo state vazio!")
	@Max(value = 45, message = "O máximo de caractere é de 45 no state!")
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
