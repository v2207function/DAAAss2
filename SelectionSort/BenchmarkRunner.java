package cli;

import Metrics.PerformanceTracker;


public class BenchmarkRunner {

    public static void main(String[] args) {
        System.out.println("Selection Sort Benchmark Runner");
        System.out.println("===============================");

        PerformanceTracker tracker = new PerformanceTracker();

        if (args.length > 0 && args[0].equals("--quick")) {
            runQuickDemo();
        } else {
            tracker.runBenchmarks();
        }
    }


    private static void runQuickDemo() {
        System.out.println("Quick Demo Mode");
        System.out.println("===============");

        algorithms.SelectionSort sorter = new algorithms.SelectionSort();

        // Demo with small array
        int[] smallArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + java.util.Arrays.toString(smallArray));

        sorter.sort(smallArray);

        System.out.println("Sorted array: " + java.util.Arrays.toString(smallArray));
        System.out.println(sorter.getPerformanceReport());
    }
}