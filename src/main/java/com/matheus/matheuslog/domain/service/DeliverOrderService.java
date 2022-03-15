package com.matheus.matheuslog.domain.service;

import com.matheus.matheuslog.domain.model.Client;
import com.matheus.matheuslog.domain.model.Deliver;
import com.matheus.matheuslog.domain.model.DeliverStatus;
import com.matheus.matheuslog.domain.repository.DeliverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class DeliverOrderService {

    private ClientCatalogService clientCatalogService;
    private DeliverRepository deliverRepository;

    @Transactional
    public Deliver order(Deliver deliver) {
        Client client = clientCatalogService.find(deliver.getClient().getId());

        deliver.setClient(client);
        deliver.setStatus(DeliverStatus.PENDING);
        deliver.setOrderDate(OffsetDateTime.now());

        return deliverRepository.save(deliver);
    }

}
