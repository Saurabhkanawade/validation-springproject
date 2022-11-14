package com.example.validation.service;

import com.example.validation.entity.PersonEntity;
import com.example.validation.mapper.PersonMapper;
import com.example.validation.model.PersonModel;
import com.example.validation.model.PersonResponse;
import com.example.validation.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonResponse createEmployee(PersonModel personModel) {
        PersonEntity personEntity = null;
        personEntity = personMapper.modelToEntity(personModel);
        personRepository.save(personEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());
        log.info("Created Employee Successfully!!");
        return personResponse;
    }
}