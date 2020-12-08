package example.micronaut.repo;

import example.micronaut.repo.dto.ShortBookDTO;
import example.micronaut.repo.entity.Book;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface BookRepository extends PageableRepository<Book, Long> {
  ShortBookDTO findByBookName(String bookName);
  //@Query(value = "select b.book_name, a.first_name, a.last_name, g.genre_name from book b \n"
  //    + "left join author a on b.author_id = a.id "
  //    + "left join genre g on b.genre_id = g.id "
  //    + "where lower(a.first_name) like :firstName", nativeQuery = true)
  //Iterable<LargeBookDTO> findAllByAuthor(String firstName);
}
