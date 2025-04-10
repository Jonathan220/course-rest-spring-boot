package br.com.jonathan.course_rest_with_spring.service;

import br.com.jonathan.course_rest_with_spring.controllers.PersonController;
import br.com.jonathan.course_rest_with_spring.exception.ResourceNotFoundException;
import br.com.jonathan.course_rest_with_spring.model.Person;
import br.com.jonathan.course_rest_with_spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger log = Logger.getLogger(PersonController.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){
        log.info("Finding all people!");
        return personRepository.findAll();
    }

    public Person findById(Long id){
        log.info("finding one person!");
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person){
        log.info("Creating one person!");
        return personRepository.save(person);
    }

    public Person update(Person person){
        log.info("Updating one person!");

        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void delete(Long id){
        log.info("Deleting one person!");

        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }
}
