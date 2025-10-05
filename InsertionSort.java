package algorithms;

public class InsertionSort {
    private long comparisons;
    private long moves; // количество записей в массив (перемещений)

    // Возвращает количество сравнений после последнего sort()
    public long getComparisons() { return comparisons; }

    // Возвращает количество перемещений (записей в массив) после последнего sort()
    public long getMoves() { return moves; }

    // Сортировка вставками. Внутри сортировки мы СБРАСЫВАЕМ метрики,
    // чтобы каждый вызов sort() давал измерения только для этого запуска.
    public void sort(int[] arr) {
        comparisons = 0;
        moves = 0;

        if (arr == null || arr.length <= 1) return;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Считаем каждое сравнение arr[j] > key (включая сравнение, которое ломает цикл)
            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j]; // сдвиг вправо
                    moves++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key; // вставляем ключ
            moves++;
        }
    }

    // Для отладки/CLI
    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
    }
}
