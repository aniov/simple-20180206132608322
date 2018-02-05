package com.fortech.dbservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Persons")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

    @Id
    private String id;
    @NonNull
    private String name;

}
