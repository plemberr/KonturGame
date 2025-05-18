package server;

import com.google.gson.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CheckHandler implements HttpHandler {
    private static final Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            exchange.sendResponseHeaders(405, -1);
            return;
        }

        InputStream is = exchange.getRequestBody();
        String body = new String(is.readAllBytes());

        JsonObject json = gson.fromJson(body, JsonObject.class);
        String taskId = json.get("taskId").getAsString();
        JsonArray ids = json.get("ids").getAsJsonArray();

        List<Integer> submitted = new ArrayList<>();
        for (JsonElement el : ids) {
            submitted.add(el.getAsInt());
        }

        List<Integer> correct = TaskHandler.taskSolutions.getOrDefault(taskId, List.of());
        boolean isCorrect = correct.equals(submitted);

        String response = "{\"correct\": " + isCorrect + "}";
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.getResponseBody().close();
    }
}
