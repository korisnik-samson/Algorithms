
import lib.BinaryTreePrinter;
import lists.DequeList;
import lists.DoubleLinkedList;
import lists.Lists;
import lists.QueueList;
import sorting.BubbleSort;
import sorting.InsertSort;
import sorting.MergeSort;
import sorting.QuickSort;
import trees.BinaryTree;

public class Main {

    public static int randomInt() {
        return (int) (Math.random() * 100);
    }

    public static void breakLine() {
        System.out.println("\n");
    }

    public static void implementBubbleSort() {
        Lists<Integer> list = new DoubleLinkedList<>();

        for (int i = 0; i < 10; i++)
            list.insert(randomInt());

        System.out.println("Before sorting:");
        list.show();

        BubbleSort.bubbleSort(list.getHead());

        System.out.println("After sorting:");
        list.show();
    }

    public static void implementInsertSort() {
        Lists<Integer> list = new DoubleLinkedList<>();

        for (int i = 0; i < 10; i++)
            list.insert(randomInt());

        System.out.println("Before sorting:");
        list.show();

        InsertSort.insertSort(list.getHead());

        System.out.println("After sorting:");
        list.show();
    }

    public static void implementMergeSort() {
        Lists<Integer> list = new DoubleLinkedList<>();

        for (int i = 0; i < 10; i++)
            list.insert(randomInt());

        System.out.println("Before sorting:");
        list.show();

        MergeSort.mergeSort(list.getHead());

        System.out.println("After sorting:");
        list.show();
    }

    public static void implementQuickSort() {
        Lists<Integer> list = new DoubleLinkedList<>();

        for (int i = 0; i < 10; i++) list.insert(randomInt());

        System.out.println("Before sorting:");
        list.show();

        QuickSort.quickSort(list.getHead());

        System.out.println("After sorting:");
        list.show();
    }

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>(2);
        BinaryTreePrinter printer = new BinaryTreePrinter();
        
        // Constructing a binary tree
        for (int i = 0; i < 10; i++) tree.add(randomInt());
        
        printer.print(tree.getRoot());

        Lists<Integer> largestValues = tree.getLargestValues();
        System.out.println("\n\nLargest values at each level: ");
        largestValues.show();
    }

}
