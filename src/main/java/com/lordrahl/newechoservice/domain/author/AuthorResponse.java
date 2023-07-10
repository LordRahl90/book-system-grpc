package com.lordrahl.newechoservice.domain.author;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
