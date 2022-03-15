package com.matheus.matheuslog.api.model;

import com.matheus.matheuslog.domain.model.DeliverStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliverResponse {

    private Long id;
    private ClientResumeModel client;
    private ReceiverResponse receiver;
    private BigDecimal fee;
    private DeliverStatus status;
    private OffsetDateTime orderDate;
    private OffsetDateTime finalDate;


}
