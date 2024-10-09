package lists;

import lib.Node;

public class DoubleLinkedList<E extends Comparable<E>> implements Lists<E> {

    Node<E> head;
    Node<E> tail;
    int size;

    @Override
    public boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getLength() {
        return size;
    }

    @Override
    // get method to retrieve the data at a specific index
    public E get(int index) {
        if (!isValidIndex(index))
            throw new IndexOutOfBoundsException("Invalid index");

        if (index >= getLength())
            throw new IndexOutOfBoundsException("Index out of bounds");

        if (index == 0) return head.data;

        Node<E> current = head;
        int counter = 0;

        // traverse the list until the index is reached
        while (counter < index && current.next != null) {
            counter++;
            current = current.next;
        }

        return current.data;
    }

    @Override
    // get method using the data itself
    public E get(E data) {
        Node<E> current = head;

        // traverse the list until the data is found
        for (int i = 0; i < getLength(); i++) {
            if (current.data.equals(data))
                return current.data;

            current = current.next;
        }

        return null;
    }

    @Override
    public Node<E> getNode(int index) {
        if (!isValidIndex(index))
            throw new IndexOutOfBoundsException("Invalid index");

        if (index >= getLength())
            throw new IndexOutOfBoundsException("Index out of bounds");

        if (index == 0) return head;

        Node<E> current = head;
        int counter = 0;

        // traverse the list until the index is reached
        while (counter < index && current.next != null) {
            counter++;
            current = current.next;
        }

        return current;
    }

    @Override
    public Node<E> getHead() {
        return head;
    }

    @Override
    public void insert(E data) {
        insertEnd(data);
    }

    @Override
    public void show() {
        Node<E> node = head;

        System.out.print("{ ");

        while (node != null) {
            System.out.print(node.data + " }<-->{ ");
            node = node.next;
        }

        System.out.println("null }");
    }

    @Override
    public void showReverse() {
        Node<E> node = tail;

        System.out.print("{ ");

        while (node != null) {
            System.out.print(node.data + " }<-->{ ");
            node = node.previous;
        }

        System.out.println("null }");
    }

    @Override
    public void insertEnd(E data) {
        Node<E> node = new Node<>(data);

        if (isEmpty()) head = node;
        else tail.next = node;

        node.previous = tail;
        tail = node;

        size++;
    }

    @Override
    public void insertStart(E data) {
        Node<E> node = new Node<>(data);

        if (isEmpty()) tail = node;
        else head.previous = node;

        node.next = head;
        head = node;

        size++;
    }

    @Override
    public void deleteEnd() {
        if (isEmpty()) throw new IndexOutOfBoundsException("List is empty");

        Node<E> node = tail;

        if (head == tail) head = null;
        else tail.previous.next = null;

        tail = tail.previous;
        node.previous = null;

        size--;
    }

    @Override
    public void deleteStart() {
        if (isEmpty()) throw new IndexOutOfBoundsException("List is empty");

        Node<E> node = head;

        if (head == tail) tail = null;
        else head.next.previous = null;

        head = head.next;
        node.next = null;

        size--;
    }

    @Override
    public void insertAt(int index, E data) {
        if (!isValidIndex(index))
            throw new IndexOutOfBoundsException("Invalid index");

        if (index == 0) insertStart(data);

        if (index == getLength()) insertEnd(data);


        Node<E> current = head;
        Node<E> node = new Node<>(data);

        int counter = 0;

        while (counter < index && current.next != null) {
            counter++;
            current = current.next;
        }

        node.next = current;
        node.previous = current.previous;
        current.previous.next = node;
        current.previous = node;

        size++;
    }

    @Override
    public void removeAt(int index) {
        if (!isValidIndex(index))
            throw new IndexOutOfBoundsException("Invalid index");

        if (index == 0) {
            Node<E> node = head;
            deleteStart();
        }

        if (index == getLength() - 1) {
            Node<E> node = tail;
            deleteEnd();
        }

        Node<E> current = head;
        int counter = 0;

        while (counter < index && current.next != null) {
            counter++;
            current = current.next;
        }

        current.previous.next = current.next;
        assert current.next != null;
        current.next.previous = current.previous;

        current.next = null;
        current.previous = null;

        size--;
    }

    @Override
    public void remove(E data) {

    }

    /*    public void swapNode(int index1, int index2) {
            if (!isValidIndex(index1) || !isValidIndex(index2))
                throw new IndexOutOfBoundsException("Invalid index");

            if (index1 == index2) return;

            Node<E> node1 = getNode(index1);
            Node<E> node2 = getNode(index2);

            E temp = node1.data;
            node1.data = node2.data;
            node2.data = temp;
        }

        public void swapData(int index1, int index2) {
            if (!isValidIndex(index1) || !isValidIndex(index2))
                throw new IndexOutOfBoundsException("Invalid index");

            if (index1 == index2) return;

            Node<E> node1 = getNode(index1);
            Node<E> node2 = getNode(index2);

            swapOperation(node1, node2);
        }*/

    private void swapOperation(Node<E> nodeA, Node<E> nodeB) {
        Node <E> tempNode;

        tempNode = nodeA;
        nodeA = nodeB;
        nodeB = tempNode;
    }

    public void clear() {

    }
}
