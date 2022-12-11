package info.pniewski.aoc2022.day11;

import info.pniewski.aoc2022.helper.PuzzleSolver;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

class Solver implements PuzzleSolver {
    @Override
    public String solvePuzzle(List<String> inputs) {
        return solve(inputs, 20, BigInteger.valueOf(3));
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        return solve(inputs, 10000, null);
    }

    private String solve(List<String> inputs, int rounds, BigInteger stressReductionLevel) {
        List<Monkey> monkeys = parseInputs(inputs);
        var divider = monkeys.stream().mapToInt(monkey -> monkey.test.intValue()).reduce((i1, i2) -> i1 * i2).orElseThrow();
        for (int i = 0; i < rounds; i++) {
            for (Monkey monkey : monkeys) {
                for (BigInteger item : monkey.items) {
                    BigInteger worry;
                    if (stressReductionLevel == null) {
                        worry = monkey.operation.apply(item);
                    } else {
                        worry = monkey.operation.apply(item).divide(stressReductionLevel);
                    }
                    worry = worry.mod(BigInteger.valueOf(divider));
                    if (worry.mod(monkey.test).equals(BigInteger.ZERO)) {
                        monkeys.get(monkey.testTrue).items.addLast(worry);
                    } else {
                        monkeys.get(monkey.testFalse).items.addLast(worry);
                    }
                    monkey.inspectedItems++;
                }
                monkey.items = new LinkedList<>();
            }
        }
        var ref = new Object() {
            BigInteger result = BigInteger.ONE;
        };
        monkeys.stream().map(monkey -> monkey.inspectedItems).sorted(Comparator.reverseOrder()).limit(2).forEach(i -> ref.result = ref.result.multiply(BigInteger.valueOf(i)));
        return String.valueOf(ref.result);
    }

    private List<Monkey> parseInputs(List<String> inputs) {
        List<Monkey> monkeys = new ArrayList<>();
        Monkey monkey = new Monkey();
        for (String input : inputs) {
            input = input.trim();
            var inputSplitted = input.trim().split(" ");
            if (input.startsWith("Starting items:")) {
                var itemsS = input.split("( )|(, )");
                for (int i = 2; i < itemsS.length; i++) {
                    monkey.items.add(BigInteger.valueOf(Long.parseLong(itemsS[i])));
                }
            } else if (input.startsWith("Operation:")) {
                if (inputSplitted[4].equals("+")) {
                    monkey.operation = value -> value.add(BigInteger.valueOf(Integer.parseInt(inputSplitted[5])));
                } else if (inputSplitted[4].equals("*")) {
                    if (inputSplitted[5].equals("old")) {
                        monkey.operation = value -> value.multiply(value);
                    } else {
                        monkey.operation = value -> value.multiply(BigInteger.valueOf(Integer.parseInt(inputSplitted[5])));
                    }
                }
            } else if (input.startsWith("Test:")) {
                monkey.test = BigInteger.valueOf(Integer.parseInt(inputSplitted[3]));
            } else if (input.startsWith("If true:")) {
                monkey.testTrue = Integer.valueOf(inputSplitted[5]);
            } else if (input.startsWith("If false:")) {
                monkey.testFalse = Integer.valueOf(inputSplitted[5]);
            } else if (input.length() == 0) {
                monkeys.add(monkey);
                monkey = new Monkey();
            }
        }
        monkeys.add(monkey);
        return monkeys;
    }

    private static class Monkey {
        LinkedList<BigInteger> items = new LinkedList<>();
        Function<BigInteger, BigInteger> operation;
        BigInteger test;
        Integer testTrue;
        Integer testFalse;
        Integer inspectedItems = 0;
    }
}
