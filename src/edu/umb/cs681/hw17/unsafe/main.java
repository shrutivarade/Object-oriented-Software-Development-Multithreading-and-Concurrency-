package edu.umb.cs681.hw17.unsafe;

import java.util.List;

class main {
    public static void main(String[] args) {

        System.out.println("\nUnsafe version of Deadlock.\n");
        Spotify spotify = new Spotify();

        System.out.println("Setting playlist");
        spotify.setPlaylist(List.of("Song 1", "Song 2", "Song 3", "Song 4", "Song 5","Song 6", "Song 7", "Song 8", "Song 9", "Song 10"));

        BluetoothController bluetoothController = new BluetoothController(spotify);
        LaptopController laptopController = new LaptopController(spotify);

        Thread bluetoothThread = new Thread(bluetoothController);
        Thread laptopThread = new Thread(laptopController);

        bluetoothThread.start();
        laptopThread.start();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.println(e.toString());
        }
        bluetoothController.setFlagAtomic();
        bluetoothThread.interrupt();
        laptopController.setFlagAtomic();
        laptopThread.interrupt();

    }
}