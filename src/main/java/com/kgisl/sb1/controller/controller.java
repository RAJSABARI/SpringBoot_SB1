package com.kgisl.sb1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb1.entity.Person;
import com.kgisl.sb1.service.PersonService;

@RestController
public class controller {

    @Autowired
    private PersonService personService;

    @GetMapping("/finalAll")
    public List<Person> listOfPerosn() {
        return personService.fetchallPerson();

    }

    @PostMapping("/add")
    public ResponseEntity<Person> creatperson(@RequestBody Person person) {
        Person saveperson = personService.createPerson(person);
        return new ResponseEntity<>(saveperson,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long personLong) {
        return personService.deletee(personLong);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable("id") Long id, @RequestBody Person updatedPerson) {
        return personService.updatePerson(id, updatedPerson);
       
    }

    List<Person> fetchallPerson() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
