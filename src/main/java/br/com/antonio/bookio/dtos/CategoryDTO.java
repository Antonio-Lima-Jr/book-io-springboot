package br.com.antonio.bookio.dtos;

import br.com.antonio.bookio.model.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
  private String name;
  private String description;

  public CategoryDTO(Category category) {
    this.id = category.getId();
    this.name = category.getName();
    this.description = category.getDescription();
  }

  public CategoryDTO() {
  }
}
