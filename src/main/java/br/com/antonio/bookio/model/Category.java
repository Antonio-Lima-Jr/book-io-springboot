package br.com.antonio.bookio.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
  @NotEmpty(message = "Campo NOME é requerido")
  @Length(min = 2, max = 100, message = "O campo nome deve ter entre 2 a 100 caracteres")
  private String name;
  @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
  @Length(min = 2, max = 200, message = "O campo descrição deve ter entre 2 a 200 caracteres")
  private String description;
  @OneToMany(mappedBy = "category")
  private List<Book> books;

  public Category(@NonNull String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Category() {
  }
}
