package fruit;

public class Fruit {
    private String color;
    private boolean rotten;
    private static int nextId;
    private int id;

    public Fruit() {
        this.id = Fruit.nextId;
        Fruit.nextId++;
    }

    public Fruit(String color, boolean rotten) {
        this();
        this.color = color;
        this.rotten = rotten;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRotten() {
        return this.rotten;
    }

    public void setRotten(boolean rotten) {
        this.rotten = rotten;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Fruit[color = " + this.color + ", rotten = " + this.rotten + ", id = " + this.id + "]";
    }


    public boolean equals(Object o) {
        if (o instanceof Fruit) {
            Fruit f = (Fruit) o;
            return (f.color == this.color) && (f.rotten == this.rotten);
        }
        return false;
    }
}
