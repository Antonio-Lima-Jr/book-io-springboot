package br.com.antonio.bookio.controllers;

import br.com.antonio.bookio.model.Book;
import br.com.antonio.bookio.services.BookService;
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
 * @created 30/06/2021 - 00:14
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {
  @Autowired
  private BookService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Book> findById(@PathVariable("id") Long id) {
    Book book = service.findById(id);
    return ResponseEntity.ok().body(book);
  }
}
