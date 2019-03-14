package cc.wenmin92.concurrent.list4_1;

import java.io.FileWriter;
import java.io.IOException;

public class Data {
    private final String filename;
    private boolean changed;
    private String content;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    synchronized void save() throws IOException {
        if (!changed) {
            System.out.println(Thread.currentThread().getName() + " balked, content = " + content);
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
