package Metrics;

import algorithms.SelectionSort;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PerformanceTracker {
    private List<PerformanceRecord> records;
    private SelectionSort sorter;

    public PerformanceTracker() {
        this.records = new ArrayList<>();
        this.sorter = new SelectionSort();
    }

    public static class PerformanceRecord {
        public final String inputType;
        public final int size;
        public final double timeMillis;
        public final int comparisons;
        public final int swaps;
        public final int arrayAccesses;

        public PerformanceRecord(String inputType, int size, double timeMillis,
                                 int comparisons, int swaps, int arrayAccesses) {
            this.inputType = inputType;
            this.size = size;
            this.timeMillis = timeMillis;
            this.comparisons = comparisons;
            this.swaps = swaps;
            this.arrayAccesses = arrayAccesses;
        }
    }



    public void runBenchmarks() {
        int[] sizes = {100, 1000, 10000, 50000}; // Reduced max size for practical testing

        System.out.println("Running Selection Sort Benchmarks...");
        System.out.println("=====================================");

        for (int size : sizes) {
            benchmarkInputType("Random", generateRandomArray(size));
            benchmarkInputType("Sorted", generateSortedArray(size));
            benchmarkInputType("Reverse", generateReverseSortedArray(size));
            benchmarkInputType("NearlySorted", generateNearlySortedArray(size));
            System.out.println(); // Blank line between sizes
        }

        exportToCSV("performance_metrics.csv");
    }

    private void benchmarkInputType(String type, int[] array) {
        int[] copy = array.clone(); // Work on copy to preserve original

        sorter.sort(copy);

        PerformanceRecord record = new PerformanceRecord(
                type,
                array.length,
                sorter.getTimeMillis(),
                sorter.getComparisons(),
                sorter.getSwaps(),
                sorter.getArrayAccesses()
        );

        records.add(record);

        System.out.printf("%-12s - Size: %6d, Time: %8.3f ms, Comparisons: %10d, Swaps: %8d%n",
                type, record.size, record.timeMillis, record.comparisons, record.swaps);
    }

    // Array generation methods
    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size * 10);
        }
        return arr;
    }

    private int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    private int[] generateNearlySortedArray(int size) {
        int[] arr = generateSortedArray(size);
        // Swap 10% of elements randomly
        int swaps = size / 10;
        for (int i = 0; i < swaps; i++) {
            int idx1 = (int) (Math.random() * size);
            int idx2 = (int) (Math.random() * size);
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
        return arr;
    }


    private void exportToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("InputType,Size,TimeMs,Comparisons,Swaps,ArrayAccesses\n");

            for (PerformanceRecord record : records) {
                writer.write(String.format("%s,%d,%.3f,%d,%d,%d\n",
                        record.inputType, record.size, record.timeMillis,
                        record.comparisons, record.swaps, record.arrayAccesses));
            }

            System.out.println("Performance metrics exported to: " + filename);
        } catch (IOException e) {
            System.err.println("Error exporting to CSV: " + e.getMessage());
        }
    }

    public List<PerformanceRecord> getRecords() {
        return new ArrayList<>(records);
    }
}