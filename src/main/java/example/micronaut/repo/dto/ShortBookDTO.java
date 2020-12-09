package example.micronaut.repo.dto;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Introspected
@Data
public class ShortBookDTO {
  String bookName;
  String isbn;
}
