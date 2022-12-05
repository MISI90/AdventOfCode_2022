package info.pniewski.aoc2022.day3;

import info.pniewski.aoc2022.helper.PuzzleSolver;

import java.util.List;

class Solver implements PuzzleSolver {

    /**
     * Letter priorities, each index in list represents the letter priority.
     */
    private final List<Character> chars = List.of(' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    @Override
    public String solvePuzzle(List<String> inputs) {
        int sum = 0;
        for (String input : inputs) {
            String part1 = input.substring(0, input.length() / 2);
            String part2 = input.substring(input.length() / 2);
            sum = sum + findSameLetter(part1, part2);
        }
        return String.valueOf(sum);
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        int sum = 0;
        for (int i = 0; i < inputs.size() / 3; i++) {
            String part1 = inputs.get(i * 3);
            String part2 = inputs.get(i * 3 + 1);
            String part3 = inputs.get(i * 3 + 2);
            sum = sum + findSameLetter(part1, part2, part3);
        }
        return String.valueOf(sum);
    }

    /**
     * Check if any letter from part1 is contained in all other parts and adds this letter to sum.
     *
     * @param part1 first part of string
     * @param parts other parts of strings
     * @return sum of priorities of found letters
     */
    private int findSameLetter(String part1, String... parts) {
        int sum = 0;
        for (char c : part1.toCharArray()) {
            if (anyMatch(c, parts)) {
                sum = sum + chars.indexOf(c);
                break;
            }
        }
        return sum;
    }

    private boolean anyMatch(char c, String... parts) {
        for (String part : parts) {
            if (part.chars().noneMatch(p -> p == c)) {
                return false;
            }
        }
        return true;
    }


}
