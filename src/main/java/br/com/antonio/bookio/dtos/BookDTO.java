package br.com.antonio.bookio.dtos;

import br.com.antonio.bookio.model.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 30/06/2021 - 00:36
 */
@Getter
@Setter
@ToString
public class BookDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String titulo;

  public BookDTO(Book book) {
    this.id = book.getId();
    this.titulo = book.getTitle();
  }
}
