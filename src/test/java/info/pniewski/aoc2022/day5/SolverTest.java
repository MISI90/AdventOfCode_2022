package info.pniewski.aoc2022.day5;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {
    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 5;
    }

    @Override
    protected String getExpectedCorrectResult() {
        return "CMZ";
    }

    @Override
    protected String getExpectedPuzzle1Result() {
        return "TLNGFGMFN";
    }

    @Override
    protected String getExpectedPuzzle2Result() {
        return "FGLQJCMBD";
    }
}
