package com.trentontelge.aoc.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordHelper {

    public int getPasswordFromRotations(String fileLocation, int passwordMethod) throws IOException {
        int currentPosition = 50;
        int zeroes = 0;
        switch (passwordMethod) {
            case 1: {
                BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileLocation)));
                while (reader.ready()) {
                    String line = reader.readLine();
                    int magnitude = Integer.parseInt(line.substring(1, line.length()));
                    System.out.println(magnitude);
                    if (line.substring(0, 1).equals("L")) {
                        currentPosition -= magnitude;
                        while (currentPosition < 0) {
                            currentPosition += 100;
                        }
                    } else {
                        currentPosition += magnitude;
                        while (currentPosition > 99) {
                            currentPosition -= 100;
                        }
                    }
                    System.out.println("Magnitude: " + magnitude + " Current Position: " + currentPosition);
                    if (currentPosition == 0) {
                        zeroes++;
                    }
                }
                System.out.println("Zeroes: " + zeroes);
                break;
            }
            case 2: {
                BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileLocation)));
                while (reader.ready()) {
                    String line = reader.readLine();
                    int magnitude = Integer.parseInt(line.substring(1, line.length()));
                    if (line.substring(0, 1).equals("L")) {
                        System.out.println("Magnitude: " + magnitude + " Direction: " + line.substring(0, 1));
                        int prevPos = currentPosition;
                        currentPosition -= magnitude;
                        while (currentPosition < 0) {
                            currentPosition += 100;
                            if (prevPos != 0){
                                zeroes++;
                                System.out.println("Clicked zero going left!");
                            } else {prevPos = -1;}
                        }
                    } else {
                        System.out.println("Magnitude: " + magnitude + " Direction: " + line.substring(0, 1));
                        currentPosition += magnitude;
                        while (currentPosition > 99) {
                            int prevPos = currentPosition;
                            currentPosition -= 100;
                            if (currentPosition != 0) {
                                zeroes++;
                                System.out.println("Clicked zero going right!");
                            } else {prevPos = -1;}
                        }
                    }
                    System.out.println("Current Position: " + currentPosition);
                    if (currentPosition == 0) {
                        zeroes++;
                        System.out.println("Clicked 0 by stopping on it!");
                    }
                }
                System.out.println("Zeroes: " + zeroes);
                break;
            }
        }
        return zeroes;
    }
}