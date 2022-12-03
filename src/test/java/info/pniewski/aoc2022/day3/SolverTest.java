package info.pniewski.aoc2022.day3;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {
    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 3;
    }

    @Override
    protected int getExpectedCorrectResult() {
        return 157;
    }

    @Override
    protected int getExpectedPuzzle1Result() {
        return 8105;
    }

    @Override
    protected int getExpectedPuzzle2Result() {
        return 2363;
    }
}
