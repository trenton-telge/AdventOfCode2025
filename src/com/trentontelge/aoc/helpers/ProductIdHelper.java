package com.trentontelge.aoc.helpers;

import com.trentontelge.aoc.objects.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProductIdHelper {

    public ArrayList<Tuple> getProductIdTuples() throws IOException {
        ArrayList<Tuple> productIdTuples = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("product-ids.txt")));
        String lineOfIds = reader.readLine();
        List<String> idStrings = List.of(lineOfIds.split(","));
        for (String idString : idStrings) {
            List<String> idPair = List.of(idString.split("-"));
            long firstId = Long.parseLong(idPair.get(0));
            long secondId = Long.parseLong(idPair.get(1));
            productIdTuples.add(new Tuple(firstId, secondId));
        }
        return productIdTuples;
    }

    public long sumInvalidIds(ArrayList<Tuple> tuples, int option) {
        long sum = 0;
        for (Tuple idTuple : tuples) {
            for (long id = idTuple.first; id <= idTuple.second; id++) {
                switch (option) {
                    case 1:
                        if (!isValidIdOpt1(id)) {
                            sum += id;
                        }
                        break;
                    case 2:
                        if (!isValidIdOpt2(id)) {
                            sum += id;
                        }
                        break;
                }
            }
        }
        return sum;
    }

    public boolean isValidIdOpt1(long id) {
        System.out.println("Checking ID: " + id);
        String longAsString = Long.toString(id);
        int halfLength = longAsString.length() / 2;
        for (int biteSize = 1; biteSize <= halfLength; biteSize++) {
            String firstBite = longAsString.substring(0, biteSize);
            System.out.println("Checking bite: " + firstBite);
            String workingString = longAsString;
            while (firstBite.length() <= workingString.length() && workingString.startsWith(firstBite)) {
                System.out.println("Chomp string: " + workingString);
                workingString = workingString.substring(firstBite.length());
            }
            if (workingString.isEmpty()) {
                System.out.println("Invalid ID: " + id);
                return false;
            }
        }
        System.out.println("Valid ID: " + id);
        return true;
    }

    public boolean isValidIdOpt2(long id) {
        System.out.println("Checking ID: " + id);
        String longAsString = Long.toString(id);
        if (longAsString.length() %2 != 0) {
            System.out.println("Valid ID: " + id);
            return true;
        }
        if (longAsString.substring(longAsString.length()/2).equals(longAsString.substring(0, longAsString.length()/2))) {
            System.out.println("Invalid ID: " + id);
            return false;
        }
        System.out.println("Valid ID: " + id);
        return true;
    }
}
