package info.pniewski.aoc2022.day9;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {
    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 9;
    }

    @Override
    protected String getExpectedCorrectResult() {
        return "13";
    }

    @Override
    protected String getExpectedPuzzle1Result() {
        return "5874";
    }

    @Override
    protected String getExpectedPuzzle2Result() {
        return "2467";
    }
}
