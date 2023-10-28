package exceptions;

import java.util.IllegalFormatException;

public class TestExceptions {
    public static void main(String[] args) {

        try {
            Student student = new Student("John Smith", 56);
            System.out.println(student.toString());

            student.setMark(199);
        }
        catch (StudentException e){
            System.out.println(e.toString());
        }



        /*String name = "John";
    try {
        //System.out.println("\n\t" + 5.0/0.0);
        System.out.println("\n\t" + name.charAt(10));
        //System.out.printf("\n\tName: %d", name);
    }
    catch (IllegalFormatException e){
        System.out.println("\n\tFormatting is incorrect!");
    }
    catch (StringIndexOutOfBoundsException e){
        System.out.println("\n\tYou are attempting to access a char that does not exist!");
    }
    catch (Exception e){
        System.out.println("\n\tSomething went wrong!");
    }*/
    }
}
