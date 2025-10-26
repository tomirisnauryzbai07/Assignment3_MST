package com.tomi.algorithms;

import java.util.*;

public class PrimAlgorithm {

    public static List<Edge> findMST(Graph graph) {
        List<Edge> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        String start = graph.nodes.get(0);
        visited.add(start);

        for (Edge e : graph.edges) {
            if (e.from.equals(start) || e.to.equals(start)) {
                pq.add(e);
            }
        }

        while (!pq.isEmpty() && result.size() < graph.nodes.size() - 1) {
            Edge edge = pq.poll();

            String next = null;
            if (visited.contains(edge.from) && !visited.contains(edge.to)) {
                next = edge.to;
            } else if (visited.contains(edge.to) && !visited.contains(edge.from)) {
                next = edge.from;
            } else {
                continue;
            }

            result.add(edge);
            visited.add(next);

            for (Edge e : graph.edges) {
                if ((e.from.equals(next) && !visited.contains(e.to)) ||
                        (e.to.equals(next) && !visited.contains(e.from))) {
                    pq.add(e);
                }
            }
        }

        return result;
    }
}
