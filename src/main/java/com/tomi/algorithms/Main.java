package com.tomi.algorithms;

import java.util.*;
import java.io.FileWriter;
import com.google.gson.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Graph> graphs = JsonHandler.readGraphs("src/main/resources/input.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonArray output = new JsonArray();

        for (int i = 0; i < graphs.size(); i++) {
            Graph g = graphs.get(i);
            System.out.println("Graph " + (i + 1));

            List<Edge> prim = PrimAlgorithm.findMST(g);
            List<Edge> kruskal = KruskalAlgorithm.findMST(g);

            System.out.println("Prim:");
            prim.forEach(e -> System.out.println(e.from + " - " + e.to + " (" + e.weight + ")"));
            System.out.println("Kruskal:");
            kruskal.forEach(e -> System.out.println(e.from + " - " + e.to + " (" + e.weight + ")"));


            JsonObject graphResult = new JsonObject();
            graphResult.addProperty("graph_id", i + 1);
            graphResult.add("Prim", edgesToJson(prim));
            graphResult.add("Kruskal", edgesToJson(kruskal));
            output.add(graphResult);
        }

        try (FileWriter writer = new FileWriter("output.json")) {
            gson.toJson(output, writer);
        }
    }

    private static JsonArray edgesToJson(List<Edge> edges) {
        JsonArray arr = new JsonArray();
        for (Edge e : edges) {
            JsonObject obj = new JsonObject();
            obj.addProperty("from", e.from);
            obj.addProperty("to", e.to);
            obj.addProperty("weight", e.weight);
            arr.add(obj);
        }
        return arr;
    }
}
