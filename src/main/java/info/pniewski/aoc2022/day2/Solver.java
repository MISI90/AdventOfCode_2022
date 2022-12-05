package info.pniewski.aoc2022.day2;

import info.pniewski.aoc2022.helper.PuzzleSolver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

class Solver implements PuzzleSolver {

    @Override
    public String solvePuzzle(List<String> inputs) {
        return String.valueOf(solve(inputs, (option, s) -> Option.getOption(s)));
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        return String.valueOf(solve(inputs, this::getOptionForExpectedResult));
    }

    /**
     * Solve the puzzle.
     *
     * @param inputs                    input line
     * @param calculateOptionForPlayer2 {@link BiFunction} for calculating the correct option for player 2, inputs are {@link Option} - player 1 selected option, {@link String} - player 2 expected result in form of X, Y, Z
     * @return puzzle answer
     */
    private int solve(List<String> inputs, BiFunction<Option, String, Option> calculateOptionForPlayer2) {
        int sum = 0;
        for (String input : inputs) {
            var battle = input.split(" ");
            var player1 = Option.getOption(battle[0]);
            var player2 = calculateOptionForPlayer2.apply(player1, battle[1]);

            sum = calculateAndAddResult(sum, player1, player2);
        }
        return sum;
    }

    private Option getOptionForExpectedResult(Option player1, String expectedResult) {
        if (expectedResult.equals("Y")) {
            return player1;
        } else if (expectedResult.equals("X")) {
            if (Objects.requireNonNull(player1) == Option.ROCK) {
                return Option.SCISSOR;
            } else if (player1 == Option.PAPER) {
                return Option.ROCK;
            }
            return Option.PAPER;
        }
        if (Objects.requireNonNull(player1) == Option.ROCK) {
            return Option.PAPER;
        } else if (player1 == Option.PAPER) {
            return Option.SCISSOR;
        }
        return Option.ROCK;
    }

    private int calculateAndAddResult(int sum, Option player1, Option player2) {
        if (player1 == player2) {
            sum = sum + 3;
        } else if (player2Wins(player1, player2)) {
            sum = sum + 6;
        }
        sum = sum + player2.getScore();
        return sum;
    }

    private boolean player2Wins(Option player1, Option player2) {
        return player2 == Option.ROCK && player1 == Option.SCISSOR || player2 == Option.PAPER && player1 == Option.ROCK || player2 == Option.SCISSOR && player1 == Option.PAPER;
    }

    private enum Option {
        ROCK(1, "A", "X"),
        PAPER(2, "B", "Y"),
        SCISSOR(3, "C", "Z");

        private final int score;
        private final String[] chars;

        Option(int score, String... chars) {
            this.score = score;
            this.chars = chars;
        }

        public int getScore() {
            return score;
        }

        public static Option getOption(String value) {
            for (Option option : Option.values()) {
                if (Arrays.asList(option.chars).contains(value)) {
                    return option;
                }
            }
            return null;
        }
    }

}
