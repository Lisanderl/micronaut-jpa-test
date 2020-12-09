package example.micronaut.repo;

import example.micronaut.repo.entity.Author;
import example.micronaut.repo.view.AuthorView;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
  AuthorView findByFirstName(String firstName);
}
