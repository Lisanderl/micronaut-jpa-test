package example.micronaut.controller.request;

import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
  @NotBlank
  private String name;
  @NotBlank
  private String isbn;
  @NotNull
  private Long genreId;
  @NotNull
  private Long authorId;
}
