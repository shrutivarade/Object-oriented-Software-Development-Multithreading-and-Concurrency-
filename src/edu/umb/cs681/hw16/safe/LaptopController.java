package edu.umb.cs681.hw16.safe;

class LaptopController implements Runnable {
    private Spotify spotify;

    public LaptopController(Spotify spotify) {
        this.spotify = spotify;
    }

    @Override
    public void run() {
//        System.out.println("Laptop " + Thread.currentThread() + " playing");
        spotify.play();
//        System.out.println("Laptop " + Thread.currentThread() + " next");
        spotify.next();
//        System.out.println("Laptop " + Thread.currentThread() + " playing");
        spotify.play();
//        System.out.println("Laptop " + Thread.currentThread() + " next");
        spotify.next();
//        System.out.println("Laptop " + Thread.currentThread() + " playing");
        spotify.play();
//        System.out.println("Laptop " + Thread.currentThread() + " pausing");
        spotify.pause();
    }
}