package cli;

import algorithms.InsertionSort;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000};
        String[] types = {"Random", "Sorted", "Reversed"};

        try (FileWriter writer = new FileWriter("results.csv")) {
            writer.write("Type,Size,Comparisons,Moves,Time(ms)\n");

            for (String type : types) {
                for (int size : sizes) {
                    int[] arr = generateArray(size, type);
                    InsertionSort sorter = new InsertionSort();

                    long start = System.nanoTime();
                    sorter.sort(arr);
                    long end = System.nanoTime();
                    double duration = (end - start) / 1_000_000.0;

                    writer.write(String.format("%s,%d,%d,%d,%.3f\n",
                            type, size, sorter.getComparisons(), sorter.getMoves(), duration));

                    System.out.printf("Done: %s (%d)%n", type, size);
                }
            }

            System.out.println("\n✅ Results saved to results.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateArray(int size, String type) {
        int[] arr = new int[size];
        Random random = new Random();

        switch (type) {
            case "Random" -> {
                for (int i = 0; i < size; i++) arr[i] = random.nextInt(size);
            }
            case "Sorted" -> {
                for (int i = 0; i < size; i++) arr[i] = i;
            }
            case "Reversed" -> {
                for (int i = 0; i < size; i++) arr[i] = size - i;
            }
        }
        return arr;
    }
}
