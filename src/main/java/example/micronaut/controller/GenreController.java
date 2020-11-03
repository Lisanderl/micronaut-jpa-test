package example.micronaut.controller;

import example.micronaut.controller.request.GenreSaveRequest;
import example.micronaut.controller.request.GenreUpdateRequest;
import example.micronaut.repo.GenreRepository;
import example.micronaut.repo.entity.Genre;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@ExecuteOn(TaskExecutors.IO)  // <1>
@Controller("/genres")
public class GenreController {

  protected final GenreRepository genreRepository;
  protected final EntityManager entityManager;

  public GenreController(
      GenreRepository genreRepository, EntityManager entityManager) {
    this.genreRepository = genreRepository;
    this.entityManager = entityManager;
  }

  @Get
  public Iterable<Genre> findAll() {
    return genreRepository.findAll();
  }

  @Get("/find")
  @Transactional
  public Optional<Genre> find(@QueryValue Long id) {
    return Optional.ofNullable(entityManager.find(Genre.class, id));
  }

  @Post
  public Genre create(@Body @Valid GenreSaveRequest saveRequest) {
    return genreRepository.save(new Genre(saveRequest.getName()));
  }

  @Put
  public Genre update(@Body @Valid GenreUpdateRequest updateRequest) {
    return genreRepository.update(new Genre(
        updateRequest.getId(),
        updateRequest.getName()));
  }
}
