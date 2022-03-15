package com.matheus.matheuslog.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class Receiver {

    @NotBlank
    @Column(name = "receiver_name")
    private String name;

    @NotBlank
    @Column(name = "receiver_address")
    private String address;

    @NotBlank
    @Column(name = "receiver_number")
    private String number;

    @NotBlank
    @Column(name = "receiver_complement")
    private String complement;

    @NotBlank
    @Column(name = "receiver_neighbor")
    private String neighbor;
}
