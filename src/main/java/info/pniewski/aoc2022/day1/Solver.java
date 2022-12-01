package info.pniewski.aoc2022.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solver {

    private Solver() {
    }

    public static int solve(Path fileInput, int elvesToSum) throws IOException {
        var lines = Files.readAllLines(fileInput);
        List<Integer> sums = new ArrayList<>();
        int currentElfCalories = 0;
        for (String line : lines) {
            if (line.isEmpty()) {
                sums.add(currentElfCalories);
                currentElfCalories = 0;
            } else {
                currentElfCalories = currentElfCalories + Integer.parseInt(line);
            }
        }
        Collections.sort(sums);
        return sums.stream().sorted(Comparator.reverseOrder()).limit(elvesToSum).mapToInt(Integer::intValue).sum();

    }
}
