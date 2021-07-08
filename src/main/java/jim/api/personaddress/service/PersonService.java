package jim.api.personaddress.service;

import jim.api.personaddress.model.Person;
import jim.api.personaddress.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public ResponseEntity<Person> addPerson(Person person) {
        return ResponseEntity.status(201).body(personRepository.save(person));
    }

    public ResponseEntity<Person> deletePerson(int id) {
        Optional<Person> personOptional = personRepository.findById(id);


        if (personOptional.isPresent()) {
            personRepository.deleteById(id);
            return ResponseEntity.status(200).body(personOptional.get());
        }

        return ResponseEntity.status(400).body(new Person());
    }
}
