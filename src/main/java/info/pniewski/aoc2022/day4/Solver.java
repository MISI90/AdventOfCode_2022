package info.pniewski.aoc2022.day4;

import info.pniewski.aoc2022.helper.PuzzleSolver;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Solver implements PuzzleSolver {
    @Override
    public String solvePuzzle(List<String> inputs) {
        return String.valueOf(solve(inputs, this::rangesOverlapWhole));
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        return String.valueOf(solve(inputs, this::rangesOverlapPartly));
    }

    private int solve(List<String> inputs, Predicate<int[]> checkRangesFunction) {
        int sum = 0;
        for (String input : inputs) {
            if (checkRangesFunction.test(Arrays.stream(input.split("[-,]")).mapToInt(Integer::parseInt).toArray())) {
                sum++;
            }
        }
        return sum;
    }

    private boolean rangesOverlapWhole(int[] input) {
        return input[0] <= input[2] && input[1] >= input[3] || input[0] >= input[2] && input[1] <= input[3];
    }

    private boolean rangesOverlapPartly(int[] input) {
        return input[1] >= input[2] && input[0] <= input[3];
    }
}
