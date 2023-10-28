package IFaceOnlineClass;

    public class Car3 extends Car2 {
    public Car3(String regNo) {
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
        System.out.println("I am an electrical car!");
        }

}
