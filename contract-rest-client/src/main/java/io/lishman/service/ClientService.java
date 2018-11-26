package io.lishman.service;

import io.lishman.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ClientService {

    public List<User> getUsers() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8100/users", List.class);
    }

    public User getUser(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8100/users/{id}", User.class, id);
    }
}
