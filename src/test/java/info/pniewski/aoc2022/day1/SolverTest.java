package info.pniewski.aoc2022.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

class SolverTest {

    @Test
    void checkCorrectInput() throws IOException, URISyntaxException {
        var result = Solver.solve(getFile("day1_test_input.txt"), 1);
        Assertions.assertEquals(24000, result);
    }

    @Test
    void checkPuzzleInput() throws IOException, URISyntaxException {
        var result = Solver.solve(getFile("day1_puzzle_input.txt"), 1);
        Assertions.assertEquals(74198, result);
    }

    @Test
    void checkPuzzle2Input() throws IOException, URISyntaxException {
        var result = Solver.solve(getFile("day1_puzzle_input.txt"), 3);
        Assertions.assertEquals(209914, result);
    }

    private Path getFile(String fileName) throws URISyntaxException {
        return Paths.get(SolverTest.class.getClassLoader().getResource(fileName).toURI());
    }
}
