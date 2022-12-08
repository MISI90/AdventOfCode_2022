package info.pniewski.aoc2022.day8;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {
    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 8;
    }

    @Override
    protected String getExpectedCorrectResult() {
        return "21";
    }

    @Override
    protected String getExpectedPuzzle1Result() {
        return "1538";
    }

    @Override
    protected String getExpectedPuzzle2Result() {
        return "496125";
    }
}
