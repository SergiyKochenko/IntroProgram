package BankAccountManagement;

public class Node {
    public BankAccount data;
    public Node next;

    public Node(BankAccount data) {
        this.data = data;
        this.next = null;
    }
}
