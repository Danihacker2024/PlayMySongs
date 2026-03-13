package com.unoeste.playingsongs.services;

import com.google.gson.Gson;
import com.mongodb.client.*;
import com.unoeste.playingsongs.entities.Music;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService {
    private final String connectionString = "mongodb://localhost:27017";


    public List<Music> findMusicsByKeyWord(String keyword){
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase dataBase = mongoClient.getDatabase("my_musics");
        MongoCollection<Document> collection = dataBase.getCollection("musics");
        MongoCursor<Document> cursor = collection.find().iterator();
        //acesso ao MongoDB
        //busca por músicas que satisfazem a pesquisa
        //retorno da lista de música
        List<Music> musicList = new ArrayList<>();
        while (cursor.hasNext()) {
            Music music = new Gson().fromJson(cursor.next().toJson(),Music.class);
            musicList.add(music);
        }
        musicList.add(new Music("Jetski","Pedro Sampaio", "funk"));
        musicList.add(new Music("Última Saudade","Henrique & Juliano", "Sertanejo"));
        return musicList;
    }
}
