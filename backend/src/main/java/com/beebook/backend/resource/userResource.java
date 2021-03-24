package com.beebook.backend.resource;

import java.util.List;
import com.beebook.backend.model.users;
import com.beebook.backend.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/rest/users")
public class userResource{

    @Autowired
    userRepository userRepository;

    @GetMapping(value = "/all")
    public List<users> getAll() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<users> persist(@RequestBody final users users){
        userRepository.save(users);
        return userRepository.findAll();
    }
}