package info.pniewski.aoc2022.day2;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {
    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 2;
    }

    @Override
    protected String getExpectedCorrectResult() {
        return "15";
    }

    @Override
    protected String getExpectedPuzzle1Result() {
        return "9241";
    }

    @Override
    protected String getExpectedPuzzle2Result() {
        return "14610";
    }
}
