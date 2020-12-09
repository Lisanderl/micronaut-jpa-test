package example.micronaut.controller;

import example.micronaut.controller.request.SaveAuthorRequest;
import example.micronaut.repo.AuthorRepository;
import example.micronaut.repo.entity.Author;
import example.micronaut.repo.view.AuthorView;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import javax.validation.Valid;

@ExecuteOn(TaskExecutors.IO)
@Controller("/authors")
public class AuthorController {
  private AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Get
  Iterable<Author> getAll() {
    return authorRepository.findAll();
  }

  @Get("/find")
  AuthorView findByName(@QueryValue String findByName) {
    return authorRepository.findByFirstName(findByName);
  }

  @Post
  Author save(@Body @Valid SaveAuthorRequest saveAuthorRequest) {
    return authorRepository.save(Author
        .builder()
        .firstName(saveAuthorRequest.getLastName())
        .lastName(saveAuthorRequest.getLastName())
        .build());
  }
}
