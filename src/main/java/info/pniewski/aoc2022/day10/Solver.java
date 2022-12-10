package info.pniewski.aoc2022.day10;

import info.pniewski.aoc2022.helper.PuzzleSolver;

import java.util.ArrayList;
import java.util.List;

class Solver implements PuzzleSolver {
    @Override
    public String solvePuzzle(List<String> inputs) {
        Cpu cpu = new Cpu(List.of(20, 60, 100, 140, 180, 220));
        runCpu(inputs, cpu);
        return String.valueOf(cpu.signalStrenght);
    }

    @Override
    public String solvePuzzle2(List<String> inputs) {
        Cpu cpu = new Cpu(new ArrayList<>());
        runCpu(inputs, cpu);
        return cpu.screen.toString();
    }

    private void runCpu(List<String> inputs, Cpu cpu) {
        for (String input : inputs) {
            var s = input.split(" ");
            if (s[0].equals("noop")) {
                cpu.runCycle(1, 0);
            } else if (s[0].equals("addx")) {
                cpu.runCycle(2, Integer.valueOf(s[1]));
            }
        }
    }

    private static class Cpu {
        int register = 1;
        int cycle = 0;
        int signalStrenght = 0;
        private final List<Integer> cyclesToComputeSignal;
        final StringBuilder screen = new StringBuilder();

        public Cpu(List<Integer> cyclesToComputeSignal) {
            this.cyclesToComputeSignal = cyclesToComputeSignal;
        }

        public void printPixel() {
            if (cycle % 40 == 0 && cycle > 0) {
                screen.append("\n");
            }
            int pixelInLine = cycle % 40;
            if (pixelInLine == register - 1 || pixelInLine == register || pixelInLine == register + 1) {
                screen.append("#");
            } else {
                screen.append(".");
            }
        }

        public void addCycle() {
            cycle++;
            if (cyclesToComputeSignal.contains(cycle)) {
                signalStrenght += cycle * register;
            }
        }

        public void runCycle(int cyclesToRun, Integer registryIncrementation) {
            for (int i = 0; i < cyclesToRun; i++) {
                printPixel();
                addCycle();
            }
            register += registryIncrementation;
        }
    }
}
