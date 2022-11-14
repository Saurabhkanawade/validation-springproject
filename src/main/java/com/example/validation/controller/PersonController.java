package com.example.validation.controller;

import com.example.validation.model.PersonModel;
import com.example.validation.model.PersonResponse;
import com.example.validation.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@Log4j2
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createEmployee(@RequestBody @Valid PersonModel personModel) {
        PersonResponse personResponse = null;
        if (Objects.isNull(personModel) != true) {
            personResponse = personService.createEmployee(personModel);
            log.info("Person Model is not null!!!");
        } else {
            log.info("Cannot Pass null objects");
        }
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

}