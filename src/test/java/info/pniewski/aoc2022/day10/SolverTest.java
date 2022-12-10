package info.pniewski.aoc2022.day10;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.helper.PuzzleSolverTest;

public class SolverTest extends PuzzleSolverTest {
    @Override
    protected PuzzleSolver getSolver() {
        return new Solver();
    }

    @Override
    protected int getDay() {
        return 10;
    }

    @Override
    protected String getExpectedCorrectResult() {
        return "13140";
    }

    @Override
    protected String getExpectedPuzzle1Result() {
        return "15140";
    }

    @Override
    protected String getExpectedPuzzle2Result() {
        return "###..###....##..##..####..##...##..###..\n" +
               "#..#.#..#....#.#..#....#.#..#.#..#.#..#.\n" +
               "###..#..#....#.#..#...#..#....#..#.#..#.\n" +
               "#..#.###.....#.####..#...#.##.####.###..\n" +
               "#..#.#....#..#.#..#.#....#..#.#..#.#....\n" +
               "###..#.....##..#..#.####..###.#..#.#....";
    }

}
