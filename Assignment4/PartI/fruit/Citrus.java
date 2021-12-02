package fruit;

public class Citrus extends Fruit {
    private String taste;

    public Citrus() {
        super();
    }

    public Citrus(String taste, String color, boolean rotten) {
        super(color, rotten);
        this.taste = taste;
    }

    public String getTaste() {
        return this.taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public boolean equals(Object o) {
        if (super.equals(o)) {
            if (o instanceof Citrus) {
                Citrus c = (Citrus) o;
                return c.taste == this.taste;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Citrus[" + super.toString() + ", taste = " + this.taste + "]";
    }
}
