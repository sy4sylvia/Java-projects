package question9;

public abstract class GeometricObject {
    private String color;
    private boolean filled;
    private java.util.Date dateCreated;

    GeometricObject() {
        this.color = "white";
        this.filled = false;
        dateCreated = new java.util.Date();

    }

    GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }
}
