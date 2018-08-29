package cc.wenmin92.temp;

public class Temp {
    public static void main(String[] args) {
        Integer[] x = {0, 2, 5, 10, 25, 50, 75, 150, 300};
        printNum(x);
        Float[] y = new Float[x.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = getDegreeAtSpeed2(x[i]);
        }
        printNum(y);
    }

    private static void printNum(Number[] numbers) {
        for (Number number : numbers) {
            if (number instanceof Integer)
                System.out.printf("%8d", number.intValue());
            else System.out.printf("%8.2f", number.floatValue());
        }
        System.out.println();
    }

    private static float getDegreeAtSpeed(float speed) {
        // 0f, 2f, 5f, 10f, 25f, 50f, 75f, 150f, 300f
        double pA = 438.100728787226;
        double pB = -0.567944361500911;
        double pC = 73.9424378059858;
        double pD = -4.32888059893142;
        return (float) (32150560 + (-0.4358091 - 32150560) / Math.pow(1 + Math.pow(speed / 2.057455, 1.01138), 0.000001860914));
    }

    private static float getDegreeAtSpeed2(float speed) {
        // 0f, 2f, 5f, 10f, 25f, 50f, 75f, 150f, 300f
        float degreeInit = 0;
        if (speed <= 25) {
            degreeInit = (float) (158.2735f + (0.01010689f - 158.2735f) / Math.pow(1 + Math.pow(speed / 61586270, 0.9470664), 3337153));
        } else if (speed <= 75) {
            degreeInit = 112.5f + 1.5f * speed;
        } else if (speed <= 300) {
            degreeInit = (float) (175 + 0.75f * speed - 0.001111111f * Math.pow(speed, 2));
        }
        return degreeInit;
    }
}
