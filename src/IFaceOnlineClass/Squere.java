package IFaceOnlineClass;

public class Squere extends Shape implements Comparable <Squere> {

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Squere(double side) {
        this.side = side;
    }

    @Override
    public int compareTo(Squere o) {
        if (getSide() > o.getSide())
            return  1;
        else if (getSide() < o.getSide())
            return  -1;
        else
            return 0;
    }
}
