package com.kandogo.kandogo_api.api.assembler;

import com.kandogo.kandogo_api.api.dto.SutainableDto;
import com.kandogo.kandogo_api.api.dto.response.SutainableActionResponse;
import com.kandogo.kandogo_api.domain.model.Sutainable;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SutainableActionAssembler {

    private final ModelMapper modelMapper;

    public List<SutainableDto> toCollectionModel(List<Sutainable> sutainableActions) {
        return sutainableActions.stream().map(this::toDto).toList();
    }

    public SutainableDto toDto(Sutainable sutainableAction){
        return modelMapper.map(sutainableAction, SutainableDto.class);
    }

    public Sutainable toResponse(SutainableActionResponse sutainableActionResponse){
        return modelMapper.map(sutainableActionResponse, Sutainable.class);
    }

}
