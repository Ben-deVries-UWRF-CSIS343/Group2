package org.springframework.projectname;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
class AddressController {
    private AddressRepository repository;

    public AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    AddressMockData addressMockedData = AddressMockData.getInstance();

    @GetMapping("/address")
    public List<Address> index() {
        return addressMockedData.fetchAddressList();
    }

    @PostMapping(path="/address",consumes="application/json",produces="application/json" )
    public Address create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String addressLine1 = body.get("addressLine1");
        String addressLine2 = body.get("addressLine2");
        int zipcode = Integer.parseInt(body.get("zipCode"));
        String state = body.get("state");
        String city = body.get("city");
        return addressMockedData.createAddress(id, name, addressLine1, addressLine2, zipcode, state, city);
    }

    /* Example of using a separate function to do additional computations */
//    @GetMapping("/cool-names")
//    public Collection<Address> coolNames() {
//        return repository.findAll().stream()
//                .filter(this::isCool)
//                .collect(Collectors.toList());
//    }
//
//    private boolean isCool(Address addr) {
//        return !addr.getName().equals("Schaber") &&
//                !addr.getName().equals("DeVries") &&
//                !addr.getName().equals("Carll");
//    }
}