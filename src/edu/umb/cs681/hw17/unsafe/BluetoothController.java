package edu.umb.cs681.hw17.unsafe;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;

class BluetoothController implements Runnable {
    private Spotify spotify;
    private AtomicBoolean flagAtomic = new AtomicBoolean(false);
    public void setFlagAtomic() {
        flagAtomic.set(true);
    }
    public BluetoothController(Spotify spotify) {
        this.spotify = spotify;
    }

    @Override
    public void run() {
        if(flagAtomic.get()){
            return;
        }
        while (!flagAtomic.get()){
            spotify.play();
            spotify.next();
        }

    }
}