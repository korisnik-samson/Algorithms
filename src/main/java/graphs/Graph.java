package graphs;

import lib.Node;

import java.util.*;

public class Graph<E extends Comparable<E>> {
    private final Map<Node<E>, List<Node<E>>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(E data) {
        adjacencyList.putIfAbsent(new Node<>(data), new ArrayList<>());
    }

    public void addEdge(E source, E destination) {
        Node<E> sourceNode = new Node<>(source);
        Node<E> destinationNode = new Node<>(destination);

        adjacencyList.get(sourceNode).add(destinationNode);
        adjacencyList.get(destinationNode).add(sourceNode); // usually for undirected graphs
    }

    public void breadthFirstTraversal(E start) {
        Node<E> startNode = new Node<>(start);
        Set<Node<E>> visited = new HashSet<>();

        // this could be our own implementation of a queue
        // TODO: have the QueueList implement Lists
        Queue<Node<E>> queue = new LinkedList<>();

        visited.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.poll();
            System.out.println(currentNode.data + " ");

            for (Node<E> neighbour : adjacencyList.get(currentNode)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    public void depthFirstTraversal(E start) {
        Node<E> startNode = new Node<>(start);
        Set<Node<E>> visited = new HashSet<>();

        // this could be our own implementation of a stack
        Stack<Node<E>> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            Node<E> currentNode = stack.pop();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                System.out.println(currentNode.data + " ");
            }

            for (Node<E> neighbour : adjacencyList.get(currentNode)) {

                if (!visited.contains(neighbour)) stack.push(neighbour);

            }
        }
    }
}
