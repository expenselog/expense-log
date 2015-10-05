package com.expenselog;

/**
 * Created by djavorszky on 03/10/15.
 */
public class Main {

    public static void main(String[] args) {

        // This is only a test.
        int length = args.length;

        if (length > 0) {
            System.out.println("Printing out arguments:");

            int i = 1;
            for (String argument : args) {
                System.out.println("Argument " + i++ + ": " + argument);
            }
        }
        else {
            System.out.println("Program called with no arguments.");
        }
    }
}
