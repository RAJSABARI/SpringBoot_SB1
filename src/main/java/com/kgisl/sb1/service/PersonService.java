package com.kgisl.sb1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kgisl.sb1.entity.Person;
import com.kgisl.sb1.repository.PersonRepo;

@EnableAspectJAutoProxy
@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public List<Person> fetchallPerson() {
        return personRepo.findAll();
    }

    public ResponseEntity<Void> deletee(Long personLong) {
        personRepo.deleteById(personLong);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<String> updatePerson(Long id, Person updatedPerson) {
        personRepo.save(updatedPerson);
        return new ResponseEntity<>("updated", HttpStatus.OK);

    }

    public Person createPerson(Person p) {
        return personRepo.save(p);
    }

}
