package com.unoeste.playingsongs.entities;

import org.bson.types.ObjectId;

public class Music {
    private String title;
    private String artist;
    private String style;
    private String musicFile;
    private ObjectId _id;//ainda não funciona, precisa arrumar

    public Music(String title, String artist, String style, ObjectId _id) {
        this.title = title;
        this.artist = artist;
        this.style = style;
        this._id = _id;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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
