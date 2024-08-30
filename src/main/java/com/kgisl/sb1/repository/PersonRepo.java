package com.kgisl.sb1.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.sb1.entity.Person;

@Repository
public interface PersonRepo extends ListCrudRepository<Person,Long> {
    
}
