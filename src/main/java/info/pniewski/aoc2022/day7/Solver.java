package info.pniewski.aoc2022.day7;

import info.pniewski.aoc2022.helper.PuzzleSolver;

import java.util.*;

class Solver implements PuzzleSolver {
    @Override
    public String solvePuzzle(List<String> inputs) {
        Map<String, Integer> sizes = new HashMap<>();
        traverse(inputs, new ArrayList<>(), sizes);
        return String.valueOf(sizes.values().stream().filter(s -> s < 100000).mapToInt(Integer::intValue).sum());
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        Map<String, Integer> sizes = new HashMap<>();
        traverse(inputs, new ArrayList<>(), sizes);
        int usedSpace = 70000000 - sizes.values().stream().max(Comparator.naturalOrder()).orElseThrow();
        return String.valueOf(sizes.values().stream().sorted().filter(e -> 30000000 < usedSpace + e).findFirst().orElseThrow());
    }

    private static void traverse(List<String> input, List<String> current, Map<String, Integer> sizes) {
        for (String line : input) {
            var split = line.split(" ");
            if (line.startsWith("$ cd")) {
                if (split[2].equals("..")) {
                    addSubfoldersToCurrent(current, sizes);
                } else {
                    current.add(split[2]);
                }
            } else if (line.startsWith("$ ls") || line.startsWith("dir")) {
                //ignored
            } else {
                addSum(sizes, current, Integer.parseInt(split[0]));
            }
        }
        addSubfoldersToCurrent(current, sizes);
    }

    private static void addSubfoldersToCurrent(List<String> current, Map<String, Integer> sizes) {
        var size = sizes.get(getKey(current));
        current.remove(current.size() - 1);
        addSum(sizes, current, size);
    }

    private static void addSum(Map<String, Integer> sizes, List<String> current, Integer size) {
        var key = getKey(current);
        sizes.putIfAbsent(key, 0);
        sizes.compute(key, (k, v) -> v + size);
    }

    private static String getKey(List<String> current) {
        return String.join("-", current);
    }


}
