package br.com.rvz.pedidos.exceptions;

import java.util.List;

public class ResponseArgsInvalid {
	
	private String cause = "Validação de campos!";
	private Integer code = 400;
	private String status = "BAD REQUEST";
	private List<InputError> inputs;
	
	public ResponseArgsInvalid() {
	}

	public ResponseArgsInvalid(List<InputError> inputs) {
		this.inputs = inputs;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<InputError> getInputs() {
		return inputs;
	}

	public void setInputs(List<InputError> inputs) {
		this.inputs = inputs;
	}
}
