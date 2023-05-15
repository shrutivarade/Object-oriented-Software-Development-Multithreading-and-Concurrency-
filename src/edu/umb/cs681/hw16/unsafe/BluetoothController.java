package edu.umb.cs681.hw16.unsafe;

class BluetoothController implements Runnable {
    private Spotify spotify;

    public BluetoothController(Spotify spotify) {
        this.spotify = spotify;
    }

    @Override
    public void run() {
//        System.out.println("Bluetooth " + Thread.currentThread() + " playing");
        spotify.play();
//        System.out.println("Bluetooth " + Thread.currentThread() + " next");
        spotify.next();
//        System.out.println("Bluetooth " + Thread.currentThread() + " playing");
        spotify.play();
//        System.out.println("Bluetooth " + Thread.currentThread() + " previous");
        spotify.previous();
//        System.out.println("Bluetooth " + Thread.currentThread() + " playing");
        spotify.play();
    }
}