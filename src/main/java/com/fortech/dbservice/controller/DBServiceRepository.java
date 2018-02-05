package com.fortech.dbservice.controller;

import com.fortech.dbservice.model.Address;
import com.fortech.dbservice.model.Person;
import com.fortech.dbservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DBServiceRepository {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> getNames() {
        return personRepository.findAll();
    }

    @PostMapping("/add")
    public void addPerson(@RequestParam(name = "name") String name, @RequestParam(name = "address", required = false, defaultValue = "") String address) {

        Person person = personRepository.findByName(name);

        if (person != null) {
            person.addAddresses(new Address(address));
            personRepository.save(person);
        } else {
            personRepository.save(new Person(name, new Address(address)));
        }
    }

    @DeleteMapping
    public void deleteAll() {
        personRepository.deleteAll();
    }
}
