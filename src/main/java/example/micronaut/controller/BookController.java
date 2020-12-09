package example.micronaut.controller;

import example.micronaut.controller.model.BookModel;
import example.micronaut.controller.request.BookSaveRequest;
import example.micronaut.repo.BookRepository;
import example.micronaut.repo.dto.ShortBookDTO;
import example.micronaut.repo.entity.Author;
import example.micronaut.repo.entity.Book;
import example.micronaut.repo.entity.Genre;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
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
    Book book = Book.builder()
        .isbn(cmd.getIsbn())
        .bookName(cmd.getName())
        .author(Objects.isNull(cmd.getAuthorId())
            ? null
            : Author.builder().id(cmd.getAuthorId()).build())
        .genre(Objects.isNull(cmd.getGenreId())
            ? null
            : Genre.builder().id(cmd.getGenreId()).build()).build();

    return HttpResponse.created(bookRepository.save(book));
  }

  @Get
  @Transactional
  public List<BookModel> getAll() {
    var books = bookRepository.findAll();
    return StreamSupport.stream(books.spliterator(), false)
        .map(BookModel::map)
        .collect(Collectors.toList());
  }

  @Get("/page")
  @Transactional
  public Page<BookModel> getPage(@QueryValue int page, @QueryValue int size) {

    return bookRepository.findAll(Pageable.from(page, size, Sort.unsorted())).map(BookModel::map);
  }

  @Get("/find")
  public ShortBookDTO findByName(@QueryValue String name) {
    return bookRepository.findByBookName(name);
  }
}
