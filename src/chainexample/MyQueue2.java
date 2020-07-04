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
public class MyQueue2 {
    Object[] data=new Object[100];
    int head=0;
    int tail=0;
    boolean empty=true;
    
    public void push(Object o) {
        if (this.isFull()) return;
        data[tail]=o;
        tail=(tail+1)%data.length;
        empty=false;
    }
    public Object pop() {
        if (this.isEmpty()) return null;
        Object d=data[head];
        head=(head+1)%data.length;
        if (head==tail)
            empty=true;
        return d;
    }
    
    public int size() {
        if (empty) return 0;
        return (tail+data.length-head)%data.length ;
    }
    
    public Object peek() {
        if (this.isEmpty()) return null;
        return data[head];
    }
    
    public boolean isFull() {
        return (head==tail && !empty);
    }
    
    public boolean isEmpty() {
        return empty;
    }
}
