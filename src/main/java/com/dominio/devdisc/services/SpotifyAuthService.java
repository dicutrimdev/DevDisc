package com.dominio.devdisc.services;

import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.Base64;

@Service
public class SpotifyAuthService {

    private String token;

    @Value("${devmovie.spotify.client.id}")
    private String clientId;

    @Value("${devmovie.spotify.client.secret}")
    private String clientSecret;

    public String getToken() {
        if (token == null) {
            gerarToken();
        }
        return token;
    }

    private void gerarToken() {
        var credenciais = clientId + ":" + clientSecret;
        var base64Credenciais = Base64.getEncoder().encodeToString(credenciais.getBytes());
        var headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Basic " + base64Credenciais);

        HttpEntity<String> request = new HttpEntity<>("grant_type=client_credentials", headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(
                "https://accounts.spotify.com/api/token",
                request,
                Map.class
        );
        token = (String) response.getBody().get("access_token");
    }
}
