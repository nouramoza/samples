package com.blu.personservice.cif.service.serviceImpl;

import com.blu.personservice.cif.entity.PersonEntity;
import com.blu.personservice.cif.repository.PersonRepository;
import com.blu.personservice.cif.service.PersonService;
import com.blu.personservice.cif.web.dto.PersonDto;
import com.blu.personservice.cif.web.error.ErrorConstants;
import com.blu.personservice.infrastructure.util.ConstantsUtil;
import com.blu.personservice.infrastructure.web.dto.response.GenericRestResponse;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for Card-Service .
 */

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    private static final ModelMapper modelMapper = new ModelMapper();

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * AddCard
     *
     * @param personDto adding new card to for an existing account
     * @return GenericRestResponse adding card response
     */
    @Override
//    @CachePut(value = "personCache", key = "#id")
    public GenericRestResponse addPerson(PersonDto personDto) {

        PersonEntity personEntity = modelMapper.map(personDto, PersonEntity.class);

        personRepository.saveAndFlush(personEntity);

        GenericRestResponse genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.SUCCESS,
                ConstantsUtil.ResponseMessage.PERSON_ADDED_SUCCESSFULLY,
                personEntity.toString());
        return genericRestResponse;
    }

    @Override
    @Cacheable(value = "personCache", key = "#id")
    public GenericRestResponse getPerson(Long id) {
        GenericRestResponse genericRestResponse;
        try {
            PersonEntity personEntity = loadPersonById(id);

            PersonDto personDto = new PersonDto(
                    personEntity.getId(),
                    personEntity.getFirstName(),
                    personEntity.getLastName(), personEntity.getNationalCode(),
                    personEntity.getHomeAddress(), personEntity.getPhoneNumber());
            genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.SUCCESS,
                    ConstantsUtil.ResponseMessage.PERSON_FOUNDED, personEntity.toString());
        } catch (Exception e) {
            logger.error(ErrorConstants.PersonMessage.INCORRECT_INPUT_MSG);
            genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.FAILURE,
                    e.getMessage());
        }

        return genericRestResponse;
    }

    @Override
    @CachePut(value = "personCache", key = "#id")
    public GenericRestResponse updatePerson(Long id, PersonDto personDto) {
        GenericRestResponse genericRestResponse;

        try {
            PersonEntity personEntity = loadPersonById(personDto.getId());
            if (personDto.getFirstName() != null) {
                personEntity.setFirstName(personDto.getFirstName());
            }
            if (personDto.getLastName() != null) {
                personEntity.setLastName(personDto.getLastName());
            }
            if (personDto.getHomeAddress() != null) {
                personEntity.setHomeAddress(personDto.getHomeAddress());
            }
            if (personDto.getNationalCode() != null) {
                personEntity.setNationalCode(personDto.getNationalCode());
            }
            if (personDto.getPhoneNumber() != null) {
                personEntity.setPhoneNumber(personDto.getPhoneNumber());
            }

            personRepository.saveAndFlush(personEntity);


            genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.SUCCESS,
                    ConstantsUtil.ResponseMessage.PERSON_UPDATED_SUCCESSFULLY,
                    personEntity.toString());

        } catch (Exception e) {
            logger.error(ErrorConstants.PersonMessage.INCORRECT_INPUT_MSG);
            genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.FAILURE,
                    e.getMessage());
        }
        return genericRestResponse;
    }

    @Override
    @CacheEvict(value = "personCache", key = "#id")
    public GenericRestResponse deletePerson(Long id) {
        GenericRestResponse genericRestResponse;

        try {

            PersonEntity personEntity = loadPersonById(id);
            personRepository.delete(personEntity);

            genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.SUCCESS,
                    ConstantsUtil.ResponseMessage.PERSON_DELETED_SUCCESSFULLY,
                    personEntity.toString());
        } catch (Exception e) {
            logger.error(ErrorConstants.PersonMessage.INCORRECT_INPUT_MSG);
            genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.FAILURE,
                    e.getMessage());
        }
        return genericRestResponse;
    }

    public PersonEntity loadPersonById(Long id) {
        Optional<PersonEntity> personEntity = personRepository.findById(id);
        return personEntity.get();
    }

    @Override
    public Optional<PersonEntity> getPersonById(Long id) {
        return personRepository.findById(id);
    }

}
