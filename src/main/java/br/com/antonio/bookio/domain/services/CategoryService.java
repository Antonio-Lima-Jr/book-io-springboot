package br.com.antonio.bookio.domain.services;

import br.com.antonio.bookio.domain.model.Category;
import br.com.antonio.bookio.domain.repositorys.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 21:16
 */
@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public Category findById(Long id) {
    Optional<Category> obj = repository.findById(id);
    return obj.orElse(null);
  }
}
