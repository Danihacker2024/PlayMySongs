package com.unoeste.playingsongs.controllers;

import com.unoeste.playingsongs.entities.Erro;
import com.unoeste.playingsongs.entities.Music;
import com.unoeste.playingsongs.repositories.MusicRepository;
import com.unoeste.playingsongs.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apis")
public class MusicRestController {
    private MusicRepository musicRepository;
    @Autowired
    private MusicService musicService;

    @PostMapping("upload-musics")
    public ResponseEntity<Object> addMusics(String title, String artist, String style, MultipartFile file) {
        //receber o arquivo da musica
            //criar o novo nome do arquivo
        //  gravar o arquivo na pasta MUSICS
        //Criar um objeto do tipo Musics
        //Enviar a camada Service para fazer a persistencia
        //Retornar sucesso ou erro
        return ResponseEntity.ok("");
    }

    @GetMapping("find-musics")
    public ResponseEntity<Object> findMusics(String keyWord) {
        List <Music> lista=new ArrayList<>();
        lista = musicService.findMusicsByKeyWord(keyWord);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("get-music-styles")
    public ResponseEntity<Object> getStyles() {
        List <String> lista=new ArrayList<>();
        for(String estilo:lista){
            lista.add(estilo);
        }
        return ResponseEntity.ok("Lista de estilos musicais");
    }
}
