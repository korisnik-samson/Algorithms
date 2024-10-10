package lists;

import lib.Node;

import java.util.EmptyStackException;

public class StackList<E extends Comparable<E>> {

    private Node<E> top;

    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = top;

        top = newNode;
    }

    // TODO: redundant return value
    public E pop() {
        if (top == null) throw new EmptyStackException();

        E data = top.data;
        top = top.next;

        return data;
    }

    public E peek() {
        if (top == null) throw new EmptyStackException();

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
