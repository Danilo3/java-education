package com.koryakin.mongodemo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;


@Data
@RequiredArgsConstructor()
public class Customer {

    @Id
    public String id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

}
