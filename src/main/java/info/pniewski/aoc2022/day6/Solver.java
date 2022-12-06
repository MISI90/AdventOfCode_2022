package info.pniewski.aoc2022.day6;

import info.pniewski.aoc2022.helper.PuzzleSolver;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

class Solver implements PuzzleSolver {
    @Override
    public String solvePuzzle(List<String> inputs) {
        return solve(inputs.get(0), 4);
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        return solve(inputs.get(0), 14);
    }

    private String solve(String line, int markerLength) {
        var chars = line.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        for (int i = 0; i < chars.length; i++) {
            var expectedMarker = Arrays.copyOfRange(chars, i, i + markerLength);
            try {
                Set.of(expectedMarker);
                return String.valueOf(i + markerLength);
            } catch (IllegalArgumentException ex) {
                //keep going...
            }
        }
        return null;
    }

}
