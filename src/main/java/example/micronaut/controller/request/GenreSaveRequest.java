package example.micronaut.controller.request;

import io.micronaut.core.annotation.Introspected;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreSaveRequest {

  @NotBlank
  private String name;
}
