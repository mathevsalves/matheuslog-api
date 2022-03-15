package com.matheus.matheuslog.domain.service;

import com.matheus.matheuslog.domain.model.Deliver;
import com.matheus.matheuslog.domain.model.Occurence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegisterOccurenceService {

    private FindDeliverService findDeliverService;

    @Transactional
    public Occurence register(Long deliverId, String description) {
        Deliver deliver = findDeliverService.find(deliverId);

        return deliver.addOcurrence(description);
    }
}
