package info.pniewski.aoc2022.day1;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {

    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 1;
    }

    @Override
    protected int getExpectedCorrectResult() {
        return 24000;
    }

    @Override
    protected int getExpectedPuzzle1Result() {
        return 74198;
    }

    @Override
    protected int getExpectedPuzzle2Result() {
        return 209914;
    }

}
