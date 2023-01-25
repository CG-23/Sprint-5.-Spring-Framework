package cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import cat.itacademy.barcelonactiva.gimeno.carlos.s05.t01.n02.model.dto.ErrorDTO;

@RestControllerAdvice
public class Handler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {NotFoundException.class})
	public ResponseEntity<ErrorDTO> handlerNoFoundException(NotFoundException nofoundException) {
		ErrorDTO error = ErrorDTO.builder().httpcode(HttpStatus.NOT_FOUND.value()).message(nofoundException.getMessage()).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
}
