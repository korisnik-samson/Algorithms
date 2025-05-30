package sorting;

import lib.Node;

public class BubbleSort {

    public static <E extends Comparable<E>> void bubbleSort(Node<E> head) {
        // checks
        if (head == null || head.next == null) return;

        boolean isSwapped;

        // could be redundant
        Node<E> current;
        Node<E> last = null;

        // could also use a nested for loop... but due to explicitness, we use a do-while loop
        do {
            isSwapped = false;
            
            // latch on to the head(current node)
            current = head;

            // iterate while comparing from the current node to the last node
            while (current.next != last)  {
                
                if (current.compareTo(current.next) > 0) {
                    // preform swapping
                    E temp = current.data;
                    
                    current.data = current.next.data;
                    current.next.data = temp;

                    isSwapped = true;
                }

                current = current.next;
            }

            last = current;

        } while (isSwapped);
    }

}
