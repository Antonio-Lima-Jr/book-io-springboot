package br.com.antonio.bookio.services;

import br.com.antonio.bookio.model.Book;
import br.com.antonio.bookio.model.Category;
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

  public Book update(Long id, Book book) {
    Book obj = findById(id);
    updateData(obj, book);
    return bookRepository.save(obj);
  }

  private void updateData(Book obj, Book book) {
    obj.setTitle(paramNotNull(obj.getTitle(), book.getTitle()));
    obj.setAuthorName(paramNotNull(obj.getAuthorName(), book.getAuthorName()));
    obj.setDescription(paramNotNull(obj.getDescription(), book.getDescription()));
    obj.setCategory(paramNotNull(obj.getCategory(), book.getCategory()));
    obj.setBook(paramNotNull(obj.getBook(), book.getBook()));
  }

  private Category paramNotNull(Category oldCategory, Category newCategory) {
    Category category;
    if (newCategory != null) {
      category = categoryService.findById(newCategory.getId());
    } else {
      category = oldCategory;
    }
    return category;
  }

  private String paramNotNull(String oldBook, String newBook) {
    return newBook != null ? newBook : oldBook;
  }

  private Number paramNotNull(Number oldBook, Number newBook) {
    return newBook != null ? newBook : oldBook;
  }
}
