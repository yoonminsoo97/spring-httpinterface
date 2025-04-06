package com.example.httpinterface.config;

import com.example.httpinterface.client.PostHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterfaceConfig {

    @Value("${base-url}")
    private String baseUrl;

    @Bean
    public PostHttpClient postHttpClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();
        return factory.createClient(PostHttpClient.class);
    }

}
