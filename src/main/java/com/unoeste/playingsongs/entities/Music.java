package com.unoeste.playingsongs.entities;


import org.bson.types.ObjectId;

public class Music {


    private ObjectId id;
    private String title;
    private String artist;
    private String style;
    private String musicFile;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Music(String title, String artist, String style, String musicFile) {
        this.title = title;
        this.artist = artist;
        this.style = style;
        this.musicFile = musicFile;
    }

    public Music(String title, String artist, String style) {
        this.title = title;
        this.artist = artist;
        this.style = style;
        this.musicFile = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMusicFile() {
        return musicFile;
    }

    public void setMusicFile(String musicFile) {
        this.musicFile = musicFile;
    }
}
