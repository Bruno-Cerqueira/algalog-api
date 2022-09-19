package com.algaworks.algalog.algalogapi.domain.service;

import com.algaworks.algalog.algalogapi.domain.exception.BusinessException;
import com.algaworks.algalog.algalogapi.domain.model.Client;
import com.algaworks.algalog.algalogapi.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class ClientService {
    private ClientRepository clientRepository;

    public Client search(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado"));
    }

    @Transactional
    public Client save(Client client) {
        boolean usedEmail = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(existentClient -> !existentClient.equals(client));

        if(usedEmail) {
            throw new BusinessException("Já existe um email cadastrado com este e-mail");
        }

        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
