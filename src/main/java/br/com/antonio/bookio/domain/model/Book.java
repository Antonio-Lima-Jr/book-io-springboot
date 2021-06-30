package br.com.antonio.bookio.domain.model;

import lombok.*;

import javax.persistence.*;
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
  @NonNull
  private String title;
  private String authorName;
  private String description;
  @NonNull
  private String book;
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
