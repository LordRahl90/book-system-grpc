package com.lordrahl.newechoservice.domain.author;

import lombok.Data;

@Data
public class AuthorRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
