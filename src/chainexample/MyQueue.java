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
public class MyQueue {
    ChainList data=new ChainList();
    
    public void push(Object o) {
        data.add(o);
    }
    public Object pop() {
        return data.remove(0);
    }
    
    public int size() {
        return data.size();
    }
    
    public Object peek() {
        return data.get(0);
    }
    
    public boolean isFull() {
        return false;
    }
    
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
