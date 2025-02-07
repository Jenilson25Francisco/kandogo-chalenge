package com.kandogo.kandogo_api.api.assembler;

import com.kandogo.kandogo_api.api.dto.UserDto;
import com.kandogo.kandogo_api.api.dto.response.UserResponse;
import com.kandogo.kandogo_api.domain.model.Users;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAssembler {

    private final ModelMapper modelMapper;

    public UserDto toDto(Users user){
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> toCollectionModel(List<Users> users){
        return users.stream().map(this::toDto).toList();
    }

    public Users toResponse(UserResponse userResponse){
        return modelMapper.map(userResponse, Users.class);
    }

}
