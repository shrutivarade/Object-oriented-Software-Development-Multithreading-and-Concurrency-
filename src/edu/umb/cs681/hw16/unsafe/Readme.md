## Spotify Music Player

This class `Spotify` implements a simple music player that can be controlled by multiple threads.
The `Spotify` class has the following methods:

### `play()`
This method plays the current track of the playlist.
It simply reads the current track from the playlist and prints a message indicating the thread that is playing the track and the name of the track being played.

### `pause()`
This method pauses the current track of the playlist.
It simply reads the current track from the playlist and prints a message indicating the thread that is pausing the track and the name of the track being paused.

### `next()`
This method moves to the next track in the playlist.
It increments the current index and prints a message indicating the thread that is moving to the next track and the name of the next track.

### `previous()`
This method moves to the previous track in the playlist.
It decrements the current index and prints a message indicating the thread that is moving to the previous track and the name of the previous track.

### `get()`
This method returns the name of the current track in the playlist.

### `setPlaylist(List<String> playlist)`
This method sets the playlist of the music player.

Here the shared variable is currentIndex and playlist.

The `Spotify` class in this implementation is not thread-safe.
This is because multiple threads may modify the `currentIndex` variable simultaneously, which can lead to unpredictable behavior.
Therefore, it is important to use the `Spotify` class carefully in a multi-threaded environment.
If we need to use it in a thread-safe way, it is recommended to use a `ReentrantReadWriteLock` or another synchronization mechanism to ensure that multiple threads can control the music player safely.