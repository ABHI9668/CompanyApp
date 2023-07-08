package com.example.Company.companyApp.controller;


import com.example.Company.companyApp.model.Address;
import com.example.Company.companyApp.repository.AddressRepository;
import com.example.Company.companyApp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address addressData) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            address.toString(addressData.getStreet());
            address.setCity(addressData.getCity());
            address.setState(addressData.getState());
            address.setZipcode(addressData.getZipcode());
            return addressRepository.save(address);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressRepository.deleteById(id);
    }
}
