package com.company;

import java.util.Comparator;
import java.util.Vector;

public class Node<T extends Comparable<T>> {
    private Vector<T> arr;
    private final int size = 10;
    private int count;
    private Node<T> next;

    public Node() {
        arr = new Vector<T>();
        next = null;
    }


    public void setNext(Node<T> _next) {
        next = _next;
    }

    public Node<T> getNext(){
        return next;
    }

    public void deleteNext(){
        //Добавить проверку
        next=null;
        return;
    }

    public T add(T value) throws ArrayStoreException {
        if(arr.size()==size) throw new ArrayStoreException();
        arr.add(value);
        return value;
    }

    public T getAt(int index) throws ArrayIndexOutOfBoundsException {
        return arr.get(index);
    }

    public T setAt(T value, int index) throws ArrayIndexOutOfBoundsException {
        arr.setElementAt(value, index);
        return value;
    }

    public T deleteAt(int index) throws ArrayIndexOutOfBoundsException {
        return arr.remove(index);
    }

    public void sort(boolean desc) {
        for(int i=0; i<arr.size(); i++){
            int ptr=i;
            for(int j=i+1; j<arr.size(); j++){
                if(desc){
                    if(arr.elementAt(ptr).compareTo(arr.elementAt(j))>0){
                        ptr=j;
                    }
                }
                else
                    if(arr.elementAt(ptr).compareTo(arr.elementAt(j))<0){
                        ptr=j;
                    }
            }
            T temp=arr.get(i);
            arr.set(i, arr.get(ptr));
            arr.set(ptr, temp);
        }
    }

}