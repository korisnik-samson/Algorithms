package lists;

import lib.Node;

public interface Lists<E extends Comparable<E>> {

    // get method to retrieve the data at a specific index
    public boolean isValidIndex(int index);

    // method to check if the list is empty
    public boolean isEmpty();

    // method to get the length of the list
    public int getLength();

    // get method to retrieve the data at a specific index
    public E get(int index);

    // get method using the data itself
    public E getItem(E data);

    // method to get the node at a specific index
    public Node<E> getNode(int index);

    // method to get the head of the list
    public Node<E> getHead();

    // method to add a new node to the list (Append)
    public void insert(E data);

    // method to add a new node to the list at a specific index
    public void insertAt(int index, E data);

    // method to remove a node from the list at a specific index
    public void removeAt(int index);

    // method to remove a node from the list using the data itself
    public void remove(E data);

    // method to clear the list
    public void clear();

    // method to print the list
    public void show();

    // method to print the list in reverse
    public void showReverse();

    // append data to the end of the list
    public void insertEnd(E data);

    // insert data at the beginning of the list
    public void insertStart(E data);

    public void deleteEnd();

    public void deleteStart();
}
