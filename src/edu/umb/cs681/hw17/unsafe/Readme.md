## Spotify Music Player

This class `Spotify` implements a simple music player that can be controlled by multiple threads.
The `Spotify` class has the following methods:

### `play()`
This method plays the current track of the playlist.
It simply reads the current track from the playlist and prints a message indicating the thread that is playing the track and the name of the track being played.
This method acquires a read lock to ensure thread-safety.

### `pause()`
This method pauses the current track of the playlist.
It simply reads the current track from the playlist and prints a message indicating the thread that is pausing the track and the name of the track being paused.
This method acquires a read lock to ensure thread-safety.

### `next()`
This method moves to the next track in the playlist.
It increments the current index and prints a message indicating the thread that is moving to the next track and the name of the next track.
This method acquires a write lock to ensure thread-safety.

### `previous()`
This method moves to the previous track in the playlist.
It decrements the current index and prints a message indicating the thread that is moving to the previous track and the name of the previous track.
This method acquires a write lock to ensure thread-safety.

### `get()`
This method returns the name of the current track in the playlist.
This method acquires a read lock to ensure thread-safety.

### `setPlaylist(List<String> playlist)`
This method sets the playlist of the music player.
This method acquires a write lock to ensure thread-safety.

### `reset()`
This method resets the current index to 0 if it is greater than or equal to the size of the playlist.
This method acquires a write lock to ensure thread-safety.

The `Spotify` class uses a `ReentrantReadWriteLock` to ensure thread-safety, allowing multiple threads to read the playlist simultaneously, while allowing only one thread to write to the playlist at a time to avoid race conditions.
But this code creats a deadlock issue. The deadlock issue in this scenario is that the `BluetoothController` thread is calling the `next()` method multiple times on the `Spotify` object without releasing the lock on the `ReentrantReadWriteLock` instance.
Meanwhile, the `reset()` method of the `Spotify` class, which is called from the `LaptopController` thread, also requires the write lock on the same `ReentrantReadWriteLock` instance.
If the `next()` method of `BluetoothController` is holding the write lock when `reset()` of `LaptopController` is called, the `reset()` method will not be able to acquire the write lock and will be blocked indefinitely, resulting in a deadlock.