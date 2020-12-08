package example.micronaut.controller.request;

import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveAuthorRequest {
  @NotNull
  private String firstName;

  @NotNull
  private String lastName;
}
