/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainexample;

import java.util.ArrayList;

/**
 *
 * @author zhuan
 */
public class MyStack2 {
    ArrayList data=new ArrayList();
    
    public void push(Object o) {
        data.add(0,o);
    }
    public Object pop(){
        return data.remove(0);
    }
    public int size(){
        return data.size();
    }
    public Object peek() {
        return data.get(data.size()-1);
    }
    
    public boolean isFull() {
        return false;
    }
    
    public boolean isEmpty() {
        return data.size()==0;
    }
}
