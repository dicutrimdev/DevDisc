package com.dominio.devdisc.controllers;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.services.SpotifyAuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SpotifyAuthController {
    private final SpotifyAuthService spotifyAuthService;

    @GetMapping("/spotify/token")
    public String getToken() {
        return spotifyAuthService.getToken();
    }
}
