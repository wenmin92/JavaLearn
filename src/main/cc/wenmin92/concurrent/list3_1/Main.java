package cc.wenmin92.concurrent.list3_1;

import javax.naming.directory.SearchControls;

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread("Alice", requestQueue).start();
        new ServerThread("Bobby", requestQueue).start();
    }
}
