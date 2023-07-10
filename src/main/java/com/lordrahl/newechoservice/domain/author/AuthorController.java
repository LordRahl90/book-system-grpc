package com.lordrahl.newechoservice.domain.author;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private final AuthorHTTPService authorHTTPService;

    public AuthorController(AuthorHTTPService authorHTTPService) {
        this.authorHTTPService = authorHTTPService;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest authorRequest) throws Exception {
        AuthorResponse authorResponse = authorHTTPService.save(authorRequest);
        return ResponseEntity.ok(authorResponse);
    }
}
