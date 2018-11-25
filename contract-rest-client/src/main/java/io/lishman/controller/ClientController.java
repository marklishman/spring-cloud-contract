package io.lishman.controller;

import io.lishman.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/get-data")
    public @ResponseBody List<User> getUsers() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8100/users", List.class);
    }

    @GetMapping("/get-data/{id}")
    public @ResponseBody User getUser(@PathVariable("id") Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8100/users/{id}", User.class, id);
    }
}
