package server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResultStorage {
    private static final Map<String, GameResult> tokenToResult = new ConcurrentHashMap<>();

    public static String saveResult(String nick, int score) {
        String token = java.util.UUID.randomUUID().toString();
        tokenToResult.put(token, new GameResult(nick, score, System.currentTimeMillis()));
        return token;
    }

    public static GameResult getResultByToken(String token) {
        return tokenToResult.get(token);
    }
}

class GameResult {
    public final String nick;
    public final int score;
    public final long timestamp;

    public GameResult(String nick, int score, long timestamp) {
        this.nick = nick;
        this.score = score;
        this.timestamp = timestamp;
    }
}
