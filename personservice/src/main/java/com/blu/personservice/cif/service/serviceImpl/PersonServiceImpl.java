package com.blu.personservice.cif.service.serviceImpl;

import com.blu.personservice.cif.entity.PersonEntity;
import com.blu.personservice.cif.repository.PersonRepository;
import com.blu.personservice.cif.service.PersonService;
import com.blu.personservice.cif.web.dto.PersonDto;
import com.blu.personservice.cif.web.error.ErrorConstants;
import com.blu.personservice.infrastructure.util.ConstantsUtil;
import com.blu.personservice.infrastructure.util.ObjectMapperUtils;
import com.blu.personservice.infrastructure.web.dto.response.GenericRestResponse;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for Card-Service .
 */

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    private final static String PERSON_CACHE = "personCache";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CacheManager cacheManager;
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
    public GenericRestResponse addPerson(PersonDto personDto) {
        GenericRestResponse genericRestResponse;
        try {
            PersonEntity personEntity = modelMapper.map(personDto, PersonEntity.class);
            personRepository.saveAndFlush(personEntity);

//            redisTemplate.opsForHash().put("personCache",personEntity.getId(),personEntity);
//            redisTemplate.opsForValue().set(cacheKey , cacheValue , Duration.ofSeconds(10s)).subscribe()
//            redisTemplate.opsForValue().set("personCache::"+personEntity.getId() , genericRestResponse);
//            redisTemplate.opsForHash().get("personCache",personEntity.getId());

            genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.SUCCESS,
                    ConstantsUtil.ResponseMessage.PERSON_ADDED_SUCCESSFULLY,
                    personEntity.toString());

            cacheManager.getCache(PERSON_CACHE).clear();

        } catch (Exception e) {
            logger.error(ErrorConstants.PersonMessage.INCORRECT_INPUT_MSG);
            genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.FAILURE,
                    e.getMessage());
        }
        return genericRestResponse;
    }

    @Override
    @Cacheable(value = PERSON_CACHE, key = "#id")
    public GenericRestResponse getPerson(Long id) {
        GenericRestResponse genericRestResponse;
        try {
            PersonEntity personEntity = loadPersonById(id);

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
    public List<PersonDto> getAllPerson() {
        List<PersonEntity> list = personRepository.findAll();
        return ObjectMapperUtils.mapAll(list, PersonDto.class);
    }

    @Override
    @CachePut(value = PERSON_CACHE, key = "#id")
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
    @CacheEvict(value = PERSON_CACHE, key = "#id")
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
