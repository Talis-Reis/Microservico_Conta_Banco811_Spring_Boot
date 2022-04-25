package com.santander.banco811.conta.userExists;

import com.santander.banco811.conta.payload.userExists.userExists;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class getUserExists {

    public userExists execute(String cpf) {
        String url = "http://localhost:8080/usuario/{cpf}";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<userExists> userExistsResponseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, userExists.class, cpf);

        if (userExistsResponseEntity.getStatusCode().isError()) {
            return null;
        }

        return userExistsResponseEntity.getBody();
    }

}
