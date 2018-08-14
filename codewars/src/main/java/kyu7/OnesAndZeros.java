package kyu7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.codewars.com/kata/ones-and-zeros/train/java
 * <p>
 * Given an array of one's and zero's convert the equivalent binary value to an integer.
 * <p>
 * Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
 * <p>
 * Examples:
 * Testing: [0, 0, 0, 1] ==> 1
 * Testing: [0, 0, 1, 0] ==> 2
 * Testing: [0, 1, 0, 1] ==> 5
 * Testing: [1, 0, 0, 1] ==> 9
 * Testing: [0, 0, 1, 0] ==> 2
 * Testing: [0, 1, 1, 0] ==> 6
 * Testing: [1, 1, 1, 1] ==> 15
 * Testing: [1, 0, 1, 1] ==> 11
 * However, the arrays can have varying lengths, not just limited to 4.
 */
public class OnesAndZeros {
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        StringBuilder numS = new StringBuilder();
        for (int num : binary)
            numS.append(num);
        return Integer.parseInt(numS.toString(), 2);
    }

    public static void main(String[] args) {
        int i = OnesAndZeros.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0, 0, 0, 1)));
        System.out.println(1 << 0);
    }
}
