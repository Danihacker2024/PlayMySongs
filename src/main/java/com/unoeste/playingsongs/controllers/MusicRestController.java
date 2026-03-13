package com.unoeste.playingsongs.controllers;

import com.unoeste.playingsongs.entities.Erro;
import com.unoeste.playingsongs.entities.Music;
import com.unoeste.playingsongs.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apis")
public class MusicRestController {
    @Autowired
    private MusicService musicService;

    @PostMapping("music-upload")
    public ResponseEntity<Object> uploadMusic(String title, String artist, String style, MultipartFile file){
        if(title.isEmpty() || artist.isEmpty() || style.isEmpty() || file == null){
            return ResponseEntity.badRequest().body(new Erro("Dados incompletos", "Preencha todos os campos"));
        }
        else{
            String filename = title + "_" + style + "_" + artist;
            String caminho = "src/main/resources/musics/";
            try {
                File folder = new File(caminho);
                if (!folder.exists())
                    folder.mkdir();
                file.transferTo(new File(folder.getAbsolutePath() + "\\" + filename));
                return ResponseEntity.ok("");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping("find-musics")
    public ResponseEntity<Object> findMusics(String keyWord) {
        List<Music> musicList = new ArrayList<>();
        //pedir à camada Service as músicas que satisfazem à  busca
        musicList = musicService.findMusicsByKeyWord(keyWord);
        return ResponseEntity.ok(musicList);
    }

    @GetMapping("get-music-styles")
    public ResponseEntity<Object> getStyles(){
        //pedir à camda Service as músicas que staisfazem à busca
        return ResponseEntity.ok("lista de estilos musicais");
    }
}
