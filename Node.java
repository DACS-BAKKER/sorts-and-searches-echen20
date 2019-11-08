/*
Name: Ethan Chen
File Name: Node (For Linked List)
Date Started: October 23, 2019
 */

public class Node<Item> {
    public Item data;
    public Node next;

    public Node(Item data) {
        this.data = data;
    }

    public void setNext(Node n) {
        next = n;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
