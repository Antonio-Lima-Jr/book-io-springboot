package br.com.antonio.bookio.dtos;

import br.com.antonio.bookio.model.Category;
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
 * @created 29/06/2021 - 22:41
 */
@Getter
@Setter
@ToString
public class CategoryDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  @NotEmpty(message = "Campo NAME é requerido")
  @Length(min = 2, max = 200, message = "O campo name deve ter entre 2 a 100 caracteres")
  private String name;
  @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
  @Length(min = 2, max = 200, message = "O campo descrição deve ter entre 2 a 200 caracteres")
  private String description;

  public CategoryDTO(Category category) {
    this.id = category.getId();
    this.name = category.getName();
    this.description = category.getDescription();
  }

  public CategoryDTO() {
  }
}
