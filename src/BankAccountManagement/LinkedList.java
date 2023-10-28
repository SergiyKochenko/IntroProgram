package BankAccountManagement;

public class LinkedList {
    private Node head;

    public void add(BankAccount account) {
        Node newNode = new Node(account);
        newNode.next = head;
        head = newNode;
    }

    public void remove(String accountNumber) {
        if (head == null) {
            return;
        }

        if (head.data.getAccountNumber().equals(accountNumber)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.getAccountNumber().equals(accountNumber)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public BankAccount search(String accountNumber) {
        Node current = head;
        while (current != null) {
            if (current.data.getAccountNumber().equals(accountNumber)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void displayAccounts() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
