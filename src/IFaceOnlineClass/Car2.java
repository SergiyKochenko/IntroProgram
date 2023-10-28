package IFaceOnlineClass;

public abstract class Car2 implements Vehicle2 {

    private String regNo;

    public String getRegNo() {

        return regNo;
    }

    public void setRegNo(String regNo) {

        this.regNo = regNo;
    }

    public Car2(String regNo) {

        this.regNo = regNo;
    }

    public String toString(){

        return String.format("\n\tCar2 with reg no %s", regNo);
    }
}
