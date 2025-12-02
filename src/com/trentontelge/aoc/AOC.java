package com.trentontelge.aoc;

import com.trentontelge.aoc.helpers.PasswordHelper;
import java.io.IOException;

class AOC {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, Advent of Code!");

        final String ROTATIONS_FILE_PATH = "rotations.txt";

        int pass = new PasswordHelper().getPasswordFromRotations(ROTATIONS_FILE_PATH, 2);
    }
}