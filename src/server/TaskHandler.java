package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TaskHandler implements HttpHandler {
    private static final Gson gson = new GsonBuilder().create();
    private static final Map<Integer, List<Task>> tasksByLevel = TaskStorage.tasksByLevel;
    public static final Map<String, List<Integer>> taskSolutions = new HashMap<>();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        int level = Integer.parseInt(Optional.ofNullable(exchange.getRequestURI().getQuery())
                .orElse("level=1").replace("level=", ""));

        List<Task> levelTasks = tasksByLevel.getOrDefault(level, List.of());
        if (levelTasks.isEmpty()) {
            exchange.sendResponseHeaders(404, -1);
            return;
        }

        Task selectedTask = levelTasks.get(new Random().nextInt(levelTasks.size()));
        String taskId = "L" + level + "T" + selectedTask.id;
        taskSolutions.put(taskId, selectedTask.blocks.stream().map(b -> b.id).collect(Collectors.toList()));

        Map<String, Object> response = new HashMap<>();
        response.put("taskId", taskId);
        response.put("blocks", shuffleBlocks(selectedTask.blocks));

        String json = gson.toJson(response);
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, json.length());
        exchange.getResponseBody().write(json.getBytes());
        exchange.getResponseBody().close();
    }

    private List<CodeBlock> shuffleBlocks(List<CodeBlock> blocks) {
        List<CodeBlock> shuffled = new ArrayList<>(blocks);
        Collections.shuffle(shuffled);
        return shuffled;
    }
}
