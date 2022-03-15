package com.matheus.matheuslog.domain.service;

import com.matheus.matheuslog.domain.exception.EntityNotFoundException;
import com.matheus.matheuslog.domain.model.Deliver;
import com.matheus.matheuslog.domain.repository.DeliverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindDeliverService {

    private DeliverRepository deliverRepository;

    public Deliver find(Long deliverId) {
        return deliverRepository.findById(deliverId).orElseThrow(() -> new EntityNotFoundException("Deliver not found"));
    }
}
