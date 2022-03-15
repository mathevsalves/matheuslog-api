package com.matheus.matheuslog.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OccurenceModel {

    private Long id;
    private String description;
    private OffsetDateTime registerDate;
}
