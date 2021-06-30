package br.com.antonio.bookio.services;

import br.com.antonio.bookio.model.Book;
import br.com.antonio.bookio.repositorys.BookRepository;
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
 * @created 30/06/2021 - 00:17
 */
@Service
public class BookService {
  @Autowired
  BookRepository bookRepository;
  @Autowired
  CategoryService categoryService;

  public Book findById(Long id) {
    Optional<Book> bookById = bookRepository.findById(id);
    return bookById.orElseThrow(() -> new ObjectNotFoundException(
        "Objeto não encontrado ID: " + id + ", Tipo: " + Book.class.getName())
    );
  }

  public List<Book> findAll(Long idCat) {
    return categoryService.findById(idCat).getBooks();
  }
}
