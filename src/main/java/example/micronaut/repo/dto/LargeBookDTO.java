package example.micronaut.repo.dto;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LargeBookDTO {
  private String bookName;
  private String firstName;
  private String lastName;
  private String genreName;
}
