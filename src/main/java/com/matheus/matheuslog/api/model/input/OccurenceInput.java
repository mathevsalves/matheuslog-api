package com.matheus.matheuslog.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurenceInput {

    @NotBlank
    private String description;
}
