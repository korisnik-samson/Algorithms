import com.sun.scenario.effect.Merge;
import lists.DoubleLinkedList;
import lists.Lists;
import sorting.BubbleSort;
import sorting.InsertSort;
import sorting.MergeSort;
import sorting.QuickSort;

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

        for (int i = 0; i < 10; i++)
            list.insert(randomInt());

        System.out.println("Before sorting:");
        list.show();

        QuickSort.quickSort(list.getHead());

        System.out.println("After sorting:");
        list.show();
    }

    public static void main(String[] args) {

        // Implement the quick sort algorithm...
        implementQuickSort();
        breakLine();

    }

}
