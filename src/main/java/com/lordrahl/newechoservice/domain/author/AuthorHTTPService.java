package com.lordrahl.newechoservice.domain.author;


import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.lordrahl.newechoservice.config.ESConfig;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class AuthorHTTPService implements AuthorService {
    private final ESConfig esConfig;
    private final Logger logger = Logger.getLogger(AuthorHTTPService.class.getName());

    public AuthorHTTPService(ESConfig esConfig) {
        this.esConfig = esConfig;
    }

    @Override
    public AuthorResponse save(AuthorRequest authorRequest) throws IOException {
        Author author = Author.builder()
                .id(UUID.randomUUID().toString())
                .firstName(authorRequest.getFirstName())
                .lastName(authorRequest.getLastName())
                .email(authorRequest.getEmail())
                .phone(authorRequest.getPhone())
                .build();

        IndexResponse indexResponse = esConfig.elasticsearchClient()
                .index(i -> i.index("authors").id(author.getId()).document(author)
                );
        logger.info("indexed with version " + indexResponse.version() + " with ID " + indexResponse.id());
        logger.info("index response:" + indexResponse);

        return AuthorResponse.builder()
                .id(indexResponse.id())
                .firstName(authorRequest.getFirstName())
                .lastName(authorRequest.getLastName())
                .email(author.getEmail())
                .phone(author.getPhone())
                .build();
    }

    @Override
    public List<AuthorResponse> findAll() {
        return null;
    }
}
