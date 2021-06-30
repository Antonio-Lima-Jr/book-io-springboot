package br.com.antonio.bookio.controllers.exceptions;

import br.com.antonio.bookio.services.exceptions.DataIntegrityViolationException;
import br.com.antonio.bookio.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 21:43
 */
@ControllerAdvice
public class ControllerExceptionHandler {
  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest servletRequest) {
    StandardError error = new StandardError(
        System.currentTimeMillis(),
        HttpStatus.NOT_FOUND.value(),
        e.getMessage()
    );
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest servletRequest) {
    StandardError error = new StandardError(
        System.currentTimeMillis(),
        HttpStatus.BAD_REQUEST.value(),
        e.getMessage()
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }
}
