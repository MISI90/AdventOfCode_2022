package info.pniewski.aoc2022.day1;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

class SolverTest extends PuzzleSolverTest {

    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected String getDay() {
        return "1";
    }

    @Override
    protected String getExpectedCorrectResult() {
        return "24000";
    }

    @Override
    protected String getExpectedPuzzle1Result() {
        return "74198";
    }

    @Override
    protected String getExpectedPuzzle2Result() {
        return "209914";
    }
}
