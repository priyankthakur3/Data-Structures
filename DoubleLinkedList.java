
public class DoubleLinkedList<T> {

    private int size = 0;

    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public void clearList() {
        Node<T> travNode = head;
        Node<T> travNextNode;
        while (travNode.next != null) {
            travNextNode = travNode.next;
            travNode.prev = travNode.next = null;
            travNode.data = null;
            travNode = travNextNode;
        }
        head = tail = travNode = travNextNode = null;
        size = 0;
    }

    public int sizeList() {
        return size;
    }

    public boolean isEmptyList() {
        return size == 0;
    }

    public void addElementList(T elm) {
        addLastElementList(elm);
    }

    public void addFirstElementList(T elm) {
        if (isEmptyList()) {
            head = tail = new Node<T>(elm, null, null);
        } else {
            head.prev = new Node<T>(elm, null, head);
            head = head.prev;
        }
        size++;
    }

    public void addLastElementList(T elm) {
        if (isEmptyList()) {
            head = tail = new Node<T>(elm, null, null);
        } else {
            tail.next = new Node<T>(elm, tail, null);
            tail = tail.next;
        }
        size++;
    }
}
