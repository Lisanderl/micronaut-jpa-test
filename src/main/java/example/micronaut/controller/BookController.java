package example.micronaut.controller;

import example.micronaut.controller.request.BookSaveRequest;
import example.micronaut.repo.BookRepository;
import example.micronaut.repo.entity.Book;
import example.micronaut.repo.entity.Genre;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.RequestAttribute;
import io.micronaut.http.annotation.RequestAttributes;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import javax.inject.Inject;
import javax.validation.Valid;

@ExecuteOn(TaskExecutors.IO)
@Controller("/books")
public class BookController {
  protected final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) { // <2>
    this.bookRepository = bookRepository;
  }

  @Post
  public HttpResponse<Book> save(@Body @Valid BookSaveRequest cmd) {
    Book book = new Book(cmd.getIsbn(), cmd.getName(), new Genre(cmd.getGenreId()));
    return HttpResponse.created(bookRepository.save(book));
  }

  @Get
  public Iterable<Book> getAll() {
    return bookRepository.findAll();
  }

  @Get("/find")
  public Book findByName(@QueryValue String name) {
    return bookRepository.findByName(name);
  }
}
