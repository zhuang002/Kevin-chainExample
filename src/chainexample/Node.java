/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainexample;

/**
 *
 * @author zhuan
 */
public class Node<T> {
    private Node previous=null;
    private Node next=null;
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public void addNode(Node node) {
        
        Node tail=getTail();
        tail.setNext(node);
        node.setPrevious(tail);
        node.next=null;
    }

    private Node getTail() {
        Node current=this;
        while (current.next!=null) {
            current=current.getNext();
        }
        return current;
    }
    
    public void insert(Node node) {
        Node p=this.previous;
        this.previous=node;
        node.next=this;
        p.next=node;
        node.previous=p;
    }
}
