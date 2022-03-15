package com.matheus.matheuslog.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class ReceiverInput {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
    private String neighbor;
}
