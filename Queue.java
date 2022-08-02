import java.util.LinkedList;

/*
 * Generic Queue Implementation
 * Author: Priyank Thakur
 */
public class Queue<T> {
    private LinkedList<T> queue;

    public Queue() {
        queue = new LinkedList<T>();
    }

    public Queue(T element) {
        queue = new LinkedList<T>();
        queue.addLast(element);
    }

    public boolean isQueueEmpty() {
        return queue.size() == 0;
    }

    public int sizeQueue() {
        return queue.size();
    }

    public void enQueue(T element) {
        queue.addLast(element);
    }

    public T deQueue() { // remove first element from queue
        if (isQueueEmpty())
            throw new RuntimeException("Queue is Empty");
        return queue.removeFirst();
    }

    public T peekQueue() { // return first element in queue
        if (isQueueEmpty())
            throw new RuntimeException("Queue is Empty");
        return queue.getFirst();
    }
}
