package example.micronaut.controller.request;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Introspected
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageableBooksRequest {
  private int limit;
  private int offset;
}
