package lists;

import lib.Node;

import java.util.NoSuchElementException;

public class DequeList<E extends Comparable<E>> {
    private Node<E> front;
    private Node<E> rear;

    public void addFirst(E data) {
        // Create a new node
        Node<E> newNode = new Node<>(data);
        newNode.next = front;

        // If front is not null, set the previous node of the front node to the new node
        if (front != null) front.previous = newNode;
        front = newNode;

        // If rear is null, set rear to front
        if (rear == null) rear = front;
    }

    public E addLast(E data) {
        // same logic as addFirst but in the opposite direction
        Node<E> newNode = new Node<>(data);
        newNode.previous = rear;

        if (rear != null) rear.next = newNode;
        rear = newNode;

        if (front == null) front = rear;

        return data;
    }

    // TODO: redundant return value
    public E removeFirst() {
        // if we have the front node, we can remove it
        if (front == null) throw new NoSuchElementException("Deque is empty");

        // free up the front node for removal
        E data = front.data;
        front = front.next;

        if (front != null) front.previous = null;
        else rear = null;

        return data;
    }

    public E removeLast() {
        if (rear == null) throw new NoSuchElementException("Deque is empty");

        // same logic as removeFirst but in the opposite direction
        E data = rear.data;
        rear = rear.previous;

        if (rear != null) rear.next = null;
        else front = null;

        return data;
    }

    public E peekFirst() {
        if (front == null) throw new NoSuchElementException("Deque is empty");

        return front.data;
    }

    public E peekLast() {
        if (rear == null) throw new NoSuchElementException("Deque is empty");

        return rear.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
