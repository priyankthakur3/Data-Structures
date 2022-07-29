/*
 * Generic Double Linked List Implementation
 * Author: Priyank Thakur
 */

public class DoubleLinkedList<T> {

    private int size = 0;

    private Node<T> head = null;
    private Node<T> tail = null;

    // internal node class to store Double LinkedList DS
    private static class Node<T> {
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
        // set null for all nodes for memory clear
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

    public T lookFirst() {
        if (isEmptyList())
            throw new RuntimeException("List Empty");
        return head.data;
    }

    public T lookLast() {
        if (isEmptyList())
            throw new RuntimeException("List Empty");
        return tail.data;
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

    public int getElementIndex(Object elm) {
        int i = 0;
        Node<T> trav_node = head;
        while (trav_node != null) {
            if (elm == null && trav_node.data == null) {
                return i;
            } else if (elm.equals(trav_node.data)) {
                return i;
            }
            trav_node = trav_node.next;
            i++;
        }

        return -1;
    }

    // internal function to remove node
    private T removeElement(Node<T> nodeElm) {

        // check if list is empty
        if (isEmptyList())
            throw new RuntimeException("List Empty");
        // check if node is either head or tail node
        if (nodeElm.prev == null)
            return removeFirstElementList();
        if (nodeElm.next == null)
            return removeLastElementList();

        nodeElm.next.prev = nodeElm.prev;
        nodeElm.prev.next = nodeElm.next;
        T data = nodeElm.data;

        // cleanup node memory
        nodeElm.next = nodeElm.prev = null;
        nodeElm.data = null;
        --size;

        return data;
    }

    public boolean removeElement(Object elm) {
        Node<T> travNode = head;
        if (elm == null) {
            for (travNode = head; travNode != null; travNode = travNode.next) {
                if (travNode.data == null) {
                    removeElement(travNode);
                    return true;
                }
            }
        }

        else {
            for (travNode = head; travNode != null; travNode = travNode.next) {
                if (elm.equals(travNode.data)) {
                    removeElement(travNode);
                    return true;
                }
            }
        }

        return false;
    }

    public T removeLastElementList() {

        if (isEmptyList())
            throw new RuntimeException("Empty List");
        T data = tail.data;
        tail = tail.prev;
        --size;

        if (isEmptyList())
            head = null; // if list is empty set head to null
        else
            tail.next = null;
        return data;
    }

    public T removeFirstElementList() {
        if (isEmptyList())
            throw new RuntimeException("Empty List");
        T data = head.data;
        head = head.next;
        --size;

        if (isEmptyList())
            tail = null; // if list is empty set tail to null
        else
            head.prev = null;
        return data;
    }

    public T removeElementAtList(int index) {
        int i;
        Node<T> travNode;
        if (index > sizeList() || index < 0)
            throw new IndexOutOfBoundsException("Illegal Index passed");
        if (index < (sizeList() / 2)) {
            for (i = 0, travNode = head; i != index; i++) {
                travNode = travNode.next;
            }
        } else {
            for (i = sizeList() - 1, travNode = tail; i != index; i--) {
                travNode = travNode.prev;
            }
        }
        return removeElement(travNode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> travnNode = head;
        while (travnNode != null) {
            sb.append(travnNode.data + ", ");
            travnNode = travnNode.next;
        }

        return sb.substring(0, sb.length() - 2) + " ]";
    }
}
