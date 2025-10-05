package algorithms;

import java.util.Arrays;
public class SelectionSort {
    private int comparisons;
    private int swaps;
    private int arrayAccesses;
    private long startTime;
    private long endTime;

    public SelectionSort() {
        resetMetrics();
    }


    public void sort(int[] arr) {
        resetMetrics();
        startTime = System.nanoTime();

        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int n = arr.length;

        // Early return for empty or single-element arrays
        if (n <= 1) {
            endTime = System.nanoTime();
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            boolean isSorted = true; // Flag for early termination

            for (int j = i + 1; j < n; j++) {
                comparisons++;
                arrayAccesses += 2; // Two array accesses for comparison

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    isSorted = false; // Found an unsorted element
                }
            }

            // Early termination if the remaining portion is already sorted
            if (isSorted && minIndex == i) {
                break;
            }

            // Swap only if necessary
            if (minIndex != i) {
                swap(arr, i, minIndex);
                swaps++;
            }
        }

        endTime = System.nanoTime();
    }


    private void swap(int[] arr, int i, int j) {
        arrayAccesses += 4; // Two reads + two writes
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private void resetMetrics() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        startTime = 0;
        endTime = 0;
    }

    // Metrics getters
    public int getComparisons() { return comparisons; }
    public int getSwaps() { return swaps; }
    public int getArrayAccesses() { return arrayAccesses; }
    public long getTimeNanos() { return endTime - startTime; }
    public double getTimeMillis() { return (endTime - startTime) / 1_000_000.0; }

    public String getPerformanceReport() {
        return String.format(
                "Selection Sort Performance Metrics:%n" +
                        "Time: %.3f ms%n" +
                        "Comparisons: %d%n" +
                        "Swaps: %d%n" +
                        "Array Accesses: %d%n",
                getTimeMillis(), comparisons, swaps, arrayAccesses
        );
    }


    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}