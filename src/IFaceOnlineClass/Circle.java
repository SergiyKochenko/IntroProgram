package IFaceOnlineClass;

public class Circle extends Shape implements Comparable <Circle> {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double dia(){
        return radius * 2;
    }

    public double circ(){
        return Math.PI * dia();
    }

    public double area(){
        return Math.PI * radius * radius;
    }

    public String toString(){
        return String.format("\n\tCircle with radius %5.2f, dia %5.2f, cir %5.2f, area %5.2f",
        radius, dia(), circ(), area());
    }


    @Override
    public int compareTo(Circle o) {
        if (getRadius() > o.getRadius())
            return  1;
        else if (getRadius() < o.getRadius())
            return  -1;
        else
            return 0;
    }

    public static Comparable findMax(Comparable cir1, Comparable cir2) {
        if (cir1.compareTo(cir2) > 0)
            return cir1;
        else
            return cir2;
    }
}
