package br.com.antonio.bookio.controllers.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 30/06/2021 - 20:21
 */
@Getter
@Setter
public class fieldValidMessages implements Serializable {

  private static final long serialVersionUID = 1L;

  private String fieldName;
  private String message;

  public fieldValidMessages() {
  }

  public fieldValidMessages(String fieldName, String message) {
    this.fieldName = fieldName;
    this.message = message;
  }
}
