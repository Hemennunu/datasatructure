import java.util.Stack;

public class LinearQueueWithStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public LinearQueueWithStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void enqueue(int data) {
        stack1.push(data);
        System.out.println("Enqueued element: " + data);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        int dequeuedElement = stack2.pop();
        System.out.println("Dequeued element: " + dequeuedElement);
        return dequeuedElement;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No element to peek.");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        LinearQueueWithStacks queue = new LinearQueueWithStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // Front element: 10

        queue.dequeue();
        queue.dequeue();

        System.out.println("Current size: " + queue.size()); // Current size: 1
    }
}