package br.com.rvz.pedidos.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HandlerExcepetion extends ResponseEntityExceptionHandler {

	private final static Logger LOG = LogManager.getLogger(HandlerExcepetion.class);
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOG.info("Iniciando geração de campos vazios!");
		ResponseArgsInvalid responseArgsInvalid = new ResponseArgsInvalid(getInputErrors(ex));
		return ResponseEntity.badRequest().body(responseArgsInvalid);
	}
	
	private List<InputError> getInputErrors(MethodArgumentNotValidException ex) {
		List<InputError> inputs = ex.getBindingResult().getFieldErrors()
			.stream()
			.map(fieldError -> new InputError(fieldError.getField(), fieldError.getDefaultMessage())
			).collect (Collectors.toList());
		
		return inputs;
	}
}
