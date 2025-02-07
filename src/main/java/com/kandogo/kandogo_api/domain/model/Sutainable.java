package com.kandogo.kandogo_api.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sutainable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    private int points;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Users user;

}
