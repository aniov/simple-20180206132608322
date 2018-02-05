package com.fortech.dbservice.controller;

import com.fortech.dbservice.model.Person;
import com.fortech.dbservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DBServiceRepository {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public List<String> getNames() {
        return personRepository.findAll()
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    @PostMapping("/add/{name}")
    public void addPerson(@PathVariable(name = "name") String name) {
        personRepository.save(new Person(name));
    }
}
