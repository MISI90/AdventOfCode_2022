package info.pniewski.aoc2022.helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Base class for running test for solvers.
 */
public abstract class PuzzleSolverTest {

    /**
     * Get the solver implementation.
     *
     * @return solver
     */
    protected abstract PuzzleSolver getSolver();

    /**
     * Get the day of the puzzle, used to load correct input files.
     *
     * @return day
     */
    protected abstract String getDay();

    /**
     * Get the expected result for example puzzle input from the description.
     *
     * @return expected result
     */
    protected abstract String getExpectedCorrectResult();

    /**
     * Get the expected result for first part of the puzzle.
     *
     * @return expected result
     */
    protected abstract String getExpectedPuzzle1Result();

    /**
     * Get the expected result for second part of the puzzle.
     *
     * @return expected result
     */
    protected abstract String getExpectedPuzzle2Result();

    @Test
    void checkCorrectInput() throws IOException, URISyntaxException {
        var result = getSolver().solvePuzzle(getLines(String.format("day%s_test_input.txt", getDay())));
        Assertions.assertEquals(getExpectedCorrectResult(), result);
    }

    @Test
    void checkPuzzleInput() throws IOException, URISyntaxException {
        var result = getSolver().solvePuzzle(getLines(String.format("day%s_puzzle_input.txt", getDay())));
        Assertions.assertEquals(getExpectedPuzzle1Result(), result);
    }

    @Test
    void checkPuzzle2Input() throws IOException, URISyntaxException {
        var result = getSolver().solvePuzzle2(getLines(String.format("day%s_puzzle_input.txt", getDay())));
        Assertions.assertEquals(getExpectedPuzzle2Result(), result);
    }

    private List<String> getLines(String fileName) throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(PuzzleSolverTest.class.getClassLoader().getResource(fileName).toURI()));
    }
}
