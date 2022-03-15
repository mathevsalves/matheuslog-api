package com.matheus.matheuslog.api.assembler;

import com.matheus.matheuslog.api.model.DeliverResponse;
import com.matheus.matheuslog.api.model.input.DeliverInput;
import com.matheus.matheuslog.domain.model.Deliver;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliverAssembler {

    private ModelMapper modelMapper;

    public DeliverResponse toModel(Deliver deliver) {
        return modelMapper.map(deliver, DeliverResponse.class);
    }

    public List<DeliverResponse> toCollectionModel(List<Deliver> delivers) {
        return delivers.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Deliver toEntity(DeliverInput deliverInput) {
        return modelMapper.map(deliverInput, Deliver.class);
    }
}
