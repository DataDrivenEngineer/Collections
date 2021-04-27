package dbelousov.petprojects.algorithms.graph;

import dbelousov.petprojects.collections.graph.Graph;
import dbelousov.petprojects.collections.graph.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphUtils {

    public static <T> Graph<T> makeGraph(T[] vertices, T[][] adjacencyListArray) {
        var listOfVertices = new ArrayList<Vertex<T>>();
        for (var v : vertices) {
            var vertex = new Vertex<>(v);
            listOfVertices.add(vertex);
        }

        var adjacencyList = new ArrayList<LinkedList<Vertex<T>>>();
        for (var adjacencyListItem : adjacencyListArray) {
            var linkedListOfEdges = new LinkedList<Vertex<T>>();
            for (var targetVertex : adjacencyListItem) {
                var v = new Vertex<>(targetVertex);
                var vertexFromListOfVertices = listOfVertices.get(listOfVertices.indexOf(v));
                linkedListOfEdges.add(vertexFromListOfVertices);
            }
            adjacencyList.add(linkedListOfEdges);
        }

        return new Graph<>(listOfVertices, adjacencyList);
    }
}
