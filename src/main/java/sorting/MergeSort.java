package sorting;

import lib.Node;

public class MergeSort {

    public static <E extends Comparable<E>> Node<E> mergeSort(Node<E> head) {
        if (head == null || head.next == null) return head;

        // Split the list into two halves
        Node<E> middle = getMiddle(head);
        Node<E> nextOfMiddle = middle.next;
        middle.next = null;

        // Recursively sort the two halves
        Node<E> left = mergeSort(head);
        Node<E> right = mergeSort(nextOfMiddle);

        // Merge the two sorted halves
        return merge(left, right);
    }

    private static <E extends Comparable<E>> Node<E> merge(Node<E> left, Node<E> right) {
        if (left == null) return right;

        if (right == null) return left;

        Node<E> result;

        if (left.compareTo(right) <= 0) {
            result = left;
            result.next = merge(left.next, right);

        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    private static <E extends Comparable<E>> Node<E> getMiddle(Node<E> head) {
        if (head == null) return null;

        Node<E> slow = head;
        Node<E> fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
