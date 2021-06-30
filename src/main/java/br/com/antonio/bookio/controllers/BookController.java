package br.com.antonio.bookio.controllers;

import br.com.antonio.bookio.dtos.BookDTO;
import br.com.antonio.bookio.model.Book;
import br.com.antonio.bookio.services.BookService;
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

  @GetMapping
  public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long idCat) {
    List<Book> bookList = service.findAll(idCat);
    List<BookDTO> bookDTOS = bookList.stream().map(BookDTO::new).collect(Collectors.toList());
    return ResponseEntity.ok().body(bookDTOS);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Book> update(@PathVariable("id") Long id, @RequestBody Book book) {
    Book bookCreated = service.update(id, book);
    return new ResponseEntity<>(bookCreated, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Book> create(@RequestParam(value = "category", defaultValue = "0") Long idCat, @RequestBody Book book) {
    Book newObj = service.create(idCat, book);
    URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/book/{id}").buildAndExpand(newObj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long idBook) {
    service.delete(idBook);
    return ResponseEntity.noContent().build();
  }
}
