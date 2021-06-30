package br.com.antonio.bookio.repositorys;

import br.com.antonio.bookio.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository para book com query's já implementadas na JpaRepository.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 05:50
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
