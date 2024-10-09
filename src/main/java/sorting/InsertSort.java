package sorting;

import lib.Node;
import org.jetbrains.annotations.NotNull;

public class InsertSort {

    public static <E extends Comparable<E>> Node<E> insertSort(Node<E> head) {
        // preform null checks
        if (head == null || head.next == null) return head;

        Node<E> sortedList = null;
        Node<E> current = head;

        while (current != null) {
            Node<E> next = current.next;
            sortedList = insert(sortedList, current);

            current = next;
        }

        return sortedList;
    }

    private static <E extends Comparable<E>> @NotNull Node<E> insert(Node<E> head, Node<E> newNode) {
        // if it's the same as the head or less than the head
        if (head == null || newNode.compareTo(head) <= 0) {
            newNode.next = head;
            return newNode;
        }

        Node<E> current = head;

        // find the right position... while we have next and the next is greater than the new node
        while (current.next != null && current.next.compareTo(newNode) > 0)
            current = current.next;

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

}
