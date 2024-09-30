## Deadlock-Safe Version of Spotify

This version of Spotify is designed to be deadlock-safe by using locks and conditions to prevent potential deadlocks that could occur in the unsafe version.
The `Spotify` class uses a `ReentrantReadWriteLock` to allow multiple threads to read the playlist at the same time while ensuring that only one thread can write to the playlist at any given time.

The `resetCondition` variable is a `Condition` object that is used to signal all waiting threads when the playlist is reset.
The `next` method uses a `while` loop to wait for the playlist to reset if the current index exceeds the size of the playlist.
This prevents the thread from getting stuck in a deadlock while waiting for the playlist to reset.

Overall, this version of Spotify is designed to be safe for use in a multi-threaded environment, preventing potential deadlocks and ensuring that threads can access the playlist without interfering with one another.