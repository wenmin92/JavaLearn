package cc.wenmin92.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GsonTest {
    public static class ClassRoom {
        public String roomName;
        public int number;

        public String toString() {
            return "[" + roomName + ":" + number + "]";
        }
    }

    public static class User {
        public String name;
        public int age;
        private ClassRoom room;

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return name + "->" + age + ":" + room;
        }
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        String strJson = "{name:'david',age:19,room:{roomName:'small',number:1}}";
        User u = gson.fromJson(strJson, new TypeToken<List<User>>(){}.getType());
        System.out.println(u);

    }
}
