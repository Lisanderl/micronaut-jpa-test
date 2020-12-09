package example.micronaut.controller.model;

import example.micronaut.repo.entity.Book;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Introspected
public class BookModel {
  private Long id;
  private String bookName;
  private String isbn;
  private String genre;
  private String authorName;

  public static BookModel map(Book entity) {

    return BookModel.builder()
        .bookName(entity.getBookName())
        .isbn(entity.getIsbn())
        .genre(entity.getGenre().getGenreName())
        .authorName(
            String.join(" ", entity.getAuthor().getFirstName(), entity.getAuthor().getLastName()))
        .id(entity.getId())
        .build();
  }
}
