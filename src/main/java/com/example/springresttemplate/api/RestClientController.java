package com.example.springresttemplate.api;

import com.example.springresttemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private static final String URL = "http://localhost:8080/users";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        ResponseEntity<List> result = restTemplate.getForEntity(URL, List.class);
        List<User> userList = result.getBody();
        return ResponseEntity.ok(userList);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        ResponseEntity<User> result = restTemplate.postForEntity(URL,user,User.class);
        User responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }
}
