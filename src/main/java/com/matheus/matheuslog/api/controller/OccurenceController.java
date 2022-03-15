package com.matheus.matheuslog.api.controller;

import com.matheus.matheuslog.api.assembler.OccurenceAssembler;
import com.matheus.matheuslog.api.model.OccurenceModel;
import com.matheus.matheuslog.api.model.input.OccurenceInput;
import com.matheus.matheuslog.domain.model.Deliver;
import com.matheus.matheuslog.domain.model.Occurence;
import com.matheus.matheuslog.domain.service.FindDeliverService;
import com.matheus.matheuslog.domain.service.RegisterOccurenceService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("deliver/{deliverId}/occurences")
public class OccurenceController {

    private FindDeliverService findDeliverService;
    private RegisterOccurenceService registerOccurenceService;
    private OccurenceAssembler occurenceAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurenceModel register(@PathVariable Long deliverId, @Valid @RequestBody OccurenceInput occurenceInput) {
        Occurence occurence = registerOccurenceService.register(deliverId, occurenceInput.getDescription());
        return occurenceAssembler.toModel(occurence);
    }

    @GetMapping
    public List<OccurenceModel> list(@PathVariable Long deliverId) {
        Deliver deliver = findDeliverService.find(deliverId);

        return occurenceAssembler.toCollectionModel(deliver.getOccurences());
    }
}
