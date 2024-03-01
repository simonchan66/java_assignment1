readMe.txt

Sorting Program by Team Zelda
Date: February 29 2024

#Sorting Program Installation and Usage Guide

## Installation
1. Ensure you have Java installed on your system. This program requires Java SE 8 or later.
2. Ensure the 'Sort.jar' file is saved in the folder.

## Usage
To run the sorting program:
1. Open a terminal or command prompt and navigate to the directory where you saved `Sort.jar`
2. Use the following command structure to start the program: java -jar Sort.jar -f<file_name> -t<v/h/a> -s<b/s/i/m/q/z>

### Command Line Guidance
-f or `-F` followed by <file_name>: Specifies the file name and path. Ensure there are no spaces between the flag and the file name.
-t or `-T` followed by v (volume), h (height) or a (base area): Sets the type of comparison for sorting.
-s or `-S` followed by b (bubble), s (selection), i (insertion), m (merge), q (quick) or z (heap)

### Examples
- To sort shapes by volume using bubble sort from a file named 'shapes1.txt':
java -jar Sort.jar -fshapes1.txt -Tv -Sb

- To sort shapes by base area using quick sort from a file located at 'res\shapes1.txt':
java -jar Sort.jar -ta -sQ -f"res\shapes1".txt

- To sort shapes by height using bubble sort from a file located at 'C:\temp\shapes1.txt':
java -jar Sort.jar -tH -F"C:\temp\shapes1.txt" -sB

### Supported Sorting Algorithms

- BubbleSort (b): Simple comparison-based sorting mechanism.
- SelectionSort (s): Picks the minimum/maximum element from the list and swaps it with the first element.
- InsertionSort (i): Constructs the sorted list one item at a time.
- MergeSort (m): Splits the list into halves, sorts them individually, and then combines the sorted halves.
- QuickSort (q): Segregates the list using a pivot, then sorts the divided lists.
- HeapSort (z): Constructs a heap and subsequently sorts the elements.


### Notes
- The program can handle command line arguments in any order.
- If an incorrect command line argument is entered, the program will display a helpful error message.
- For development and testing purposes, you can configure these arguments in Eclipse under the “Run Configurations” tool, within the “Arguments” tab.

Thank you for using our sorting program!