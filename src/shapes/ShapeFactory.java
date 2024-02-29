package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ShapeFactory {

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
