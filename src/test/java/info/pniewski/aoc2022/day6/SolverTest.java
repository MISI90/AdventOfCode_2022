package info.pniewski.aoc2022.day6;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {
    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 6;
    }

    @Override
    protected String getExpectedCorrectResult() {
        return "11";
    }

    @Override
    protected String getExpectedPuzzle1Result() {
        return "1850";
    }

    @Override
    protected String getExpectedPuzzle2Result() {
        return "2823";
    }
}
