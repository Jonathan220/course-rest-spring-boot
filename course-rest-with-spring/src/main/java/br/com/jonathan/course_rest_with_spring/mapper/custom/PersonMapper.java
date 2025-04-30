package br.com.jonathan.course_rest_with_spring.mapper.custom;

import br.com.jonathan.course_rest_with_spring.data.dto.v2.PersonDTOv2;
import br.com.jonathan.course_rest_with_spring.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person){
        PersonDTOv2 dto = new PersonDTOv2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDTOToEntity(PersonDTOv2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}
