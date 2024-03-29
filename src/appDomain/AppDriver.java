package appDomain;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import shapes.*;
import utilities.SortingUtilities;

/**
 * AppDriver.java
 *
 * Class Definition: Represents the main driver class for the shape sorting application.
 * Handle these command line arguments, 
 * read a text file of random shapes that adds them to an array,
 * using specified comparison type and sorting algorithm, 
 * and prints relevant information about the sorting process.
 * 
 * @author Team Zelda
 * @version 2.0
 */
public class AppDriver {
    /**
     * Main method to execute the shape sorting application.
     *
     * @param args the command line arguments
     */
	public static void main(String[] args) {
	    String fileNameArg = null;
	    String typeArg = null;
	    String sortingArg = null;

	    // Iterate over the command line arguments
	    for (String arg : args) {
	        // Check if the argument starts with '-f' or '-F' for file name
	        if (arg.toLowerCase().startsWith("-f")) {
	            fileNameArg = arg;
	        }
	        // Check if the argument starts with '-t' or '-T' for type
	        else if (arg.toLowerCase().startsWith("-t")) {
	            typeArg = arg;
	        }
	        // Check if the argument starts with '-s' or '-S' for sorting algorithm
	        else if (arg.toLowerCase().startsWith("-s")) {
	            sortingArg = arg;
	        }
	        // If the argument doesn't start with any of the expected prefixes, it's invalid
	        else {
	            System.out.println("Invalid argument: " + arg);
	            return;
	        }
	    }

	    // Check if all required arguments were found
	    if (fileNameArg == null || typeArg == null || sortingArg == null) {
	        System.out.println("Missing required arguments!");
	        return;
	    }

	    // Extract file name from the argument
	    String fileName = extractFileName(fileNameArg);

	    // Extract comparison type from the argument
	    char comparisonType = typeArg.toLowerCase().charAt(2);

	    // Extract sorting algorithm from the argument
	    char sortingAlgorithm = sortingArg.toLowerCase().charAt(2);

	    // Create shapes from the file
	    List<Object> shapes = ShapeFactory.createShapes(fileName);

	    // Choose comparison type
	    Comparator<Shape> comparator = null;
	    switch (comparisonType) {
	        case 'v':
			Comparator<Shape> volComparator = new VolumeComparator().reversed();
			comparator = volComparator;
	            
	            break;
	        case 'h':
	            comparator = Comparator.comparing(Shape::getHeight).reversed();
	            break;
	        case 'a':
				Comparator<Shape> areaComparator = new BaseAreaComparator().reversed();
	            comparator = areaComparator;
	            break;
	        default:
	            System.out.println("Invalid comparison type!");
	            return;
	    }

	    // Convert list of shapes to an array
	    Shape[] shapeArray = new Shape[shapes.size()];
	    shapes.toArray(shapeArray);
	    

	    // Choose sorting algorithm
	    long startTime = System.currentTimeMillis();
	    switch (sortingAlgorithm) {
	        case 'b':
	            SortingUtilities.bubbleSort(shapeArray, comparator);
	            break;
	        case 's':
	            SortingUtilities.selectionSort(shapeArray, comparator);
	            break;
	        case 'i':
	            SortingUtilities.insertionSort(shapeArray, comparator);
	            break;
	        case 'm':
	            SortingUtilities.mergeSort(shapeArray, comparator);
	            break;
	        case 'q':
	            SortingUtilities.quickSort(shapeArray, comparator, 0, shapeArray.length - 1);
	            break;
	        case 'z':
	            // Heap Sort
				SortingUtilities.heapSort(shapeArray, comparator);
	            break;
	        default:
	            System.out.println("Invalid sorting algorithm!");
	            return;
	    }
	    long endTime = System.currentTimeMillis();
	    long sortingTime = endTime - startTime;
	    
	 // Print the sorting time
	    System.out.println("Sorting time: " + sortingTime + " milliseconds");

	 // Print the first sorted value
	    Shape firstShape = shapeArray[0];
	    System.out.println("First sorted value: " + firstShape);
	    switch (comparisonType) {
	        case 'h':
	            System.out.println("Height: " + firstShape.getHeight());
	            break;
	        case 'v':
	            System.out.println("Volume: " + firstShape.calcVolume());
	            
	            break;
	        case 'a':
	            System.out.println("Base Area: " + firstShape.calcBaseArea());
	            
	            break;
	        default:
	            break;
	    }

	    // Print every thousandth value in between
	    int shapeCount = shapeArray.length;
	    for (int i = 999; i < shapeCount; i += 1000) {
	        Shape currentShape = shapeArray[i];
	        String valueLabel;
	   
	        switch (comparisonType) {
	            case 'h':
	                valueLabel = "Height";
	                System.out.println("Sorted value at index " + i + ": " + valueLabel + ": " + currentShape.getHeight());
	                break;
	            case 'v':
	                valueLabel = "Volume";
	                System.out.println("Sorted value at index " + i + ": " + valueLabel + ": " + currentShape.calcVolume());
	                break;
	            case 'a':
	                valueLabel = "Base Area";
	                System.out.println("Sorted value at index " + i + ": " + valueLabel + ": " + currentShape.calcBaseArea());
	                break;
	            default:
	                valueLabel = "Value";
	                System.out.println("Sorted value at index " + i + ": " + valueLabel + ": " + currentShape);
	                break;
	        }
	    }


	    // Print the last sorted value
	    Shape lastShape = shapeArray[shapeCount - 1];
	    System.out.println("Last sorted value: " + lastShape);
	    switch (comparisonType) {
	        case 'h':
	            System.out.println("Height: " + lastShape.getHeight());
	            break;
	        case 'v':
	            System.out.println("Volume: " + lastShape.calcVolume());
	            break;
	        case 'a':
	            System.out.println("Base Area: " + lastShape.calcBaseArea());
	            break;
	        default:
	            break;
	    }
	    
}

	private static String extractFileName(String fileNameArg) {
	    // Remove the '-f' prefix
	    String fileName = fileNameArg.substring(2).trim();

	    // Check if the file name is enclosed in quotes
	    if (fileName.startsWith("\"") && fileName.endsWith("\"")) {
	        // Remove the quotes
	        fileName = fileName.substring(1, fileName.length() - 1);
	    }


	    return fileName;
	}

}