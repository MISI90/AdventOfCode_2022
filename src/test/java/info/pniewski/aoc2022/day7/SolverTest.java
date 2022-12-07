package info.pniewski.aoc2022.day7;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {
    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 7;
    }

    @Override
    protected String getExpectedCorrectResult() {
        return "95437";
    }

    @Override
    protected String getExpectedPuzzle1Result() {
        return "2061777";
    }

    @Override
    protected String getExpectedPuzzle2Result() {
        return "4473403";
    }
}
