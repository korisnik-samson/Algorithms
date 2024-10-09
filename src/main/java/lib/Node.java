package lib;

import org.jetbrains.annotations.NotNull;

public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
    public E data;
    public Node<E> previous;
    public Node<E> next;

    public Node (E data) {
        this.data = data;
    }

    @Override
    public int compareTo(@NotNull Node<E> o) {
        return this.data.compareTo(o.data);
    }
}
