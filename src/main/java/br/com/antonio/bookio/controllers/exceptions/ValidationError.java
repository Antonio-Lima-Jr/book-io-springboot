package br.com.antonio.bookio.controllers.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 30/06/2021 - 22:54
 */
@Getter
@Setter
public class ValidationError extends StandardError {

  private List<fieldValidMessages> errors = new ArrayList<>();

  public ValidationError() {}

  public ValidationError(Long timeStamp, Integer status, String error) {
    super(timeStamp, status, error);
  }

  public void addError(String fieldName, String message) {
    errors.add(new fieldValidMessages(fieldName, message));
  }
}
