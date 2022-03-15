package com.matheus.matheuslog.api.controller;

import com.matheus.matheuslog.api.assembler.DeliverAssembler;
import com.matheus.matheuslog.api.model.DeliverResponse;
import com.matheus.matheuslog.api.model.input.DeliverInput;
import com.matheus.matheuslog.domain.repository.DeliverRepository;
import com.matheus.matheuslog.domain.service.CompleteDeliverService;
import com.matheus.matheuslog.domain.service.DeliverOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliver")
public class DeliverController {

    private DeliverRepository deliverRepository;
    private DeliverOrderService deliverOrderService;
    private CompleteDeliverService completeDeliverService;
    private DeliverAssembler deliverAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliverResponse order(@Valid @RequestBody DeliverInput deliverInput) {
        return deliverAssembler.toModel(deliverOrderService.order(deliverAssembler.toEntity(deliverInput)));
    }

    @PutMapping("/{deliverId}/complete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void complete(@PathVariable Long deliverId) {
        completeDeliverService.complete(deliverId);
    }

    @GetMapping
    public List<DeliverResponse> list() {
        return deliverAssembler.toCollectionModel(deliverRepository.findAll());
    }

    @GetMapping("/{deliverId}")
    public ResponseEntity<DeliverResponse> find(@PathVariable Long deliverId) {
        return deliverRepository.findById(deliverId).map(deliver -> ResponseEntity.ok(deliverAssembler.toModel(deliver))).orElse(ResponseEntity.notFound().build());
    }
}
