package br.com.antonio.bookio.domain.repositorys;

import br.com.antonio.bookio.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository para Category com query's já implementadas na JpaRepository.
 *
 * @author Antônio Lima Jr
 * @project bookio
 * @created 29/06/2021 - 05:49
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
