package cc.wenmin92.net;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class InetAddressTest {
    public static void main(String[] args) {
        getByName();

        getLocal();

        // ping(10, "http://bj3.unicomtest.com:80/speedtest/upload.php");
        // isReachable(10, "bj3.unicomtest.com");

        // getHostTest();
    }

    private static void getHostTest() {
        String[] urls = new String[]{"http://speedtest1.online.tj.cn:80/speedtest/upload.php"};
        for (String url : urls) {
            System.out.println(getHost(url));
        }
    }

    private static void ping(int times, String url) {
        long totalStart = System.currentTimeMillis();
        try {
            url += url.contains("?") ? "&" : "?";
            int totalTime = 0;
            int realTimes = 0;
            int failTimes = 0;
            System.out.println(String.format("%-8s%-8s", "num", "time"));
            for (int i = 0; i < times; i++) {
                realTimes++;
                long start = System.currentTimeMillis();

                URLConnection connection = new URL(url + i).openConnection();
                connection.setConnectTimeout(1000);
                connection.connect();

                long time = System.currentTimeMillis() - start;
                if (time > 200) failTimes++;
                System.out.println(String.format("%3d%4s%4d", i + 1, " ", time));
                if (i > 0) totalTime += time;
                if (failTimes >= 2) break;
            }
            System.out.println("average: " + totalTime / (realTimes - 1));
            System.out.println("----------------------\n");
        } catch (IOException ignored) {
            System.out.println("not connected");
        }
        System.out.println("total time: " + (System.currentTimeMillis() - totalStart));
    }

    private static void isReachable(int times, String hostName) {
        InetAddress address;
        long totalStart = System.currentTimeMillis();
        try {
            address = InetAddress.getByName(hostName);
        } catch (UnknownHostException e) {
            System.out.println(hostName + " could not be determined.");
            System.out.println("total time: " + (System.currentTimeMillis() - totalStart));
            System.out.println("----------------------\n");
            return;
        }
        System.out.println(address == null ? hostName : address);

        int totalTime = 0;
        int realTimes = 0;
        int failTimes = 0;
        System.out.println(String.format("%-8s%-8s%-8s", "num", "time", "reachable"));
        if (address != null) {
            for (int i = 0; i < times; i++) {
                long start = 0;
                boolean reachable = false;
                realTimes++;
                try {
                    start = System.currentTimeMillis();

                    reachable = address.isReachable(1000);

                } catch (IOException ignored) { }
                long time = System.currentTimeMillis() - start;
                if (time > 200) failTimes++;
                System.out.println(String.format("%3d%4s%4d%4s%9s", i + 1, " ", time, " ", reachable));
                totalTime += time;
                if (failTimes >= 3) break;
            }
        }
        System.out.println("average: " + totalTime / realTimes);
        System.out.println("----------------------\n");
    }

    private static void getLocal() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("getLocalHost: " + localHost);

            // 回送地址
            InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
            System.out.println("getLoopbackAddress: " + loopbackAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------\n");
    }

    private static void getByName() {
        try {
            // getByName
            InetAddress address0 = InetAddress.getByName("www.wenmin92.cc");
            System.out.println("getByName: " + address0);

            // getByName: 传入ip
            InetAddress address1 = InetAddress.getByName("60.205.20.86");
            System.out.println("getByName: " + address1);
            System.out.println("getByName: " + address1.getHostName());

            // getByName: 传入null
            InetAddress address2 = InetAddress.getByName(null);
            System.out.println("getByName: " + address2);

            // getAllByName
            InetAddress[] addresses = InetAddress.getAllByName("baidu.com");
            System.out.println("getAllByName: " + Arrays.toString(addresses));

            // 不与DNS交互
            System.out.println("getByAddress: " + InetAddress.getByName("43.23.12.11"));
            System.out.println("getByAddress: " + InetAddress.getByAddress("com", new byte[]{43, 23, 12, 11}));
            System.out.println("getByAddress: " + InetAddress.getByAddress(new byte[]{43, 23, 12, 11}));
        } catch (UnknownHostException e) {
            System.out.println("Can't find \"www.wenmin92.cc\"");
            e.printStackTrace();
        }
        System.out.println("----------------------\n");
    }

    public static String getHost(String url) {
        int start = url.indexOf("://") + 3;
        int end = url.indexOf(":80");
        end = end != -1 ? end : url.indexOf("/speed");
        return url.substring(start, end);
    }
}
