package cc.wenmin92.file;

import java.io.*;

public class TestFile {
    public static void main(String[] args) {
        // outputTest();
        // inputTest();
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("int.dat"))) {
            dataOutputStream.writeUTF("中过");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inputTest() {
        try {
            FileInputStream inputStream = new FileInputStream("input.txt");
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            String data = new String(bytes, 0, read, "utf-8");
            System.out.println(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void outputTest() {
        try {
            FileOutputStream outputStream = new FileOutputStream("input.txt");

            final byte cache[] = new byte[-(-128) + 127 + 1];
            for (int i = 0; i < cache.length; i++)
                cache[i] = (byte) (i - 128);
            outputStream.write(cache);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
