package example.micronaut.repo.dto;

import io.micronaut.core.annotation.Introspected;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShortBookDTO {
  private String bookName;
  private String isbn;
}
