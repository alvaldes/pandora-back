package cu.cujae.pandora.back.configuration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.cujae.pandora.back.comms.dto.PersonDTO;
import cu.cujae.pandora.back.comms.service.PersonService;


@RestController
@RequestMapping("/config/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping()
    public ResponseEntity<PersonDTO> insertPerson(@RequestBody PersonDTO personDTO) {
        return new ResponseEntity<>(personService.save(personDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDTO) {
        return new ResponseEntity<>(personService.save(personDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PersonDTO>> getPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }

    @GetMapping("person_name/{personName}")
    public ResponseEntity<PersonDTO> findByPerson(@PathVariable("personName") String personName) {
        return new ResponseEntity<>(personService.findByPersonName(personName), HttpStatus.OK);
    }
    
    @GetMapping("exist_person_name/{personName}")
    public ResponseEntity<PersonDTO> existsByPersonName(@PathVariable("personName") String personName) {
        return new ResponseEntity<>(personService.findByPersonName(personName), HttpStatus.OK);
    }
}