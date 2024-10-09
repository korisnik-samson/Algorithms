package sorting;

import lib.Node;

public class QuickSort {

    public static <E extends Comparable<E>> Node<E> quickSort(Node<E> head) {
        if (head == null || head.next == null) return head;

        // using the last node as pivot
        Node<E> pivot = getTail(head);

        // partition the list around the pivot
        Node<E> tail = pivot;
        Node<E> previous = null;
        Node<E> current = head;
        Node<E> end = tail;

        while (current != end) {
            if (current.compareTo(pivot) <= 0) {
                if (previous == null) head = current;
                else previous.next = current;

                previous = current;
            }

            current = current.next;
        }

        // place the pivot after the smaller elements
        if (previous == null) head = pivot;
        else previous.next = pivot;

        // recursively sort the sublists
        pivot.next = quickSort(pivot.next);
        tail.next = null; // note to disconnect the pivot from the rest of the list

        return quickSort(head);
    }

    public static <E extends Comparable<E>> Node<E> getTail(Node<E> head) {
        if (head == null) return null;

        while (head.next != null) head = head.next;

        return head;
    }

}
