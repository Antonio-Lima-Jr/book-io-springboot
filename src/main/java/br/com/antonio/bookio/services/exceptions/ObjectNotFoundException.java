package br.com.antonio.bookio.services.exceptions;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 21:33
 */
public class ObjectNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ObjectNotFoundException(String message) {
    super(message);
  }

  public ObjectNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
