package IFaceOnlineClass;

public class MobilePhone implements Radio, GPS {

    private String make;
    private String model;

    public MobilePhone(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public void getCoordinates() {

    }

    @Override
    public void startRadio() {

    }

    @Override
    public void stopRadio() {

    }
}
