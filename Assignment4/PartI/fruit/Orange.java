package fruit;

public class Orange extends Citrus {
    private String type;

    public Orange() {
        super();
        this.setColor("orange");
    }

    public Orange(String type, String taste, boolean rotten) {
        super(taste, "orange", rotten);
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean equals(Object o) {
        if (super.equals(o)) {
            if (o instanceof Orange) {
                Orange ora = (Orange) o;
                return ora.type == this.type;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Orange[" + super.toString() + ", type = " + this.type + "]";
    }
}
