package br.com.antonio.bookio.services.exceptions;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 23:49
 */
public class DataIntegrityViolationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DataIntegrityViolationException(String message) {
    super(message);
  }

  public DataIntegrityViolationException(String message, Throwable cause) {
    super(message, cause);
  }
}
