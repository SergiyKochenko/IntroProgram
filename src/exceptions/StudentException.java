package exceptions;

public class StudentException extends Exception {
    private  String msg;

    public StudentException(String msg) {
        this.msg = msg;
    }

    public StudentException() {
        this.msg = "Error in Student Class";
    }
    public String toString(){
        return String.format("\n\tException: %s", msg);
    }
}
