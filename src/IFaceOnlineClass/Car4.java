package IFaceOnlineClass;

public class Car4 extends Car2 {
    public Car4(String regNo) {
        super(regNo);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void powerSource() {
        System.out.println("I am a diesel car!");
    }
}
