package lists;

import lib.Node;

import java.util.NoSuchElementException;

public class SingleLinkedList<E extends Comparable<E>> implements Lists<E> {

    Node<E> head;
    int size;

    @Override
    public boolean isValidIndex(int index) {
        return index < 0 || index >= size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size();
    }

    private int size() {
        int nodeCount = 0;
        Node<E> current = head;

        while (current != null) {
            nodeCount++;
            current = current.next;
        }

        return nodeCount;
    }

    @Override
    public E get(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Invalid cannot be negative");

        if (index >= size) throw new IndexOutOfBoundsException("Index out of bounds");

        Node<E> current = head;

        for (int i = 0; i < index; i++) {
            if (current == null) throw new IndexOutOfBoundsException("Invalid index");
            current = current.next;
        }

        if (current == null) throw new IndexOutOfBoundsException("Invalid index");

        return current.data;
    }

    public boolean contains(E data) {
        Node<E> current = head;

        while (current != null) {
            if (current.data.equals(data)) return true;
            current = current.next;
        }

        return false;
    }

    @Override
    public E getItem(E data) {
        return null;
    }

    @Override
    public Node<E> getNode(int index) {
        return null;
    }

    @Override
    public Node<E> getHead() {
        return head;
    }

    @Override
    public void insert(E data) {

    }

    @Override
    public void insertAt(int index, E data) {
        if (index < 0) throw new IndexOutOfBoundsException("Invalid cannot be negative");

        if (index > size) throw new IndexOutOfBoundsException("Index out of bounds");

        if (index == 0) insertStart(data);

        Node<E> newNode = new Node<>(data);
        Node<E> current = head;

        for (int i = 0; i < index - 1; i++) {
            if (current == null) throw new IndexOutOfBoundsException("Invalid index");
            current = current.next;
        }

        if (current == null) throw new IndexOutOfBoundsException("Invalid index");

        newNode.next = current.next;
        current.next = newNode;

        size++;
    }

    @Override
    public void removeAt(int index) {
        if (isValidIndex(index)) throw new IndexOutOfBoundsException("Invalid cannot be negative or greater than size");

        if (index == 0) removeFirst();

        Node<E> current = head;

        for (int i = 0; i < index - 1; i++) {
            if (current == null) throw new IndexOutOfBoundsException("Invalid index");
            current = current.next;
        }

        if (current == null || current.next == null) throw new IndexOutOfBoundsException("index out of bounds");

        E data = current.next.data;
        current.next = current.next.next;

        size--;
    }

    public void removeFirst() {
        if (head == null) throw new NoSuchElementException("List is empty");
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) throw new NoSuchElementException("List is Empty");
        if (head.next == null) removeFirst();

        Node<E> current = head;

        while (current.next.next != null)
            current = current.next;

        E data = current.next.data;
        current.next = null;

        size--;
    }

    @Override
    public void remove(E data) {}

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public void show() {
        Node<E> node = head;

        System.out.print("{ ");

        while (node != null) {
            System.out.print(node.data + " }-->{ ");
            node = node.next;
        }

        System.out.println("null }");
    }

    @Override
    public void insertEnd(E data) {
        Node<E> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<E> current = head;

        while (current.next != null) current = current.next;

        current.next = newNode;
    }

    @Override
    public void insertStart(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;

        head = newNode;
    }

    @Override
    public void deleteEnd() {

    }

    @Override
    public void deleteStart() {

    }
}
