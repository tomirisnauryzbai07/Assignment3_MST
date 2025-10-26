package com.tomi.algorithms;

import java.util.*;

public class KruskalAlgorithm {
    static class DisjointSet {
        private final Map<String, String> parent = new HashMap<>();

        public DisjointSet(List<String> nodes) {
            for (String node : nodes) {
                parent.put(node, node);
            }
        }
        public String find(String node) {
            if (!parent.get(node).equals(node)) {
                parent.put(node, find(parent.get(node)));
            }
            return parent.get(node);
        }

        public void union(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if (!rootA.equals(rootB)) {
                parent.put(rootA, rootB);
            }
        }
    }

    public static List<Edge> findMST(Graph graph) {
        List<Edge> result = new ArrayList<>();
        DisjointSet ds = new DisjointSet(graph.nodes);

        List<Edge> sortedEdges = new ArrayList<>(graph.edges);
        Collections.sort(sortedEdges);

        for (Edge edge : sortedEdges) {
            String rootA = ds.find(edge.from);
            String rootB = ds.find(edge.to);

            if (!rootA.equals(rootB)) {
                result.add(edge);
                ds.union(edge.from, edge.to);
            }
        }

        return result;
    }
}
