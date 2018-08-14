package kyu7;

/**
 * https://www.codewars.com/kata/growth-of-a-population/train/java
 * <p>
 * At the end of the first year there will be:
 * 1000 + 1000 * 0.02 + 50 => 1070 inhabitants
 * <p>
 * At the end of the 2nd year there will be:
 * 1070 + 1070 * 0.02 + 50 => 1141 inhabitants (number of inhabitants is an integer)
 * <p>
 * At the end of the 3rd year there will be:
 * 1141 + 1141 * 0.02 + 50 => 1213
 * <p>
 * It will need 3 entire years.
 * <p>
 * <p>
 * Examples:
 * nb_year(1500, 5, 100, 5000) -> 15
 * nb_year(1500000, 2.5, 10000, 2000000) -> 10
 */
public class GrowthOfAPopulation {
    public static void main(String[] args) {
        System.out.println(nbYear(1500, 5, 100, 5000));
    }

    /**
     * @param p0      beginning
     * @param percent increases
     * @param aug     inhabitants coming or leaving each year
     * @param p       population to surpass
     * @return How many years
     */
    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        for (; p0 < p; years++)
            p0 = (int) (p0 + p0 * percent / 100 + aug);
        return years;
    }
}
