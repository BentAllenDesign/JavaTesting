package stack;

import java.util.EmptyStackException;

public class Stack {

    class Node { Object data; Node next; }
    private Node current;

    public boolean isEmpty() {
        return current == null;
    }

    public void push(Object o) {
        if(o == null) throw new NullPointerException("Tried to push null Object onto the stack");
        Node newNode = new Node();
        newNode.next = current;
        newNode.data = o;
        current = newNode;
    }

    public Object pop() {
        if(current == null) throw new EmptyStackException();
        Object temp = current.data;
        current = current.next;
        return temp;
    }

    public Object peek() {
        if(current != null) return current.data;
        throw new EmptyStackException();
    }

    public boolean contains(Object o) {
        Node n = current;
        while(n != null) {
            if(n.data == o) return true;
            n = n.next;
        }
        return false;
    }

    public int size() {
        Node n = current;
        int count = 0;
        while(n != null) {
            count++;
            n = n.next;
        }
        return count;
    }
}
