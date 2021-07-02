package main.java.task2;

/**
 * DigitSumCalculator
 * Utility class for calculating digits sum recursively until the sum is less than 10
 *
 * @author Maksym V
 */
public class DigitSumCalculator {

    /**
     * Method that transforms number into it's absolute value and passes it to the sumFinder method
     *
     * @param number that will be transformed into the absolute value and passed to the sumFinder method
     * @return int result of the sumFinder method
     */
    public int digitSum(int number) {
        return sumFinder(Math.abs(number));
    }

    /**
     * Method that sums digits in number recursively until the sum is less than 10
     *
     * @param number to sum digits at
     * @return sum in range [0;9]
     */
    private int sumFinder(int number) {
        int sum = 0;

        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum < 10 ? sum : sumFinder(sum);
    }
}
