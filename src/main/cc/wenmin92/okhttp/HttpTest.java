package cc.wenmin92.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpTest {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://postman-echo.com/status/200").build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        response.close();
    }
}
