package br.com.antonio.bookio.controllers;

import br.com.antonio.bookio.dtos.CategoryDTO;
import br.com.antonio.bookio.model.Category;
import br.com.antonio.bookio.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Description.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 21:11
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoryController {
  @Autowired
  private CategoryService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> findById(@PathVariable("id") Long id) {
    Category obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> findAll() {
    List<Category> categoryList = service.findAll();
    List<CategoryDTO> categoryDTOList = categoryList.stream().map(CategoryDTO::new).collect(Collectors.toList());
    return ResponseEntity.ok().body(categoryDTOList);
  }

  @PostMapping
  public ResponseEntity<Category> create(@RequestBody Category newCategory) {
    Category categorySaved = service.create(newCategory);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categorySaved.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CategoryDTO> update(@PathVariable("id") Long id, @RequestBody CategoryDTO upCategory) {
    Category category = service.update(id, upCategory);
    return ResponseEntity.status(HttpStatus.OK).body(new CategoryDTO(category));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
