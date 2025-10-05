package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    @Test
    void testEmptyArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
        assertEquals(0, sorter.getComparisons());
        assertEquals(0, sorter.getMoves());
    }

    @Test
    void testSingleElementArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
        assertEquals(0, sorter.getComparisons());
        assertEquals(0, sorter.getMoves());
    }

    @Test
    void testArrayWithDuplicates() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {4, 2, 2, 3, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4}, arr);
    }

    @Test
    void testRandomArray() {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {8, 3, 7, 1, 9};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 3, 7, 8, 9}, arr);
    }

    @Test
    void testSortedVsReverse_comparisons() {
        InsertionSort sorter = new InsertionSort();
        int n = 100; // достаточно большой, чтобы показать разницу
        int[] sorted = new int[n];
        int[] reverse = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = i;
            reverse[i] = n - i; // строго убывающая последовательность
        }

        sorter.sort(sorted);
        long compSorted = sorter.getComparisons();

        sorter.sort(reverse);
        long compReverse = sorter.getComparisons();

        assertTrue(compReverse > compSorted,
                "Ожидалось больше сравнений для reverse-order, чем для already-sorted; got reverse=" +
                        compReverse + ", sorted=" + compSorted);
    }

    @Test
    void testNearlySorted_movesLessThanReverse() {
        InsertionSort sorter = new InsertionSort();
        int[] nearly = new int[]{1, 2, 4, 3, 5};
        sorter.sort(nearly);
        long movesNearly = sorter.getMoves();

        int[] reverse = new int[]{5, 4, 3, 2, 1};
        sorter.sort(reverse);
        long movesReverse = sorter.getMoves();

        assertTrue(movesNearly < movesReverse,
                "Ожидалось меньше перемещений для почти-отсортированного массива");
    }
}
