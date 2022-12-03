package info.pniewski.aoc2022.day1;

import info.pniewski.aoc2022.helper.PuzzleSolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solver implements PuzzleSolver {

    @Override
    public int solvePuzzle(List<String> inputs) {
        return solve(inputs, 1);
    }

    @Override
    public int solvePuzzle2(List<String> inputs) {
        return solve(inputs, 3);
    }

    private int solve(List<String> inputs, int elvesToSum) {
        List<Integer> sums = new ArrayList<>();
        int currentElfCalories = 0;
        for (String line : inputs) {
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
