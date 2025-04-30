package br.com.jonathan.course_rest_with_spring.service;

import br.com.jonathan.course_rest_with_spring.data.dto.v1.PersonDTO;
import br.com.jonathan.course_rest_with_spring.data.dto.v2.PersonDTOv2;
import br.com.jonathan.course_rest_with_spring.exception.ResourceNotFoundException;
import br.com.jonathan.course_rest_with_spring.mapper.ObjectMapper;
import br.com.jonathan.course_rest_with_spring.mapper.custom.PersonMapper;
import br.com.jonathan.course_rest_with_spring.model.Person;
import br.com.jonathan.course_rest_with_spring.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger log = LoggerFactory.getLogger(PersonServices.class);

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    public List<PersonDTO> findAll(){
        log.info("Finding all people!");
        return ObjectMapper.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        log.info("finding one person!");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        log.info("Creating one person!");
        var entity = ObjectMapper.parseObject(person, Person.class);
        return ObjectMapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTOv2 createv2(PersonDTOv2 person){
        log.info("Creating one person!");
        var entity = personMapper.convertDTOToEntity(person);
        return personMapper.convertEntityToDTO(personRepository.save(entity));
    }

    public PersonDTO update(PersonDTO person){
        log.info("Updating one person!");

        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return ObjectMapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        log.info("Deleting one person!");

        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }
}
