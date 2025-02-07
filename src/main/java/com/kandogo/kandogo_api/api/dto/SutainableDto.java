package com.kandogo.kandogo_api.api.dto;

import com.kandogo.kandogo_api.domain.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class SutainableDto {

    private String id;
    private UserSummary userSummary;
    private String title;
    private String description;
    private int points;
    private Category category;
    private OffsetDateTime created_at;

}
