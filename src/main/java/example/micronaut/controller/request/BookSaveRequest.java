package example.micronaut.controller.request;

import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Introspected
public class BookSaveRequest {
  @NotBlank
  private String name;
  @NotBlank
  private String isbn;
  @NotNull
  private Long genreId;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Long getGenreId() {
    return genreId;
  }

  public void setGenreId(Long genreId) {
    this.genreId = genreId;
  }
}
