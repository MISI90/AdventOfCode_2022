package info.pniewski.aoc2022.helper;

import java.util.List;

/**
 * Base class for puzzle solving classes for easier testing.
 */
public interface PuzzleSolver {

    /**
     * Solve the first puzzle.
     *
     * @param inputs lines for puzzle input
     * @return result
     */
    String solvePuzzle(List<String> inputs);

    /**
     * Solve the second puzzle.
     *
     * @param inputs lines for puzzle input
     * @return result
     */
    String solvePuzzle2(List<String> inputs);
}
