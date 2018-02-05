package com.fortech.dbservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Persons")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

    @Id
    private String id;

    @NonNull
    private String name;

    private List<Address> addresses;

    public Person(String name, Address address) {
        this.name = name;
        addAddresses(address);
    }

    public void addAddresses(Address address) {
        if (addresses == null) {
            this.addresses = new ArrayList<>();
        }
        if (address != null && !address.getAddress().isEmpty())
            this.addresses.add(address);
    }
}
