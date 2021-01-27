package edu.drexel.se320;

import java.util.Scanner;

/**
 * @author Man Tik Li
 * Date: October 3, 2020
 * This program prompt user two input: n and k, to calculate the value of combination
 */

public class Combination {
    public static void main(String[] args) {
        // Variables
        int n, k;
        int result;

        // Scanner instance
        Scanner sc = new Scanner(System.in);

        // Prompt for n value from user
        System.out.print("Enter value of n: ");
        n = sc.nextInt();

        // Prompt for m value from user
        System.out.print("Enter value of k: ");
        k = sc.nextInt();

        result = combination(n, k);

        // Print the result
        System.out.println("Result: " + result);

    } // end main

    /**
     * This method find the factorial by using recursion
     * @param n
     * @return The value of factorial
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;

        } else {
            return (n * factorial(n - 1));

        } // end else

    } // end combination

    /**
     * This method calculate combination by using factorial method
     * @param n
     * @param k
     * @return The value of combination
     */
    public static int combination(int n, int k) {
        // Variable
        int result;

        // If either or both input of k and n is negative, throw exception
        if (k < 0 && n < 0) { // If both are negative value
            throw new IllegalArgumentException("Error: both n and k are negative value");

        } else if (k < 0) { // If k is negative value
            throw new IllegalArgumentException("Error: the value of k is less than 0");

        } else if (n < 0) { // If n is negative value
            throw new IllegalArgumentException("Error: the value of n is less than 0");

        } // end if

        // If r equals n, return 1 and exit program
        if (k == n) {
            result = 1;
            return result;
        } // end if

        // If k exceeds n, return 0 and exit program
        if (k > n) {
            result = 0;
            return result;
        } // end if

        // Calculate combination
        result = factorial(n) / (factorial(k) * factorial(n - k));

        return result;

    } // end combination

} // end class
