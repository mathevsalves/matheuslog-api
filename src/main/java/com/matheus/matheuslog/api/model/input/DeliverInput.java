package com.matheus.matheuslog.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DeliverInput {

    @Valid
    @NotNull
    private ClientIdInput client;

    @Valid
    @NotNull
    private ReceiverInput receiver;

    @NotNull
    private BigDecimal fee;

}
