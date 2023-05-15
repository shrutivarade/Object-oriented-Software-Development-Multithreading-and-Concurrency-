package edu.umb.cs681.hw17.safe;

import java.util.concurrent.atomic.AtomicBoolean;

class LaptopController implements Runnable {
    private Spotify spotify;
    private AtomicBoolean flagAtomic = new AtomicBoolean(false);
    public void setFlagAtomic() {
        flagAtomic.set(true);
    }

    public LaptopController(Spotify spotify) {
        this.spotify = spotify;
    }

    @Override
    public void run() {
        if(flagAtomic.get()){
            return;
        }
        spotify.play();
        spotify.reset();
        spotify.play();
        spotify.pause();
    }
}