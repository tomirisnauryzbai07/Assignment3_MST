package com.tomi.algorithms;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class JsonHandler {

    public static List<Graph> readGraphs(String filePath) throws IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader(filePath);

        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        reader.close();

        List<Graph> graphs = new ArrayList<>();
        JsonArray graphArray = jsonObject.getAsJsonArray("graphs");

        for (JsonElement element : graphArray) {
            JsonObject g = element.getAsJsonObject();
            List<String> nodes = new ArrayList<>();
            g.getAsJsonArray("nodes").forEach(n -> nodes.add(n.getAsString()));

            List<Edge> edges = new ArrayList<>();
            g.getAsJsonArray("edges").forEach(e -> {
                JsonObject o = e.getAsJsonObject();
                edges.add(new Edge(
                        o.get("from").getAsString(),
                        o.get("to").getAsString(),
                        o.get("weight").getAsInt()
                ));
            });

            graphs.add(new Graph(nodes, edges));
        }

        return graphs;
    }
}
