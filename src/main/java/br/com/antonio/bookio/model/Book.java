package br.com.antonio.bookio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Modelo de Objeto Relacional.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 04:47
 */
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book implements Serializable {
  private static final long serialVersionUID = 2L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  private Long id;

  @NotEmpty(message = "Campo TITULO é requerido")
  @Length(min = 2, max = 50, message = "O campo titulo deve ter entre 2 a 50 caracteres")
  private String title;

  @NotEmpty(message = "Campo AUTHORNAME é requerido")
  @Length(min = 2, max = 70, message = "O campo authorName deve ter entre 2 a 70 caracteres")
  private String authorName;

  @NotEmpty(message = "Campo DESCRIPTION é requerido")
  @Length(min = 2, max = 200, message = "O campo description deve ter entre 2 a 200 caracteres")
  private String description;

  @NotEmpty(message = "Campo BOOK é requerido")
  @Length(min = 10, max = 2000000, message = "O campo book deve ter entre 2 a 2000000 caracteres")
  private String book;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @ManyToOne()
  private Category category;

  public Book(@NonNull String title, String authorName, String description, @NonNull String book, @NonNull Category category) {

    this.title = title;
    this.authorName = authorName;
    this.description = description;
    this.book = book;
    this.category = category;
  }

  public Book() {
  }
}
