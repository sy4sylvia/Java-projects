package fruit;

public class Lemon extends Citrus {
    private int sourness;

    public Lemon() {
        super();
        this.setColor("yellow");
    }

    public Lemon(int sourness, String taste, boolean rotten) {
        super(taste, "yellow", rotten);
        this.sourness = sourness;
    }

    public int getSourness() {
        return this.sourness;
    }

    public void setSourness(int sourness) {
        this.sourness = sourness;
    }

    public boolean equals(Object o) {
        if (o instanceof Lemon) {
            Lemon l = (Lemon) o;
            return l.sourness == this.sourness;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lemon[" + super.toString() + ", sourness = " + this.sourness + "]";
    }
}
