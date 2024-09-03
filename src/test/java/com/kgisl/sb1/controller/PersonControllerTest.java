package com.kgisl.sb1.controller;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.kgisl.sb1.controllers.cont;
import com.kgisl.sb1.entity.Person;
import com.kgisl.sb1.service.PersonService;

/**
 * PersonController
 */

@ExtendWith(MockitoExtension.class)

public class PersonControllerTest {
  @Mock
  private PersonService personService;

  @InjectMocks
  private cont personController;

  public static List<Person> expected;
  
  Person person1 = new Person(1,"Alice","alice@example.com");
  Person person2 = new Person(2,"Bob","bob@example.com");
  

  // public Person person2 = new PersonBuilder().id(2L).name("aravinth").build();

  @Test
public void listOfPerosn() {
    // Prepare the expected list
    List<Person> expected = Arrays.asList(person1, person2);
    System.out.println(expected);

    // Set up the mock behavior
    when(personService.fetchallPerson()).thenReturn(expected);

    // Execute the method under test
    List<Person> actual = personController.listOfPerosn();

    // Assertions
    // assertNotNull(actual, "The response body should not be null.");
    assertEquals(expected, actual);
}


  // @Test
  // public void getPersonByIdTest() {
  //   int id = 1;
  //   when(personService.getPersonById(id)).thenReturn(null);
  //   ResponseEntity<Person> actual = personController.getPersonById(id);
  //   assertNotNull(actual);
  // }

  @Test
  public void createPersonTest() {
    when(personService.createPerson(person1)).thenReturn(person1);
    personController.createPerson(person1);
  }

  @Test
  public void updatePersonTest() {
    // Person edit = new PersonBuilder().name("shanmugam").build();
    Long id = 1l;
    // when(personService.updatePerson(id, person1)).thenReturn(person1);
    ResponseEntity<Person> actual = personController.updatePerson(id, person1);
    // assertNotNull(actual);
    // System.out.println("Actual is  "+actual.getBody());
    // System.out.println("expected-->" + expected);
    assertEquals(expected, actual);
  }

//   @Test
//   public void deletePersonTest() {
//     int id = 1;
//     when(personService.getPersonById(id)).thenReturn(person1);
//     personController.deletee(id);
//     verify(personService).deletee(id);
//   }
}