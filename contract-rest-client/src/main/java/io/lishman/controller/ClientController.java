package io.lishman.controller;

import io.lishman.model.User;
import io.lishman.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/get-data")
    public @ResponseBody List<User> getUsers() {
        return clientService.getUsers();
    }

    @GetMapping("/get-data/{id}")
    public @ResponseBody User getUser(@PathVariable("id") Long id) {
        return clientService.getUser(id);
    }
}
