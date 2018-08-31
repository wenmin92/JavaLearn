package cc.wenmin92.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class TestFile {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new File(".").list((dir, name) -> new File(dir, name).isDirectory())));
        System.out.println(Arrays.toString(new File(".").list((dir, name) -> new File(dir, name).isFile())));
    }
}
