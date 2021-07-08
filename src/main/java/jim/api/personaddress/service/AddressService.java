package jim.api.personaddress.service;

import jim.api.personaddress.model.Address;
import jim.api.personaddress.repository.AddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public List<Address> getAddressByState(String state) {
        return addressRepository.findByState(state);
    }

    public List<Address> getAddressInSameCity(String city, String state) {
        return addressRepository.addressInSameCity(city, state);
    }

    public ResponseEntity<Address> addAddress(Address address) {
        return ResponseEntity.status(201).body(addressRepository.save(address));
    }
}
