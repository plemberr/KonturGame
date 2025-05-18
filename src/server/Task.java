package server;

import java.util.List;

public class Task {
    public int id;
    public List<CodeBlock> blocks;

    public Task(int id, List<CodeBlock> blocks) {
        this.id = id;
        this.blocks = blocks;
    }
}
