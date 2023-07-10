package com.lordrahl.newechoservice.domain.author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    AuthorResponse save(AuthorRequest authorRequest) throws IOException;

    List<AuthorResponse> findAll();

}
