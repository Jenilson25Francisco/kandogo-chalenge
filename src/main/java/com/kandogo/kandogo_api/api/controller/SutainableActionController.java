package com.kandogo.kandogo_api.api.controller;

import com.kandogo.kandogo_api.api.assembler.SutainableActionAssembler;
import com.kandogo.kandogo_api.api.dto.SutainableDto;
import com.kandogo.kandogo_api.api.dto.response.SutainableActionResponse;
import com.kandogo.kandogo_api.domain.model.Sutainable;
import com.kandogo.kandogo_api.domain.repository.SutainableRepository;
import com.kandogo.kandogo_api.domain.service.SutainableService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sutainableactions")
@RequiredArgsConstructor
public class SutainableActionController {

    private final SutainableRepository sutainableActionRepository;
    private final SutainableActionAssembler sutainableActionAssembler;
    private final SutainableService sutainableActionService;

    @GetMapping
    public List<SutainableDto> getAll(){
        return sutainableActionAssembler.toCollectionModel(sutainableActionRepository.findAll());
    }

    @GetMapping("/{sutainableActionId}")
    public ResponseEntity<SutainableDto> getSutainableActionById(@PathVariable String sutainableActionId){
        return sutainableActionRepository.findById(sutainableActionId)
                .map(sutainable -> ResponseEntity.ok(sutainableActionAssembler.toDto(sutainable)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SutainableDto saveSutainableAction(
            @Valid @RequestBody SutainableActionResponse sutainableActionResponse){

        Sutainable sutainableAction = sutainableActionAssembler.toResponse(sutainableActionResponse);
        Sutainable savedSutainableAction = sutainableActionService.saveSutainableAction(sutainableAction);

        return sutainableActionAssembler.toDto(savedSutainableAction);

    }

    @PutMapping("/{sutainableActionId}")
    public ResponseEntity<SutainableDto> updateSutainableAction(
            @Valid @RequestBody SutainableActionResponse sutainableActionResponse,
            @PathVariable String sutainableActionId){

        if (!sutainableActionRepository.existsById(sutainableActionId)){
            throw new RuntimeException("açao nao encontrada");
        }

        Sutainable updateAction = sutainableActionAssembler.toResponse(sutainableActionResponse);
        updateAction.setId(sutainableActionId);
        Sutainable updatedAction = sutainableActionService.saveSutainableAction(updateAction);

        return ResponseEntity.ok(sutainableActionAssembler.toDto(updatedAction));

    }

    @DeleteMapping("/{sutainableActionId}")
    public ResponseEntity<Void> deleteSutainableAction(@PathVariable String sutainableActionId){
        if (!sutainableActionRepository.existsById(sutainableActionId)){
            return ResponseEntity.notFound().build();
        }

        sutainableActionService.deleteSutainableAction(sutainableActionId);
        return ResponseEntity.noContent().build();
    }

}
