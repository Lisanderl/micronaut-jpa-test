package example.micronaut.controller.request;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;

@Introspected // <1>
public class GenreSaveRequest {

    @NotBlank
    private String name;

    public GenreSaveRequest() {
    }

    public GenreSaveRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
