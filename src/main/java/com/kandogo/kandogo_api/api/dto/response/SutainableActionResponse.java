package com.kandogo.kandogo_api.api.dto.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SutainableActionResponse {

    @Valid
    @NotNull
    private UserIdResponse userIdResponse;
    @NotBlank
    @Size(max = 100)
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Integer points;

}
