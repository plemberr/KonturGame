package server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        // Получаем порт из переменной окружения PORT, если её нет — используем 8080
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));

        // Создаём сервер, слушающий на всех интерфейсах на нужном порту
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", new StaticFileHandler());
        server.createContext("/get-task", new TaskHandler());
        server.createContext("/check", new CheckHandler());
        server.setExecutor(null);
        server.start();

        System.out.println("Server started at http://localhost:" + port);
    }
}
