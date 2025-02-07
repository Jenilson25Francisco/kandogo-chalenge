package com.kandogo.kandogo_api.api.controller;

import com.kandogo.kandogo_api.api.assembler.UserAssembler;
import com.kandogo.kandogo_api.api.dto.UserDto;
import com.kandogo.kandogo_api.api.dto.response.UserResponse;
import com.kandogo.kandogo_api.domain.model.Users;
import com.kandogo.kandogo_api.domain.repository.UserRepository;
import com.kandogo.kandogo_api.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserAssembler userAssembler;
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userAssembler.toCollectionModel(userRepository.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId){
        return userRepository.findById(userId)
                .map(user -> ResponseEntity.ok(userAssembler.toDto(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(@Valid @RequestBody UserResponse userResponse){
        Users addUser = userAssembler.toResponse(userResponse);
        Users UserAdded = userService.saveUser(addUser);
        return userAssembler.toDto(UserAdded);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        if (!userRepository.existsById(userId)){
            return ResponseEntity.notFound().build();
        }

        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
