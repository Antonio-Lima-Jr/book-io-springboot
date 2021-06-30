package br.com.antonio.bookio.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Modelo de Objeto Relacional..
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 04:44
 */
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Include
  private Long id;
  @NonNull
  private String name;
  private String Description;
  @OneToMany(mappedBy = "category")
  private List<Book> books;

  public Category(@NonNull String name, String description) {
    this.name = name;
    Description = description;
  }

  public Category() {
  }
}
