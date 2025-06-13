package com.dominio.devdisc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.dominio.devdisc.dtos.SpotifyAlbumDTO;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotifyDiscoService {
    private final RestTemplate restTemplate;
    private final SpotifyAuthService spotifyAuthService;

    public List<SpotifyAlbumDTO> buscarDiscosPorArtista(String nomeArtista) {
        var token = spotifyAuthService.getToken();
        var urlBuscaArtista = "https://api.spotify.com/v1/search?q=" + nomeArtista + "&type=artist&limit=1";

        var headers = new HttpHeaders();
        headers.setBearerAuth(token);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<LinkedHashMap> resposta = restTemplate.exchange(urlBuscaArtista,
                HttpMethod.GET, entity, LinkedHashMap.class);

        LinkedHashMap<String, Object> respostaBody = resposta.getBody();
        LinkedHashMap<String, Object> artistas = (LinkedHashMap<String, Object>) respostaBody.get("artists");
        List<LinkedHashMap<String, Object>> listaArtistas = (List<LinkedHashMap<String, Object>>) artistas.get("items");

        if (listaArtistas.isEmpty()) {
            return new ArrayList<>();
        }

        LinkedHashMap<String, Object> artista = listaArtistas.get(0);
        String artistaId = (String) artista.get("id");

        var urlAlbuns = "https://api.spotify.com/v1/artists/" + artistaId + "/albums?market=BR&limit=5";

        ResponseEntity<LinkedHashMap> respostaAlbuns = restTemplate.exchange(urlAlbuns, HttpMethod.GET,
                entity, LinkedHashMap.class);

        LinkedHashMap<String, Object> corpoAlbuns = respostaAlbuns.getBody();
        List<LinkedHashMap<String, Object>> listaAlbuns = (List<LinkedHashMap<String, Object>>) corpoAlbuns.get("items");

        List<SpotifyAlbumDTO> resultado = new ArrayList<>();

        for (LinkedHashMap<String, Object> album : listaAlbuns) {
            SpotifyAlbumDTO dto = new SpotifyAlbumDTO();
            dto.setNome((String) album.get("name"));
            dto.setDataLancamento((String) album.get("release_date"));

            List<LinkedHashMap<String, Object>> imagens = (List<LinkedHashMap<String, Object>>) album.get("images");
            if (!imagens.isEmpty()) {
                String imagemUrl = (String) imagens.get(0).get("url");
                dto.setImagemUrl(imagemUrl);
            }

            resultado.add(dto);
        }
        return resultado;
    }
}
