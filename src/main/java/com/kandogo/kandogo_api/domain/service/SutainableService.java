package com.kandogo.kandogo_api.domain.service;

import com.kandogo.kandogo_api.domain.model.Sutainable;
import com.kandogo.kandogo_api.domain.model.Users;
import com.kandogo.kandogo_api.domain.repository.SutainableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class SutainableService {

    private final SutainableRepository sutainableActionRepository;
    private final UserService userService;



    @Transactional
    public Sutainable saveSutainableAction(Sutainable sutainableAction){

        Users user = userService.getUserById(sutainableAction.getUser().getId());

        sutainableAction.setCreatedAt(OffsetDateTime.now());

        return sutainableActionRepository.save(sutainableAction);
    }

    @Transactional
    public void deleteSutainableAction(String sutainableActionId){
        sutainableActionRepository.deleteById(sutainableActionId);
    }

}
