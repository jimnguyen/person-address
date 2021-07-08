package jim.api.personaddress.controller;

import jim.api.personaddress.model.Address;
import jim.api.personaddress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<Address> getAddresses() {
        return addressService.getAddresses();
    }

    @GetMapping("/address/{state}")
    public List<Address> getAddressByState(@PathVariable String state) {
        return addressService.getAddressByState(state);
    }

    @GetMapping("/address/")

    @PostMapping("/address")
    public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address) {
        return addressService.addAddress(address);
    }
}
