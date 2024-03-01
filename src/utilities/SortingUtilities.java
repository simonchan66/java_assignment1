package utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import shapes.Shape;

public class SortingUtilities {
    public static void bubbleSort(Shape[] arr, Comparator<Shape> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    // Swap arr[j] and arr[j+1]
                    Shape temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(List<Shape> list, Comparator<? super Shape> comparator) {
        if (list.size() > 1) {
            int mid = list.size() / 2;
            List<Shape> left = new ArrayList<>(list.subList(0, mid));
            List<Shape> right = new ArrayList<>(list.subList(mid, list.size()));

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            merge(list, left, right, comparator);
        }
    }

    private static void merge(List<Shape> list, List<Shape> left, List<Shape> right, Comparator<? super Shape> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
    
 // Insertion Sort implementation
    public static void insertionSort(Shape[] arr, Comparator<Shape> comparator) {
        for (int i = 1; i < arr.length; i++) {
            Shape key = arr[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort implementation
    public static void selectionSort(Shape[] arr, Comparator<Shape> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Shape temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Quick Sort implementation
    public static void quickSort(Shape[] arr, Comparator<Shape> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(arr, comparator, low, high);
            quickSort(arr, comparator, low, pi - 1);
            quickSort(arr, comparator, pi + 1, high);
        }
    }

    private static int partition(Shape[] arr, Comparator<Shape> comparator, int low, int high) {
        Shape pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(arr[j], pivot) < 0) {
                i++;
                Shape temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Shape temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    // Heap Sort implementation
    public static void heapSort(Shape[] arr, Comparator<Shape> comparator) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, comparator);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            Shape temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0, comparator);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]
    private static void heapify(Shape[] arr, int n, int i, Comparator<Shape> comparator) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && comparator.compare(arr[l], arr[largest]) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && comparator.compare(arr[r], arr[largest]) > 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            Shape swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, comparator);
        }
    }
}
