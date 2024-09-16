package algorithms.coderun.start;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOf3Numbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] smallestNums = new int[3];
        for (int i = 0; i < 3; i++) {
            smallestNums[i] = console.nextInt();
        }
        Arrays.sort(smallestNums);
        int[] biggestNums = Arrays.copyOf(smallestNums, smallestNums.length);
        boolean isZeroIncluded = false;
        while (console.hasNextInt()) {
            int n = console.nextInt();

            if (n == 0) {
                isZeroIncluded = true;
                continue;
            }

            if (n < smallestNums[0]) {
                smallestNums[2] = smallestNums[1];
                smallestNums[1] = smallestNums[0];
                smallestNums[0] = n;
            }
            else if (n < smallestNums[1]) {
                smallestNums[2] = smallestNums[1];
                smallestNums[1] = n;
            }
            else if (n < smallestNums[2]) {
                smallestNums[2] = n;
            }

            if (n > biggestNums[2]) {
                biggestNums[0] = biggestNums[1];
                biggestNums[1] = biggestNums[2];
                biggestNums[2] = n;
            }
            else if (n > biggestNums[1]) {
                biggestNums[0] = biggestNums[1];
                biggestNums[1] = n;
            }
            else if (n > biggestNums[0]) {
                biggestNums[0] = n;
            }
        }
        int[] criticalProducts = new int[2];
        criticalProducts[0] = smallestNums[0] * smallestNums[1] * biggestNums[2];
        criticalProducts[1] = biggestNums[0] * biggestNums[1] * biggestNums[2];

        if (isZeroIncluded && criticalProducts[0] < 0 && criticalProducts[1] < 0)
        {
            System.out.println(0 + " " + biggestNums[1] + " " + biggestNums[2]);
        }
        else if (criticalProducts[0] >= criticalProducts[1]) {
            System.out.println(smallestNums[0] + " " + smallestNums[1] + " " + biggestNums[2]);
        }
        else {
            System.out.println(biggestNums[0] + " " + biggestNums[1] + " " + biggestNums[2]);
        }
    }
}
