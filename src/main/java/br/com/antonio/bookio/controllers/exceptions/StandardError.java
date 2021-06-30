package br.com.antonio.bookio.controllers.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 21:44
 */
@Getter
@Setter
public class StandardError {
  private Long timeStamp;
  private Integer status;
  private String error;

  public StandardError() {
  }

  public StandardError(Long timeStamp, Integer status, String error) {
    this.timeStamp = timeStamp;
    this.status = status;
    this.error = error;
  }
}
