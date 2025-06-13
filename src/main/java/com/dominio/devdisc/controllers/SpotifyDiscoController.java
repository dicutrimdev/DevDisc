package com.dominio.devdisc.controllers;

import lombok.RequiredArgsConstructor;
import com.dominio.devdisc.dtos.SpotifyAlbumDTO;
import com.dominio.devdisc.services.SpotifyDiscoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/spotify")
public class SpotifyDiscoController {
    private final SpotifyDiscoService spotifyDiscoService;

    @GetMapping("/discos")
    public List<SpotifyAlbumDTO> buscarDiscosPorArtista(@RequestParam String artista) {
        return spotifyDiscoService.buscarDiscosPorArtista(artista);
    }
}
