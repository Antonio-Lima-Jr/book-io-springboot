package br.com.antonio.bookio.controllers;

import br.com.antonio.bookio.model.Category;
import br.com.antonio.bookio.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
