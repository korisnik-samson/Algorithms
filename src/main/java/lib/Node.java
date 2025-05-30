package lib;

import org.jetbrains.annotations.NotNull;

public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
    public E data;
    public Node<E> previous;
    public Node<E> next;
    
    private int displayWidth; // Width for displaying this node's value, after padding/centering

    public Node (E data) {
        this.data = data;
    }
    
    public int getDisplayWidth() { return displayWidth; }
    
    public void setDisplayWidth(int displayWidth) { this.displayWidth = displayWidth; }

    @Override
    public int compareTo(@NotNull Node<E> o) {
        return this.data.compareTo(o.data);
    }
}
