package edu.umb.cs681.hw16.unsafe;

import java.util.List;

class main {
    public static void main(String[] args) {
        System.out.println("\nUnsafe version of race condition.\n");
        Spotify spotify = new Spotify();

        System.out.println("Setting playlist");
        spotify.setPlaylist(List.of("Song 1", "Song 2", "Song 3", "Song 4", "Song 5"));

        LaptopController laptopController1 = new LaptopController(spotify);
//        LaptopController laptopController2 = new LaptopController(spotify);
        BluetoothController bluetoothController = new BluetoothController(spotify);

        Thread laptopThread1 = new Thread(laptopController1);
//        Thread laptopThread2 = new Thread(laptopController2);
        Thread bluetoothThread = new Thread(bluetoothController);

        laptopThread1.start();
//        laptopThread2.start();
        bluetoothThread.start();
    }
}