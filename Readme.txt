
###This is the Readme file for HW06:Primes, HW16:Race condition and HW17:Deadlock



HW06:

This HW is placed inside the package src.edu.umb.cs681.primes.hw06_1 and src.edu.umb.cs681.primes.hw06_2
But only 1 xml file is used to execute both the main class for, HW06-1: RunnableCancellablePrimeGenerator and HW06-2: RunnableCancellablePrimeFactorize, i.e hw06.xml



HW16 : Race condition example for Spotify music player

## Spotify Music Player

The class `Spotify` implements a simple music player that can be controlled by multiple threads.
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

The shared variable is currentIndex and playlist.


Unsafe Version : Race condition occurs

The `Spotify` class in this implementation is not thread-safe.
This is because multiple threads may modify the `currentIndex` variable simultaneously, which can lead to unpredictable behavior.
Therefore, it is important to use the `Spotify` class carefully in a multi-threaded environment.
If we need to use it in a thread-safe way, it is recommended to use a `ReentrantReadWriteLock` or another synchronization mechanism to ensure that multiple threads can control the music player safely.

Safe Version : Race condition prevented

### `play()`
It acquires a read lock on the `ReentrantReadWriteLock` object before reading the current track from the playlist.
Once it has the lock, it prints a message indicating the thread that is playing the track and the name of the track being played.

### `pause()`
It acquires a read lock on the `ReentrantReadWriteLock` object before reading the current track from the playlist.
Once it has the lock, it prints a message indicating the thread that is pausing the track and the name of the track being paused.

### `next()`
It acquires a write lock on the `ReentrantReadWriteLock` object before modifying the current index.
Once it has the lock, it increments the current index and prints a message indicating the thread that is moving to the next track and the name of the next track.

### `previous()`
It acquires a write lock on the `ReentrantReadWriteLock` object before modifying the current index.
Once it has the lock, it decrements the current index and prints a message indicating the thread that is moving to the previous track and the name of the previous track.

### `get()`
It acquires a read lock on the `ReentrantReadWriteLock` object before reading the current track from the playlist.

### `setPlaylist(List<String> playlist)`
It acquires a write lock on the `ReentrantReadWriteLock` object before modifying the playlist.

The `Spotify` class uses the `ReentrantReadWriteLock` class to ensure that multiple threads can control the music player safely and prevent it from potential race conditions.



HW17 : Deadlock example for Spotify music player

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

Unsafe Version : Deadlock occurs

The `Spotify` class uses a `ReentrantReadWriteLock` to ensure thread-safety, allowing multiple threads to read the playlist simultaneously, while allowing only one thread to write to the playlist at a time to avoid race conditions. But this code creats a deadlock issue. The deadlock issue in this scenario is that the `BluetoothController` thread is calling the `next()` method multiple times on the `Spotify` object without releasing the lock on the `ReentrantReadWriteLock` instance.Meanwhile, the `reset()` method of the `Spotify` class, which is called from the `LaptopController` thread, also requires the write lock on the same `ReentrantReadWriteLock` instance.
If the `next()` method of `BluetoothController` is holding the write lock when `reset()` of `LaptopController` is called, the `reset()` method will not be able to acquire the write lock and will be blocked indefinitely, resulting in a deadlock.

Safe Version : Deadlock Prevented

This version of Spotify is designed to be deadlock-safe by using locks and conditions to prevent potential deadlocks that could occur in the unsafe version.
The `Spotify` class uses a `ReentrantReadWriteLock` to allow multiple threads to read the playlist at the same time while ensuring that only one thread can write to the playlist at any given time.

The `resetCondition` variable is a `Condition` object that is used to signal all waiting threads when the playlist is reset.
The `next` method uses a `while` loop with await() to wait for the playlist to reset if the current index exceeds the size of the playlist and later signalall() notifys all the threads in waiting threads.
This prevents the thread from getting stuck in a deadlock while waiting for the playlist to reset.

Overall, this version of Spotify is designed to be safe for use in a multi-threaded environment, preventing potential deadlocks and ensuring that threads can access the playlist without interfering with one another.

