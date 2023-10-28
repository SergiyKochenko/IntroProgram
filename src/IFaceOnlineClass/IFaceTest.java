package IFaceOnlineClass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class IFaceTest {
    public static void main(String[] args) {

        Car myCar = new Car("LIW 1176");
        System.out.println(myCar.toString());
        myCar.start();
        myCar.stop();
        myCar.startRadio();
        myCar.stopRadio();

        Truck myTruck = new Truck(3);
        System.out.println(myTruck.toString());
        myTruck.start();
        myTruck.stop();
        myTruck.startRadio();
        myTruck.stopRadio();

        Car3 myCar3 = new Car3("LIW 1177");
        System.out.println(myCar3);
        myCar3.powerSource();

        Car4 myCar4 = new Car4("LIW 1178");
        System.out.println(myCar4);
        myCar4.powerSource();


      /*  ArrayList<Circle> myCirs = new ArrayList<Circle>();
        myCirs.add(new Circle(10.00));
        myCirs.add(new Circle(5.00));
        myCirs.add(new Circle(12.00));
        myCirs.add(new Circle(20.00));
        myCirs.add(new Circle(2.00));

        for (int i = 0; i < myCirs.size(); i++)
            System.out.print(myCirs.get(i).toString());

        Collections.sort(myCirs);

        for (Circle cir : myCirs)
            System.out.print(cir);

        Squere mySquere1 = new Squere(5);
        Squere mySquere2 = new Squere(5);

        if (mySquere1.compareTo(mySquere2) == 1)
            System.out.println("\n\tSquare 1 is larger than Square 2");
        else if (mySquere1.compareTo(mySquere2) == -1)
            System.out.println("\n\tSquare 2 is larger than Square 1");
        else
            System.out.println("\n\tSquare 1 is equal to Square 2");

        Circle myCircle1 = new Circle(15);
        Circle myCircle2 = new Circle(5);

        Comparable myCircle3;

        myCircle3 = Circle.findMax(myCircle1, myCircle2);
        System.out.printf("\n\tCircle returned:  " + myCircle3.toString());*/


    }
}
