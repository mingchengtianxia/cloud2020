package com.soundSystem;

import java.util.List;

public class BlankDisc implements CompactDisc{
    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public BlankDisc() {
    }

    @Override
    public void playSound() {

    }
}
