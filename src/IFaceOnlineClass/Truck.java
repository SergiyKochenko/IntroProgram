package IFaceOnlineClass;

public class Truck implements Vehicle, Radio {

    private int noAxles;

    public int getNoAxles() {
        return noAxles;
    }

    public void setNoAxles(int noAxles) {
        this.noAxles = noAxles;
    }

    public Truck(int noAxles) {
        this.noAxles = noAxles;
    }

    @Override
    public void start() {
        System.out.println("Truck starting...");

    }

    @Override
    public void stop() {
        System.out.println("Truck stopping...");

    }

    @Override
    public void blowHorn() {
        System.out.println("Truck horn blowing...");

    }


    public String toString(){
        return String.format("\n\tI am a truck with %d", noAxles);
    }

    @Override
    public void startRadio() {
        System.out.println("Truck radio starting...");
    }

    @Override
    public void stopRadio() {
        System.out.println("Truck radio stopping...");
    }
}
