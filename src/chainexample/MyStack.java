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
public class MyStack {
    Object[] data=new Object[100];
    int top=0;
    
    public void push(Object o) {
        if (top>=data.length) return;
        data[top]=o;
        top++;
    }
    public Object pop(){
        if (top==0) return null;
        top--;
        return data[top];
    }
    public int size(){
        return top;
    }
    public Object peek() {
        if (top==0) return null;
        return data[top-1];
    }
    
    public boolean isFull() {
        return top>=data.length;
    }
    
    public boolean isEmpty() {
        return top<=0;
    }
    
    
}
