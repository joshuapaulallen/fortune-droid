package org.yourotherleft.fortunetwitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yourotherleft.fortunetwitter.service.type.Fortune;

import java.net.URI;
import java.net.URISyntaxException;

@Service("fortuneApi")
public class FortuneApiServiceImpl implements FortuneService {

    private static final String FORTUNE_API_URI = "https://steakovercooked.com/api/fortune/";
    private static final String FORTUNE_SERVICE_USER_AGENT = "fortune-service";

    private final URI fortuneApiUri;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public FortuneApiServiceImpl() {
        fortuneApiUri = initFortuneApiUri();
    }

    @Override
    public Fortune getFortune() {
        final String fortuneResponse = executeGetFortuneRequest();

        return Fortune.builder()
                .text(fortuneResponse)
                .build();
    }

    private URI initFortuneApiUri() {
        try {
            return new URI(FORTUNE_API_URI);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(String.format("could not parse [%s] into URI", FORTUNE_API_URI));
        }
    }

    private String executeGetFortuneRequest() {
        // prep request with user agent header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.USER_AGENT, FORTUNE_SERVICE_USER_AGENT);
        final HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        // execute
        final ResponseEntity<String> response = restTemplate.exchange(FORTUNE_API_URI, HttpMethod.GET, requestEntity, String.class);
        if (response.getStatusCode().isError()) {
            throw new IllegalStateException(String.format("get fortune request failed, response [%s]", response));
        }

        return response.getBody();
    }

}
