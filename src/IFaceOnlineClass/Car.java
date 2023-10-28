package IFaceOnlineClass;

public class Car implements Vehicle, Radio, GPS {

    private String regNo;

    public String getRegNo() {

        return regNo;
    }

    public void setRegNo(String regNo) {

        this.regNo = regNo;
    }

    public Car(String regNo) {

        this.regNo = regNo;
    }

    @Override
    public void start() {
        System.out.println("Car starting...");

    }

    @Override
    public void stop() {
        System.out.println("Car stopping...");

    }

    @Override
    public void blowHorn() {
        System.out.println("Car horn blowing...");

    }


    public String toString(){

        return String.format("\n\tCar with reg no %s", regNo);
    }

    @Override
    public void startRadio() {

        System.out.println("Car radio starting...");
    }

    @Override
    public void stopRadio() {

        System.out.println("Car radio stopping...");
    }

    @Override
    public void getCoordinates() {

    }
}
