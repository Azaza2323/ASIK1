# Library System

This Java application represents a simple library system with a Singleton pattern.

## Task 1: Singleton Implementation (20 points)

1. **Implement the Singleton design pattern following the traditional Singleton approach.**
    - Implemented in the `Library` class.

2. **Provide a method within the Singleton class to demonstrate its functionality.**
    - The `getInstance` method in the `Library` class demonstrates Singleton functionality.

3. **Create a client class to demonstrate the Singleton pattern in action by creating and using an instance of the Singleton class.**
    - Implemented in the `Main` class.

## Task 2: Thread Safety (10 points)

1. **Ensure that your Singleton implementation is thread-safe.**
    - The `getInstance` method is implemented to be thread-safe using double-check locking.

2. **Demonstrate thread safety by creating multiple threads that attempt to access the Singleton instance concurrently.**
    - Thread safety is ensured by the synchronized block in the `getInstance` method.
