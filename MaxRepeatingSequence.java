/*
    Technical task: In an integer array, enter  “N” times random positive numbers
    and display which number has the most repeating consecutive values,
    how many times does it repeat and from which integer initiates the repetition of values.

    [1,2,2,2,3,3,3,4,5,6,6]
*/

import java.util.Arrays;
import java.util.Random;

public class MaxRepeatingSequence {
    private static int[] generateRandomNumbers(int len, int max) {
        int[] numbers = new int[len];
        for (int i = 0; i < len; i++)
            numbers[i] = new Random().nextInt(max);

        return numbers;
    }

    static Result maxRepeatingSequence(int[] numbers) {
        int len = numbers.length;
        int maxCount = 0;
        int currentCount = 1;
        int startIndex = 0;

        for (int i = 0; i < len; i++) {
            if (i < len - 1 && numbers[i] == numbers[i + 1]) {
                currentCount++;
                continue;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                startIndex = i + 1 - maxCount;
            }

            currentCount = 1;
        }

        return new Result(numbers[startIndex], maxCount, startIndex);
    }

    public static void main(String[] args) {
        int[] numbers = generateRandomNumbers(10, 5);
        System.out.println(Arrays.toString(numbers));

        Result result = maxRepeatingSequence(numbers);
        System.out.printf("Number: %s, Index: %s, Count: %s%n",
                result.number,
                result.startIndex,
                result.maxCount);
    }

    static class Result {
        public final int number;
        public final int maxCount;
        public final int startIndex;

        Result(int number, int maxCount, int startIndex) {
            this.number = number;
            this.maxCount = maxCount;
            this.startIndex = startIndex;
        }
    }
}
