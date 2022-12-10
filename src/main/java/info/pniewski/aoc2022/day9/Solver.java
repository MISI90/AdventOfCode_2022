package info.pniewski.aoc2022.day9;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.utils.Position;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solver implements PuzzleSolver {
    @Override
    public String solvePuzzle(List<String> inputs) {
        LinkedList<Position> rope = createRope(2);
        return solve(inputs, rope);
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        LinkedList<Position> rope = createRope(10);
        return solve(inputs, rope);
    }

    private String solve(List<String> inputs, LinkedList<Position> tails) {
        Set<Position> tailPositions = new HashSet<>();
        for (String input : inputs) {
            var s = input.split(" ");
            var steps = Integer.parseInt(s[1]);
            switch (s[0]) {
                case "U":
                    moveInColumn(tails, tailPositions, -steps);
                    break;
                case "D":
                    moveInColumn(tails, tailPositions, steps);
                    break;
                case "L":
                    moveInRow(tails, tailPositions, -steps);
                    break;
                case "R":
                    moveInRow(tails, tailPositions, steps);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s[0]);
            }
        }

        return String.valueOf(tailPositions.size());
    }

    private static LinkedList<Position> createRope(int lenght) {
        return IntStream.range(0, lenght).mapToObj(value -> new Position()).collect(Collectors.toCollection(LinkedList::new));
    }

    private void moveInColumn(LinkedList<Position> rope, Set<Position> tailPositions, int steps) {
        for (int i = 0; i < Math.abs(steps); i++) {
            rope.getFirst().row = (int) (rope.getFirst().row + Math.signum(steps));
            moveKnot(rope, tailPositions);
        }
    }

    private void moveInRow(LinkedList<Position> rope, Set<Position> tailPositions, int steps) {
        for (int i = 0; i < Math.abs(steps); i++) {
            rope.getFirst().column = (int) (rope.getFirst().column + Math.signum(steps));
            moveKnot(rope, tailPositions);
        }
    }

    private void moveKnot(LinkedList<Position> rope, Set<Position> tailPositions) {
        for (int j = 1; j < rope.size(); j++) {
            moveTail(rope.get(j - 1), rope.get(j));
        }
        tailPositions.add(new Position(rope.getLast().row, rope.getLast().column));
    }


    private void moveTail(Position head, Position tail) {
        if (head.column != tail.column && head.row != tail.row && (isFarEnough(head.column, tail.column) || isFarEnough(head.row, tail.row))) {
            var direction = Integer.compare(head.column, tail.column);
            tail.column = tail.column + direction;
            direction = Integer.compare(head.row, tail.row);
            tail.row = tail.row + direction;
        }
        if (isFarEnough(head.column, tail.column)) {
            var direction = Integer.compare(head.column, tail.column);
            tail.column = tail.column + direction;
        }
        if (isFarEnough(head.row, tail.row)) {
            var direction = Integer.compare(head.row, tail.row);
            tail.row = tail.row + direction;
        }
    }

    private static boolean isFarEnough(int head, int tail) {
        return Math.abs(head - tail) > 1;
    }
}
