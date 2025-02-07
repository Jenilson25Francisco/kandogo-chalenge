package com.kandogo.kandogo_api.api.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    @NotBlank
    @Size(min = 3, max = 80)
    private String name;
    @NotBlank
    @Size(max = 80)
    @Email
    private String email;
    @NotBlank
    @Size(max = 80)
    private String password;

}
