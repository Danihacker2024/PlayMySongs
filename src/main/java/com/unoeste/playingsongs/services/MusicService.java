package com.unoeste.playingsongs.services;

import com.google.gson.Gson;
import com.mongodb.client.*;
import com.unoeste.playingsongs.entities.Music;
import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService {
    private final String connectionString = "mongodb://localhost:27017";

    public List<Music> findMusicsByKeyWord(String keyword){
        List<Music> musicList = new ArrayList<>();
        //acesso ao MongoDB
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("my_musics");
        //selecionando uma coleção
        MongoCollection<Document> collection = database.getCollection("musics");
        MongoCursor<Document> cursor = collection.find().iterator();
        //busca por música que satisfazem a pesquisa
        while(cursor.hasNext()){
            Music music = new Gson().fromJson(cursor.next().toJson(), Music.class);
            musicList.add(music);
        }
        mongoClient.close();
        //retorno da lista de músicas
        return musicList;
    }
}
