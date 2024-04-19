public class LinearQueue {
    private int maxSize; // maximum size of the queue
    private int[] queueArray; // array to store elements
    private int front; // front of the queue
    private int rear; // rear of the queue
    private int currentSize; // current number of elements in the queue

    // Constructor
    public LinearQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    // Insert an element at the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
        } else {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = data;
            currentSize++;
            System.out.println("Enqueued element: " + data);
        }
    }

    // Remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        } else {
            int dequeuedElement = queueArray[front];
            front = (front + 1) % maxSize;
            currentSize--;
            System.out.println("Dequeued element: " + dequeuedElement);
            return dequeuedElement;
        }
    }

    // Get the front element of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No element to peek.");
            return -1;
        } else {
            return queueArray[front];
        }
    }

    // Get the current size of the queue
    public int size() {
        return currentSize;
    }

    // Display the elements of the queue
    public void display() {
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < currentSize; i++) {
            int index = (front + i) % maxSize;
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display(); // Queue (front to rear): 10 20 30 40

        System.out.println("Front element: " + queue.peek()); // Front element: 10

        queue.dequeue();
        queue.dequeue();
        queue.display(); // Queue (front to rear): 30 40

        System.out.println("Current size: " + queue.size()); // Current size: 2
    }
}