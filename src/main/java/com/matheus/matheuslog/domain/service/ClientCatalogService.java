package com.matheus.matheuslog.domain.service;

import com.matheus.matheuslog.domain.exception.DomainException;
import com.matheus.matheuslog.domain.model.Client;
import com.matheus.matheuslog.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClientCatalogService {

    private ClientRepository clientRepository;

    public Client find(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new DomainException("Client not found"));
    }

    @Transactional
    public Client save(Client client) {
        boolean emailInUse = clientRepository.findByEmail(client.getEmail()).stream().anyMatch(clientExist -> !clientExist.equals(client));
        if (emailInUse) throw new DomainException("Already have client with this name.");

        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
