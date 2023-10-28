package IFaceOnlineClass;

public class Circle3 implements Circle2 {
    private double radius;

    public double area(){
        return radius * radius * myPI;
    }
}
