package com.lordrahl.newechoservice.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ESConfig {
    private final ElasticConfig elasticConfig;

    public ESConfig(ElasticConfig elasticConfig) {
        this.elasticConfig = elasticConfig;
    }

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        Header basicHeader = new BasicHeader("Content-Type", "application/json");
        Header[] headers = new Header[]{basicHeader};

        RestClient restClient = RestClient.builder(HttpHost.create(elasticConfig.getHost()))
                .setDefaultHeaders(headers)
                .build();

        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        return new ElasticsearchClient(transport);
    }
}
