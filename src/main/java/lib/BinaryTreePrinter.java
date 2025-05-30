package lib;

import lib.Node;
import lists.*;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePrinter<E extends Comparable<E>> {
/*    static class Node {
        int value;
        Node left;
        Node right;
        String sValue; // String representation of the value
        int displayWidth; // Width for displaying this node's value, after padding/centering

        Node(int value) {
            this.value = value;
            this.sValue = Integer.toString(value);
            this.left = null;
            this.right = null;
        }

        // Fluent setters for easier tree construction in tests
        public Node left(Node child) { this.left = child; return this; }
        public Node right(Node child) { this.right = child; return this; }
        public Node left(int val) { this.left = new Node(val); return this.left; }
        public Node right(int val) { this.right = new Node(val); return this.right; }
    }*/

    /**
     * Prints the binary tree to the console.
     *
     * @param root The root node of the tree.
     */

    public void print(Node<E> root) {
        if (root == null) {
            System.out.println("(empty tree)");
            return;
        }

        // Optional: Calculate max width for node values for consistent formatting
        int maxNodeValueStrLength = getMaxNodeValueStrLength(root);

        StringBuilder sb = new StringBuilder();

        // Format and print the root node's value
        root.setDisplayWidth(maxNodeValueStrLength); // Store for consistency if needed elsewhere
        String rootDisplayValue = centerText(String.valueOf(root.data), maxNodeValueStrLength);
        sb.append(rootDisplayValue).append("\n");

        // Process children of the root
        List<E> rootChildren = new ArrayList<>();
        
        if (root.previous != null) rootChildren.add((E) root.previous);
        
        if (root.next != null) rootChildren.add((E) root.next);
        

        for (int i = 0; i < rootChildren.size(); i++) {
            Node<E> child = (Node<E>) rootChildren.get(i);
            boolean isLastChild = (i == rootChildren.size() - 1);

            // Initial line prefix for direct children of the root
            String linePrefix = isLastChild ? "└── " : "├── ";
            // Initial indent prefix for the children of these direct children
            String nextChildrenIndentPrefix = isLastChild ? "    " : "│   ";

            printRecursive(child, sb, linePrefix, nextChildrenIndentPrefix, maxNodeValueStrLength);
        }
        System.out.print(sb.toString());
    }

    /**
     * Recursive helper to build the tree string for nodes *below* the root.
     *
     * @param node                    Current node to print.
     * @param buffer                  StringBuilder to append the output.
     * @param currentLinePrefix       Prefix for the current node's line (e.g., "└── ", "├── ").
     * @param childrenIndentPrefix    Indentation prefix for the children of the current node (e.g., "    ", "│   ").
     * @param maxNodeValueStrLength   The maximum string length of any node value in the tree, for padding.
     */
    private void printRecursive(Node node, StringBuilder buffer, String currentLinePrefix, String childrenIndentPrefix, int maxNodeValueStrLength) {
        if (node == null) { // Should not happen if called correctly, but good for safety
            return;
        }

        node.setDisplayWidth(maxNodeValueStrLength); // Store for consistency
        String nodeDisplayValue = centerText(String.valueOf(node.data), maxNodeValueStrLength);

        buffer.append(currentLinePrefix);
        buffer.append(nodeDisplayValue);
        buffer.append("\n");

        // Prepare to print children of the current node
        List<Node> children = new ArrayList<>();
        if (node.previous != null) children.add(node.previous);
        
        if (node.next != null) children.add(node.next);

        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            boolean isLastGrandChild = (i == children.size() - 1); // Is this child the last among its siblings?

            // Prefix for this child's line, extending from childrenIndentPrefix
            String grandChildLinePrefix = childrenIndentPrefix + (isLastGrandChild ? "└── " : "├── ");
            // Indent prefix for the children of *this* child
            String greatGrandChildrenIndentPrefix = childrenIndentPrefix + (isLastGrandChild ? "    " : "│   ");

            printRecursive(child, buffer, grandChildLinePrefix, greatGrandChildrenIndentPrefix, maxNodeValueStrLength);
        }
    }

    /**
     * Calculates the maximum string length of any node's value in the tree.
     * This is used for formatting all node values to a consistent width.
     * @param node The current node to start from.
     * @return The maximum string length.
     */
    private int getMaxNodeValueStrLength(Node node) {
        if (node == null) {
            return 0;
        }
        int maxLength = String.valueOf(node.data).length();
        maxLength = Math.max(maxLength, getMaxNodeValueStrLength(node.previous));
        maxLength = Math.max(maxLength, getMaxNodeValueStrLength(node.next));
        return maxLength;
    }

    /**
     * Centers a given text string within a specified target length by adding padding.
     * (Copied from MatrixPrinter for convenience)
     */
    private String centerText(String text, int targetLength) {
        if (text.length() >= targetLength) {
            return text;
        }
        int totalPadding = targetLength - text.length();
        int padStart = totalPadding / 2;
        int padEnd = totalPadding - padStart;

        return repeatChar(' ', padStart) + text + repeatChar(' ', padEnd);
    }

    /**
     * Repeats a character a specified number of times.
     * (Copied from MatrixPrinter for convenience)
     */
    private String repeatChar(char ch, int count) {
        if (count < 0) count = 0;
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
