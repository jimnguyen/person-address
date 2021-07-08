package jim.api.personaddress.config;

import jim.api.personaddress.model.Address;
import jim.api.personaddress.model.Person;
import jim.api.personaddress.repository.AddressRepository;
import jim.api.personaddress.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonAddressConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository, AddressRepository addressRepository) {
        return args -> {

            Person jim =
                    new Person(1, "Jim", "Nguyen",
                    new Address(1, 1 , "123 React Lane",
                            "JavaScript", "JS", "12345"));

            Person chance =
                    new Person(2, "Chance", "Nguyen",
                    new Address(2, 2 , "321 React Lane",
                            "JavaScript", "JS", "12346"));

            Address address1 = new Address(1, 1 , "123 React Lane",
                    "JavaScript", "JS", "12345");

            Address address2 = new Address(2, 2 , "321 React Lane",
                    "JavaScript", "JS", "12346");

            personRepository.saveAll(List.of(jim, chance));
            addressRepository.saveAll(List.of(address1, address2));
        };
    }
}
