package edu.umb.cs681.hw17.safe;

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

        spotify.play();
        while(true){
            if(flagAtomic.get()){
                break;
            }
            spotify.next();
        }


    }
}