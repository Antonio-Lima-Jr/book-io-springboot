package br.com.antonio.bookio.services;

import br.com.antonio.bookio.dtos.CategoryDTO;
import br.com.antonio.bookio.model.Category;
import br.com.antonio.bookio.repositorys.CategoryRepository;
import br.com.antonio.bookio.services.exceptions.DataIntegrityViolationException;
import br.com.antonio.bookio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    return obj.orElseThrow(
        () -> new ObjectNotFoundException(
            "Objeto não encontrado ID: " + id + ", Tipo: " + Category.class.getName())
    );
  }

  public List<Category> findAll() {
    return repository.findAll();
  }

  public Category create(Category category) {
    category.setId(null);
    return repository.save(category);
  }

  public Category update(Long id, CategoryDTO upCategory) {
    Category obj = findById(id);
    obj.setName(upCategory.getName());
    obj.setDescription(upCategory.getDescription());
    return repository.saveAndFlush(obj);
  }

  public void delete(Long id) {
    findById(id);
    try {
      repository.deleteById(id);
    } catch (org.springframework.dao.DataIntegrityViolationException e) {
      throw new DataIntegrityViolationException("Objeto não pode ser deletado! possui livros associados");
    }
  }
}
