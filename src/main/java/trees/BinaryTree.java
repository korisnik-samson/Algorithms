package trees;

import lib.Node;
import lists.DoubleLinkedList;
import lists.Lists;
import lists.QueueList;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Queue;

public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;

    public BinaryTree(E data) {
        root = addRecursive(root, data);
    }

    public Node<E> getRoot() {
        return root;
    }

    @Contract(value = "null, _ -> new", pure = true)
    private @NotNull Node<E> addRecursive(Node<E> current, E data) {
        if (current == null) return new Node<>(data);

        if (data.compareTo(current.data) < 0)
            current.previous = addRecursive(current.previous, data);

        else if (data.compareTo(current.data) > 0)
            current.next = addRecursive(current.next, data);

        // knowing that the data is already in the tree
        else return current;

        return current;
    }
    
    public void add(E data) {
        root = addRecursive(root, data);
    }

    public boolean containsNode(E data) {
        return containsNodeRecursive(root, data);
    }

    private boolean containsNodeRecursive(Node<E> current, E data) {
        // recursively search for the data
        if (current == null) return false;

        if (data.compareTo(current.data) == 0) return true;

        return data.compareTo(current.data) < 0
                ? containsNodeRecursive(current.previous, data)
                : containsNodeRecursive(current.next, data);
    }

    public void delete(E data) {
        root = deleteRecursive(root, data);
    }

    private Node<E> deleteRecursive(Node<E> current, E data) {
        if (current == null) return null;

        // adding a fail-safe to avoid null pointer exceptions
        if (data.equals(current.data) || data.compareTo(current.data) == 0) {

            // case 1: no children
            if (current.previous == null && current.next == null) return null;

            // case 2: only one child
            if (current.next == null) return current.previous;
            if (current.previous == null) return current.next;

            // case 3: two children
            E smallestValue = findSmallestValue(current.next);
            current.data = smallestValue;
            current.next = deleteRecursive(current.next, smallestValue);

            return current;
        }

        if (data.compareTo(current.data) < 0) {
            current.previous = deleteRecursive(current.previous, data);
            return current;
        }

        current.next = deleteRecursive(current.next, data);
        return current;
    }

    @Contract(pure = true)
    private E findSmallestValue(@NotNull Node<E> root) {
        return root.previous == null ? root.data : findSmallestValue(root.previous);
    }

    // order traversals

    public void traverseInOrder(Node<E> node) {
        if (node != null) {
            traverseInOrder(node.previous);
            System.out.print(" " + node.data);

            traverseInOrder(node.next);
        }
    }

    public void traversePreOrder(Node<E> node) {
        if (node != null) {
            System.out.print(" " + node.data);
            traversePreOrder(node.previous);

            traversePreOrder(node.next);
        }
    }

    public void traversePostOrder(Node<E> node) {
        if (node != null) {
            traversePostOrder(node.previous);
            traversePostOrder(node.next);

            System.out.print(" " + node.data);
        }
    }

    // Implemeting level order traversal to find the largest values at each level
    public Lists<E> getLargestValues() {
        return largetValues(root);
    }
    
    private Lists<E> largetValues(Node<E> root) {
        if (root == null) return new DoubleLinkedList<>();
        
        Lists<E> list = new DoubleLinkedList<>();
        QueueList<Node<E>> queueList = new QueueList<>();
        
        queueList.enqueue(root);
        
        while (!queueList.isEmpty()) {
            int size = queueList.size();
            E max = null;
            
            for (int i = 0; i < size; i++) {
                Node<E> current = queueList.dequeue();
                // Node<E> current = queueList.poll();
                max = current.data;

                // Update max if it's null or current.data is greater
                if (max == null || current.data.compareTo(max) > 0) max = current.data;

                // Add child nodes to the queue
                if (current.previous != null) queueList.enqueue(current.previous);
                if (current.next != null) queueList.enqueue(current.next);
            }
            
            list.insert(max);
        }
        
        return list;
    }
}
