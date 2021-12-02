package PartI;

public class Pair<E, T> {

    private E left;
    private T right;

    public Pair(){}

    public Pair(E left, T right) {
        this();
        this.left = left;
        this.right = right;
    }

    public E getLeft() {
        return left;
    }

    public void setLeft(E left) {
        this.left = left;
    }

    public T getRight() {
        return right;
    }

    public void setRight(T right) {
        this.right = right;
    }

    //test Pair()
//    public static void main(String[] args) {
//        Pair<Double, Double> p = new Pair<Double, Double>(5.5, 9.5);
//        System.out.println(p.getLeft());
//        System.out.println(p.getRight());
//    }
}
