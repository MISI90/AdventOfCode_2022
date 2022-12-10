package info.pniewski.aoc2022.day8;

import info.pniewski.aoc2022.helper.PuzzleSolver;
import info.pniewski.aoc2022.utils.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solver implements PuzzleSolver {
    @Override
    public String solvePuzzle(List<String> inputs) {
        Map<Position, Integer> grid = getGrid(inputs);
        var size = inputs.size();
        int visible = size * 4 - 4;

        for (int row = 1; row < size - 1; row++) {
            for (int column = 1; column < size - 1; column++) {
                int tree = grid.get(getPosition(row, column));
                int finalRow = row;
                int finalColumn = column;
                List<Long> anySideVisible = new ArrayList<>();
                anySideVisible.add(grid.entrySet().stream().filter(p -> p.getKey().row < finalRow && p.getKey().column == finalColumn && p.getValue() >= tree).count());
                anySideVisible.add(grid.entrySet().stream().filter(p -> p.getKey().row > finalRow && p.getKey().column == finalColumn && p.getValue() >= tree).count());
                anySideVisible.add(grid.entrySet().stream().filter(p -> p.getKey().column < finalColumn && p.getKey().row == finalRow && p.getValue() >= tree).count());
                anySideVisible.add(grid.entrySet().stream().filter(p -> p.getKey().column > finalColumn && p.getKey().row == finalRow && p.getValue() >= tree).count());

                if (anySideVisible.contains(0L)) {
                    visible++;
                }
            }
        }
        return String.valueOf(visible);
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        Map<Position, Integer> grid = getGrid(inputs);
        Map<Position, Integer> scenicScore = new HashMap<>();
        var size = inputs.size();

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                var position = getPosition(row, column);
                int tree = grid.get(position);
                var left = checkRow(grid, position, tree, -1);
                var right = checkRow(grid, position, tree, 1);
                var top = checkColumn(grid, position, tree, -1);
                var bottom = checkColumn(grid, position, tree, 1);
                scenicScore.put(position, left * right * top * bottom);
            }
        }
        return String.valueOf(scenicScore.values().stream().max(Integer::compareTo).orElseThrow());
    }

    private int checkColumn(Map<Position, Integer> grid, Position position, int treeSize, int nextMove) {
        int count = 0;
        Position nextPosition = getPosition(position.row + nextMove, position.column);
        if (grid.containsKey(nextPosition)) {
            count++;
            if (grid.get(nextPosition) >= treeSize) {
                return count;
            } else {
                count = count + checkColumn(grid, nextPosition, treeSize, nextMove);
            }
        }
        return count;
    }

    private int checkRow(Map<Position, Integer> grid, Position position, int treeSize, int nextMove) {
        int count = 0;
        Position nextPosition = getPosition(position.row, position.column + nextMove);
        if (grid.containsKey(nextPosition)) {
            count++;
            if (grid.get(nextPosition) >= treeSize) {
                return count;
            } else {
                count = count + checkRow(grid, nextPosition, treeSize, nextMove);
            }
        }
        return count;
    }

    private Position getPosition(int row, int column) {
        return new Position(row, column);
    }

    private Map<Position, Integer> getGrid(List<String> inputs) {
        Map<Position, Integer> grid = new HashMap<>();
        int length = inputs.size();
        for (int row = 0; row < length; row++) {
            String[] split = inputs.get(row).split("");
            for (int column = 0; column < length; column++) {
                grid.put(getPosition(row, column), Integer.parseInt(split[column]));
            }
        }
        return grid;
    }

}
