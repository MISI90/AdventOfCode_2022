package info.pniewski.aoc2022.day5;

import info.pniewski.aoc2022.helper.PuzzleSolver;

import java.util.*;

class Solver implements PuzzleSolver {
    @Override
    public String solvePuzzle(List<String> inputs) {
        return solve(inputs, false);
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        return solve(inputs, true);
    }

    private String solve(List<String> inputs, boolean useCrateMover9001) {
        Map<Integer, LinkedList<String>> stacks = new HashMap<>();
        List<int[]> moves = new ArrayList<>();
        parseInput(inputs, stacks, moves);
        for (int[] move : moves) {
            var from = stacks.get(move[1] - 1);
            var to = stacks.get(move[2] - 1);
            List<String> tempStack = new ArrayList<>();
            for (int i = 0; i < move[0]; i++) {
                tempStack.add(from.removeLast());
            }
            if (useCrateMover9001) {
                Collections.reverse(tempStack);
            }
            to.addAll(tempStack);
        }
        StringBuilder sb = new StringBuilder();
        for (LinkedList<String> stack : stacks.values()) {
            sb.append(stack.getLast());
        }
        return sb.toString();

    }

    private void parseInput(List<String> inputs, Map<Integer, LinkedList<String>> stacks, List<int[]> moves) {
        boolean isStack = true;
        List<String> stacksLines = new ArrayList<>();
        List<String> movesLines = new ArrayList<>();
        for (String input : inputs) {
            if (input.length() == 0) {
                isStack = false;
            } else {
                if (isStack) {
                    stacksLines.add(input);
                } else {
                    movesLines.add(input);
                }
            }
        }
        parseStacksLines(stacksLines, stacks);
        parseMovesLines(movesLines, moves);
    }

    private void parseStacksLines(List<String> stacksLines, Map<Integer, LinkedList<String>> stacks) {
        for (int j = 0; j < stacksLines.size() - 1; j++) {
            String line = stacksLines.get(j);
            String[] split = line.split("( {4})|( {3})|( )");
            for (int i = 0; i < split.length; i++) {
                String letter = split[i];
                if (!letter.isEmpty()) {
                    stacks.computeIfAbsent(i, integer -> new LinkedList<>());
                    stacks.get(i).push(letter.substring(1, 2));
                }
            }
        }
    }

    private void parseMovesLines(List<String> movesLines, List<int[]> moves) {
        for (String line : movesLines) {
            moves.add(Arrays.stream(line.split("[(move )|( from )|( to )]")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray());
        }
    }
}
