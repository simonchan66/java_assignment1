package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
/**
 * ShapeFactory.java
 *
 * Class Definition: Represents a class for creating shapes based on input data from a file.
 */
public class ShapeFactory {
    /**
     * Creates a list of shapes based on the input data from the specified file.
     * 
     * Precondition: The input data file exists.
	 * 
	 * Postcondition: The shape object list is created 
	 * 
     * @param fileName the name of the file containing the input data
     * @return a list of created shape objects
     */
    public static List<Object> createShapes(String fileName) {
        List<Object> shapes = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Skip the first line (number of rows indicator)
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by space
                String[] tokens = line.split(" ");
                String shapeClassName = tokens[0];
                
                // Get the class object using reflection
                Class<?> shapeClass = Class.forName("shapes." + shapeClassName);
                
                // Get the constructor of the class
                Constructor<?> constructor;
                constructor = shapeClass.getConstructor(double.class, double.class);
                
                // Create a new instance of the shape object using the constructor and the provided parameters
                Object shape = constructor.newInstance(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                
                // Add the created shape object to the list of shapes
                shapes.add(shape);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return shapes;
    }
}
