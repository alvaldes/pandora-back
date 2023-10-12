package cu.cujae.pandora.back.comms.service;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cu.cujae.pandora.back.comms.dto.PersonDTO;
import cu.cujae.pandora.back.comms.entity.Person;
import cu.cujae.pandora.back.comms.exception.ErrorCodes;
import cu.cujae.pandora.back.comms.exception.InvalidClientRequestException;
import cu.cujae.pandora.back.comms.mapper.DomainMapper;
import cu.cujae.pandora.back.comms.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
   PersonRepository personRepository;
    DomainMapper mapper = Mappers.getMapper(DomainMapper.class);

    public PersonDTO save(PersonDTO personDTO) {
        return mapper.toPersonDto(personRepository.save(mapper.toPerson(personDTO)));
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public List<PersonDTO> getAllPersons() {
        return mapper.toPersonDtoList(personRepository.findAll());
    }

    public PersonDTO getPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new InvalidClientRequestException("Person not found with id: " + id, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toPersonDto(optionalPerson.get());
    }

    public PersonDTO findByPersonName(String personName) {
        Optional<Person> optionalPerson = personRepository.findByPersonName(personName);
        if (optionalPerson.isEmpty()) {
            throw new InvalidClientRequestException("Person not found with name: " + personName, ErrorCodes.CLIENT_INVALID_PARAMETER.getErrorCode());
        }
        return mapper.toPersonDto(optionalPerson.get());
    }

    public Boolean existsByPersonName(String personName) {
        return personRepository.existsByPersonName(personName);
    }
}