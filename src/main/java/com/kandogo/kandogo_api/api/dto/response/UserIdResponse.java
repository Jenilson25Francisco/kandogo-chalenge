package com.kandogo.kandogo_api.api.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserIdResponse {

    @NotNull
    private String id;

}
