package info.pniewski.aoc2022.day11;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {
    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 11;
    }

    @Override
    protected String getExpectedCorrectResult() {
        return "10605";
    }

    @Override
    protected String getExpectedPuzzle1Result() {
        return "90294";
    }

    @Override
    protected String getExpectedPuzzle2Result() {
        return "18170818354";
    }
}
