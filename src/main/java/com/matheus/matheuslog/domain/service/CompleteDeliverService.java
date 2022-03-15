package com.matheus.matheuslog.domain.service;

import com.matheus.matheuslog.domain.model.Deliver;
import com.matheus.matheuslog.domain.repository.DeliverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CompleteDeliverService {

    private DeliverRepository deliverRepository;
    private FindDeliverService findDeliverService;

    @Transactional
    public void complete(Long deliverId) {
        Deliver deliver = findDeliverService.find(deliverId);

        deliver.complete();

        deliverRepository.save(deliver);

    }
}
