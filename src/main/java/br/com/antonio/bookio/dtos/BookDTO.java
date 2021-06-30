package br.com.antonio.bookio.dtos;

import br.com.antonio.bookio.model.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
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
  @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
  @Length(min = 2, max = 200, message = "O campo descrição deve ter entre 2 a 200 caracteres")
  private String titulo;

  public BookDTO(Book book) {
    this.id = book.getId();
    this.titulo = book.getTitle();
  }
}
