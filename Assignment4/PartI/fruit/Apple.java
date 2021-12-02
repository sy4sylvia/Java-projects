package fruit;

import java.lang.invoke.StringConcatException;

public class Apple extends Fruit {
    private String taste;
    private String texture;

    public Apple() {
        super();
    }

    public Apple(String taste, String texture, String color, boolean rotten) {
        super(color, rotten);
        this.taste = taste;
        this.texture = texture;
    }

    public String getTaste() {
        return this.taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTexture() {
        return this.texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }


    public boolean equals(Object o) {
        if (super.equals(o)) {
            if (o instanceof Apple) {
                Apple a = (Apple) o;
                return (a.taste == this.taste) && (a.texture == this.texture);
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Apple[" + super.toString() + ", taste = " + this.taste + ", texture = " + this.texture + "]";
    }
}
