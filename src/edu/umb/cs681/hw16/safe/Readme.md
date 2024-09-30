## Spotify Music Player

This class `Spotify` implements a simple music player that can be controlled by 2 threads namely LaptopController and BluetoothController.
The `Spotify` class has the following methods:

### `play()`
This method plays the current track of the playlist.
It acquires a read lock on the `ReentrantReadWriteLock` object before reading the current track from the playlist.
Once it has the lock, it prints a message indicating the thread that is playing the track and the name of the track being played.

### `pause()`
This method pauses the current track of the playlist.
It acquires a read lock on the `ReentrantReadWriteLock` object before reading the current track from the playlist.
Once it has the lock, it prints a message indicating the thread that is pausing the track and the name of the track being paused.

### `next()`
This method moves to the next track in the playlist.
It acquires a write lock on the `ReentrantReadWriteLock` object before modifying the current index.
Once it has the lock, it increments the current index and prints a message indicating the thread that is moving to the next track and the name of the next track.

### `previous()`
This method moves to the previous track in the playlist.
It acquires a write lock on the `ReentrantReadWriteLock` object before modifying the current index.
Once it has the lock, it decrements the current index and prints a message indicating the thread that is moving to the previous track and the name of the previous track.

### `get()`
This method returns the name of the current track in the playlist.
It acquires a read lock on the `ReentrantReadWriteLock` object before reading the current track from the playlist.

### `setPlaylist(List<String> playlist)`
This method sets the playlist of the music player.
It acquires a write lock on the `ReentrantReadWriteLock` object before modifying the playlist.

Here the shared variable is currentIndex and playlist.

The `Spotify` class uses the `ReentrantReadWriteLock` class to ensure that multiple threads can control the music player safely and prevent it from potential race conditions.