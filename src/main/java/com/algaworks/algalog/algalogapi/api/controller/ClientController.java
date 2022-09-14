package com.algaworks.algalog.algalogapi.api.controller;

import com.algaworks.algalog.algalogapi.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public List<Client> index() {
        Client client1 = new Client();
        client1.setId(1L);
        client1.setName("João");
        client1.setEmail("joao@gmail.com");
        client1.setPhone("11-202301232");

        Client client2 = new Client();
        client2.setId(2L);
        client2.setName("Maria");
        client2.setEmail("maria@gmail.com");
        client2.setPhone("11-2213113");

        return Arrays.asList(client2, client1);
    }
}
