package com.blu.personservice.cif.web.controller;

import com.blu.personservice.cif.service.PersonService;
import com.blu.personservice.cif.web.dto.PersonDto;
import com.blu.personservice.infrastructure.web.dto.response.GenericRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
@Component
public class PersonController {
    private final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/addPerson")
    public GenericRestResponse addPerson(
            @RequestBody PersonDto personDto) {
        logger.debug("REST request to save Person : {}", personDto);
        return personService.addPerson(personDto);
    }

    @GetMapping(value = "/getPerson/{id}")
    public GenericRestResponse getPerson(
            @PathVariable("id") final Long id) {
        logger.debug("REST request to get Person : {}", id);
        return personService.getPerson(id);
    }

    @PutMapping(value = "/updatePerson")
    public GenericRestResponse updatePerson(
            @RequestBody PersonDto personDto) {
        logger.debug("REST request to save Person : {}", personDto);
        return personService.updatePerson(personDto.getId(), personDto);
    }

    @DeleteMapping(value = "/deletePerson/{id}")
    public GenericRestResponse deletePerson(
            @PathVariable("id") final Long id) {
        logger.debug("REST request to Delete Person : {}", id);
        return personService.deletePerson(id);
    }

}
