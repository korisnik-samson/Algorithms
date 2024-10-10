package sorting;

import lib.Node;

public class SelectionSort {

    public static <E extends Comparable<E>> void selectionSort(Node<E> head) {
        // head checks
        if (head == null || head.next == null) return;

        Node<E> current = head;

        while (current != null) {
            Node<E> min = current;
            Node<E> temp = current.next;

            while (temp != null) {
                if (temp.compareTo(min) < 0) min = temp;
                temp = temp.next;
            }

            E tempData = current.data;
            current.data = min.data;
            min.data = tempData;

            current = current.next;
        }
    }

}
