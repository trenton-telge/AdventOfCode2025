package com.trentontelge.aoc;

import com.trentontelge.aoc.helpers.PasswordHelper;
import com.trentontelge.aoc.helpers.ProductIdHelper;

import java.io.IOException;

class AOC {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, Advent of Code!");

        /** Problem 1 **/

        final String ROTATIONS_FILE_PATH = "rotations.txt";

        int pass = new PasswordHelper().getPasswordFromRotations(ROTATIONS_FILE_PATH, 2);
        System.out.println("Pass: " + pass);
        /** Problem 2 **/
        ProductIdHelper productIdHelper = new ProductIdHelper();
        long sumOfInvalidIds1 = productIdHelper.sumInvalidIds(productIdHelper.getProductIdTuples(), 1);
        long sumOfInvalidIds2 = productIdHelper.sumInvalidIds(productIdHelper.getProductIdTuples(), 2);
        System.out.println("Sum of invalid product IDs using method 1: " + sumOfInvalidIds1);
        System.out.println("Sum of invalid product IDs using method 2: " + sumOfInvalidIds2);
    }
}