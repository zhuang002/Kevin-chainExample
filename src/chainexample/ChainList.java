/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainexample;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author zhuan
 */
public class ChainList<T> implements List {
    Node<T> head=null;

    @Override
    public int size() {
        Node<T> current=head;
        int size=0;
        while (current!=null) {
            current=current.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T[] toArray() {
        T[] ret=(T[])new Object[this.size()];
        int i=0;
        Node current=head;
        if (current!=null) {
            ret[i]=(T)current.getValue();
            i++;
            current=current.getNext();
        }
        return ret;
    }

    @Override
    public boolean contains(Object o) {
        Node current=head;
        
        while (head!=null) {
            if (head.getValue().equals(o))
                return true;
            else current=current.getNext();
        }
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return this.toArray();
    }

    @Override
    public boolean add(Object e) {
        Node tail=getTail();
        
        Node node=new Node();
        node.setValue(e);
        node.setPrevious(tail);
        if (tail==null) {
            head=node;
        } else
            tail.setNext(node);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node node=getNodeByElement(o);
        if (node==null) return false;
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (!c.stream().noneMatch((e) -> (!this.contains(e)))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object e:c) {
            this.add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (index<0) return false;
        if (index>this.size()-1) {
            this.addAll(c);
            return true;
        }
        Node node=head;
        for (int i=0;i<index-1;i++) {
            node=node.getNext();
        }
        node.getPrevious().setNext(null);
        this.addAll(c);
        Node tail=this.getTail();
        tail.setNext(node);
        node.setPrevious(tail);
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object e:c) {
            this.remove(e);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        for (Object e:c) {
            if (!this.contains(e)) {
                this.add(e);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        head=null;
    }

    @Override
    public Object get(int index) {
        if (index<0 || index>this.size()-1) return false;
        Node node=this.head;
        for (int i=0;i<index-1;i++) {
            node=node.getNext();
        }
        return node.getValue();
    }

    @Override
    public Object set(int index, Object element) {
        if (index<0 || index>this.size()-1) return null;
        Node node=this.head;
        for (int i=0;i<index-1;i++) {
            node=node.getNext();
        }
        node.setValue(element);
        return element;
    }

    @Override
    public void add(int index, Object element) {
        if (index<0) return;
        if (index>this.size()-1) this.add(element);
        Node node=head;
        for (int i=0;i<index-1;i++) {
            node=node.getNext();
        }
        Node newNode=new Node();
        newNode.setValue(element);
        newNode.setPrevious(node);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        newNode.getNext().setPrevious(newNode);
    }

    @Override
    public Object remove(int index) {
        if (index<0 || index>this.size()-1) return null;
        Node current=this.head;
        for (int i=0;i<index-1;i++) {
            current=current.getNext();
        }
        Node prev=current.getPrevious();
        Node next=current.getNext();
        if (prev!=null)
            prev.setNext(next);
        if (next!=null)
            next.setPrevious(prev);
        return current;
    }

    @Override
    public int indexOf(Object o) {
        Node current=this.head;
        int i=0;
        while (current!=null && !current.getValue().equals(o)) {
            current=current.getNext();
            i++;
        }
        if (current==null) return -1;
        else return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node current=this.getTail();
        int i=this.size()-1;
        while (current!=null && !current.getValue().equals(o)){
            current=current.getPrevious();
            i--;
        }
        if (current==null) return -1;
        else return i;
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if (fromIndex<0 || fromIndex>this.size()-1) return null;
        if (toIndex<0 || toIndex>this.size()-1) return null;
        if (fromIndex>toIndex) return null;
        Node current=this.head;
        ChainList ret=new ChainList();
        for (int i=0;i<fromIndex-1;i++)
            current=current.getNext();
        
        
        for (int i=fromIndex;i<=toIndex;i++) {
            ret.add(current.getValue());
        }
        return ret;

    }

    public Node getTail() {
        Node current=this.head;
        if (current==null) return null;
        while (current.getNext()!=null)
            current=current.getNext();
        return current;
    }

    public void setHead(Node node) {
        this.head=node;
    }

    private Node getNodeByElement(Object o) {
        Node current=this.head;
        while (current!=null && !current.getValue().equals(o))
            current=current.getNext();
        return current;
    }

    
}
   