package jim.api.personaddress.controller;

import jim.api.personaddress.model.Person;
import jim.api.personaddress.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public List<Person> getAllPeople() {
        return personService.getPeople();
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
        return personService.addPerson(person);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable int id) {
        return personService.deletePerson(id);
    }
}
