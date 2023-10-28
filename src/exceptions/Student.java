package exceptions;

public class Student {
    private String name;
    private int mark;

    public Student(String name, int mark) throws StudentException{
        if (name.length() < 2 || name.length() > 20)
            throw new StudentException("\n\tName should be between 2 & 20 chars in length!");
        else
            this.name = name;

        if (mark < 0 || mark > 100)
            throw new StudentException("\n\tMark should be between 0 and 100!");
        else
            this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) throws StudentException {
        if (mark < 0 || mark > 100)
            throw new StudentException("\n\tMark should be between 0 and 100!");
        else
            this.mark = mark;
    }

    public String toString(){
        return  String.format("\n\tName: %s \n\tMark: %d", name, mark);
    }

}
