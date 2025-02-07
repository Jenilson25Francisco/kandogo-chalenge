package com.kandogo.kandogo_api.domain.service;

import com.kandogo.kandogo_api.domain.model.Users;
import com.kandogo.kandogo_api.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users getUserById(String userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("usuario nao encontrado"));
    }

    @Transactional
    public Users saveUser(Users user){
        boolean existingEmail = userRepository.findByEmail(user.getEmail())
                .stream().anyMatch(existUser -> !existUser.equals(user));

        if (existingEmail){
            throw new RuntimeException("Este usuario já existe");
        }

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

}
