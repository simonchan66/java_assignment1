package shapes;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    public enum ComparisonType {
        VOLUME,
        BASE_AREA
    }

    private ComparisonType comparisonType;

    public ShapeComparator(ComparisonType comparisonType) {
        this.comparisonType = comparisonType;
    }

    @Override
    public int compare(Shape o1, Shape o2) {
        switch (comparisonType) {
            case VOLUME:
                return Double.compare(o1.calcVolume(), o2.calcVolume());
            case BASE_AREA:
                return Double.compare(o1.calcBaseArea(), o2.calcBaseArea());
            default:
                throw new IllegalArgumentException("Invalid comparison type");
        }
    }
}
