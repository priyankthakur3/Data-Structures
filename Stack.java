import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * Generic Dynamic Stack Implementation
 * Author: Priyank Thakur
 */
public class Stack<T> {
    private LinkedList<T> stackList;

    public Stack() { // initialize new Stack
        stackList = new LinkedList<T>();
    }

    public Stack(T element) {// initialize new Stack and push first element
        stackList = new LinkedList<T>();
        stackPush(element);
    }

    public int stackSize() { // return Size of Stack
        return stackList.size();
    }

    public boolean stackisEmpty() {// return if stack is empty or not
        return stackSize() == 0;
    }

    public void stackPush(T element) { // add element onto Stack
        stackList.addLast(element);
    }

    public T stackPop() {
        if (stackisEmpty()) // if stack is empty throw stack empty exception
            throw new EmptyStackException();
        return stackList.removeLast();
    }

    public T stackPeek() { // return first element of stack
        if (stackisEmpty())
            throw new EmptyStackException();
        return stackList.peekLast();
    }

    public boolean stackContains(Object element) {

        // define an iterator to parse stack
        Iterator<T> stackIterator = stackList.iterator();

        while (stackIterator.hasNext()) {
            return element.equals(stackIterator.next()); // return if element is present in stack
        }
        return false;
    }
}
