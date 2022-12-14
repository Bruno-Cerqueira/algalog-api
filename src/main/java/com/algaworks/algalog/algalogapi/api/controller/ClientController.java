package com.algaworks.algalog.algalogapi.api.controller;

import com.algaworks.algalog.algalogapi.domain.model.Client;
import com.algaworks.algalog.algalogapi.domain.repository.ClientRepository;
import com.algaworks.algalog.algalogapi.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    private ClientService clientService;

    @GetMapping
    public List<Client> index() {
        return clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> find(@PathVariable Long clientId) {
        return clientRepository.findById(clientId)
                .map(client -> ResponseEntity.ok(client))
                .orElse(ResponseEntity.notFound().build());

        // Optional<Client> client = clientRepository.findById(clientId);

        //if(client.isPresent()) {
        //    return ResponseEntity.ok(client.get());
        //}
        //return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@Valid @RequestBody Client client) {
        return clientService.save(client);

    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@Valid @RequestBody Client client, @PathVariable Long clientId) {
        if(!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        client = clientService.save(client);
        return ResponseEntity.ok(client);
    }


    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId) {
        if(!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        clientService.delete(clientId);
        return ResponseEntity.noContent().build();
    }
}
