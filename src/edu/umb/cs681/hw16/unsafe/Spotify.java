package edu.umb.cs681.hw16.unsafe;

import java.util.ArrayList;
import java.util.List;

class Spotify {
    private List<String> playlist = new ArrayList<>();
    private int currentIndex = 0;

    public void play() {
        System.out.println("Thread " + Thread.currentThread() + " playing: " + playlist.get(currentIndex));
    }

    public void pause() {
        System.out.println("Thread " + Thread.currentThread() + " pausing: " + playlist.get(currentIndex));
    }

    public void next() {
        if (currentIndex < playlist.size() - 1) {
            currentIndex++;
        }
        System.out.println("Thread " + Thread.currentThread() + " next: " + playlist.get(currentIndex));
    }

    public void previous() {
        if (currentIndex > 0) {
            currentIndex--;
        }
        System.out.println("Thread " + Thread.currentThread() + " previous: " + playlist.get(currentIndex));
    }

    public String get() {
        return playlist.get(currentIndex);
    }

    public void setPlaylist(List<String> playlist) {
        this.playlist = playlist;
    }
}






