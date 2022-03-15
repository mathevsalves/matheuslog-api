package com.matheus.matheuslog.api.controller;

import com.matheus.matheuslog.domain.model.Client;
import com.matheus.matheuslog.domain.repository.ClientRepository;
import com.matheus.matheuslog.domain.service.ClientCatalogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientRepository clientRepository;
    private ClientCatalogService clientCatalogService;

    @GetMapping
    public List<Client> list() {
        return clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId) {
        return clientRepository.findById(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@Valid @RequestBody Client client) {
        return clientCatalogService.save(client);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@Valid @PathVariable Long clientId, @RequestBody Client client) {
        if (!clientRepository.existsById(clientId))
            return ResponseEntity.notFound().build();

        client.setId(clientId);
        return ResponseEntity.ok(clientCatalogService.save(client));
    }

    @DeleteMapping("/{clientId}")
    private ResponseEntity<Void> remove(@PathVariable Long clientId) {
        if (!clientRepository.existsById(clientId))
            return ResponseEntity.notFound().build();

        clientCatalogService.delete(clientId);
        return ResponseEntity.noContent().build();
    }

}
