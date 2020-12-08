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
public class GenreUpdateRequest {
    @NotNull
    private Long id;

    @NotBlank
    private String name;
}
