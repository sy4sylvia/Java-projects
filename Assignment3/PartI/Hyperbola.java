public class Hyperbola {
	private static int nextId;
	private int id;
	private double vertex = 1.0;
	private double covertex = 1.0;

	public Hyperbola() {
	    this.id = nextId;
	    nextId++;
    }

    public Hyperbola(double vertex, double covertex) {
	    this();
	    this.vertex = vertex;
	    this.covertex = covertex;
    }

    public double getVertex() {
        return this.vertex;
    }
    public void setVertex(double vertex) {
	    this.vertex = vertex;
    }

    public double getCovertex() {
        return this.covertex;
    }
    public void setCovertex(double covertex) {
        this.covertex = covertex;
    }

    public double getFocusSquared() {
	    double c = this.vertex * this.vertex + this.covertex * this.covertex;
	    return c;
    }

    public double getId() {
	    return this.id;
    }

}
