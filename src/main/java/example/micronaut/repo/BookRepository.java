package example.micronaut.repo;

import example.micronaut.repo.dto.ShortBookDTO;
import example.micronaut.repo.entity.Book;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface BookRepository extends PageableRepository<Book, Long> {
  ShortBookDTO findByBookName(String bookName);

}
