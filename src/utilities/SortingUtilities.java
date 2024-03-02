package utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import shapes.Shape;
/**
 * SortingUtilities.java
 * 
 * Class Definition: Provides an implementation of sorting algorithms for sorting an array of elements.
 * 
 * @author Team Zelda
 * @version 2.0
 */
public class SortingUtilities {
    /**
     * Sorts an array of using the Bubble Sort algorithm.
     * 
     * Precondition: The array of elements and comparator exists.
	 * 
	 * Postcondition: The array is sorted.
	 * 
     * @param arr the array of elements to be sorted.
     * @param comparator the comparator used to determine the order of the elements.
     */
    public static void bubbleSort(Shape[] arr, Comparator<Shape> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Bubble up the largest element to the end of unsorted part of array
            for (int j = 0; j < n - i - 1; j++) {
                // Use the comparator to see if two elements are out of order
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    // Swap arr[j] and arr[j+1]
                    Shape temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    /**
     * Sorts an array of using the Merge Sort algorithm.
     * 
     * Precondition: The array of elements and comparator exists.
	 * 
	 * Postcondition: The array is sorted.
	 * 
     * @param arr the array of elements to be sorted.
     * @param comparator the comparator used to determine the order of the elements.
     */
    public static void mergeSort(List<Shape> list, Comparator<? super Shape> comparator) {
        // Only sort if list size is greater than 1
        if (list.size() > 1) {

            // Find the middle of the list
            int mid = list.size() / 2;

            // Split the list in half, left and right
            List<Shape> left = new ArrayList<>(list.subList(0, mid));
            List<Shape> right = new ArrayList<>(list.subList(mid, list.size()));

            // Recursively sort the two halves
            mergeSort(left, comparator);
            mergeSort(right, comparator);

            // Merge the sorted halves together
            merge(list, left, right, comparator);
        }
    }
    // Merges two sorted lists into one
    private static void merge(List<Shape> list, List<Shape> left, List<Shape> right,
            Comparator<? super Shape> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        // Add any remaining elements from the left list
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        // Add any remaining elements from the right list
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
    /**
     * Sorts an array of using the Insertion Sort algorithm.
     * 
     * Precondition: The array of elements and comparator exists.
	 * 
	 * Postcondition: The array is sorted.
	 * 
     * @param arr the array of elements to be sorted.
     * @param comparator the comparator used to determine the order of the elements.
     */
    public static void insertionSort(Shape[] arr, Comparator<Shape> comparator) {
        for (int i = 1; i < arr.length; i++) {
            Shape key = arr[i];
            // Start comparing with the last element
            int j = i - 1;

            // Shift elements to the right to make room for key
            while (j >= 0 && comparator.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Place key into its correct position
            arr[j + 1] = key;
        }
    }
    /**
     * Sorts an array of using the Selection Sort algorithm.
     * 
     * Precondition: The array of elements and comparator exists.
	 * 
	 * Postcondition: The array is sorted.
	 * 
     * @param arr the array of elements to be sorted.
     * @param comparator the comparator used to determine the order of the elements.
     */
    public static void selectionSort(Shape[] arr, Comparator<Shape> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Assume the first element is minimum
            int minIndex = i;

            // Test against elements after i to find the smallest
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            Shape temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    /**
     * Sorts an array of using the Quick Sort algorithm.
     * 
     * Precondition: The array of elements and comparator exists.
	 * 
	 * Postcondition: The array is sorted.
	 * 
     * @param arr the array of elements to be sorted.
     * @param comparator the comparator used to determine the order of the elements.
     * @param low the index of the first element of the array.
     * @param high the index of the last element of the array.
     */
    public static void quickSort(Shape[] arr, Comparator<Shape> comparator, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index.
            int pi = partition(arr, comparator, low, high);

            // Recursively sort the two subarrays divided by the pivot.
            quickSort(arr, comparator, low, pi - 1);
            quickSort(arr, comparator, pi + 1, high);
        }
    }
    private static int partition(Shape[] arr, Comparator<Shape> comparator, int low, int high) {
        // Choose the last element as pivot.
        Shape pivot = arr[high];

        // Index of the smaller element indicates the right position of the pivot at the moment
        int i = low - 1;
        for (int j = low; j < high; j++) {
             // If current element is smaller than the pivot, swap it with the greater element
            if (comparator.compare(arr[j], pivot) < 0) {
                i++;
                // Swap arr[i] and arr[j].
                Shape temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap the pivot element with the element at i+1 so that the pivot is at its correct sorted position.
        Shape temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    /**
     * Sorts an array of using the Heap Sort algorithm.
     * 
     * Precondition: The array of elements and comparator exists.
	 * 
	 * Postcondition: The array is sorted.
	 * 
     * @param arr the array of elements to be sorted.
     * @param comparator the comparator used to determine the order of the elements.
     */
    public static void heapSort(Shape[] arr, Comparator<Shape> comparator) {
        int n = arr.length;

        // Build heap from array
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, comparator);

        // Take the largest element from the heap and move it to the end of the array.
        for (int i = n - 1; i > 0; i--) {
            // Swap the top of the heap with the last item of the heap.
            Shape temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0, comparator);
        }
    }
    // Fix the heap so parents are larger than their children.
    private static void heapify(Shape[] arr, int n, int i, Comparator<Shape> comparator) {
        // Initialize largest as root
        int largest = i; 
         // Position of the left child.
        int l = 2 * i + 1; 
        // Position of the right child.
        int r = 2 * i + 2; 

        // If left child is larger than root
        if (l < n && comparator.compare(arr[l], arr[largest]) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && comparator.compare(arr[r], arr[largest]) > 0)
            largest = r;

        // If largest is not root, swap it
        if (largest != i) {
            Shape swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, comparator);
        }
    }
}
