package lists;

import lib.Node;

import java.util.NoSuchElementException;

public class QueueList<E extends Comparable<E>> {

    private Node<E> front;
    private Node<E> rear;

    public void enqueue(E data) {
        Node<E> newNode = new Node<>(data);

        // assign the next node to the front node if it exists
        if (rear != null) rear.next = newNode;
        rear = newNode;

        // if the front node is null, set the front node to the rear node
        if (front == null) front = rear;
    }

    public E dequeue() {
        if (front == null) throw new NoSuchElementException("Queue is empty");

        E data = front.data;
        front = front.next;

        if (front == null) rear = null;

        return data;
    }

    public Node<E> poll() {
        if (front == null) throw new NoSuchElementException("Queue is empty");

        Node<E> data = front;
        front = front.next;

        if (front == null) rear = null;

        return data;
    }

    public E peek() {
        if (front == null) throw new NoSuchElementException("Queue is empty");

        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
    
    public int size() {
        int size = 0;
        Node<E> current = front;

        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

    public void showQueue() {
        Node<E> current = front;

        while (current != null) {
            System.out.println("\t " + current.data );

            System.out.println("|----------|");
            current = current.next;
        }
        
        System.out.println();
    }
}
