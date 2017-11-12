package com.company;

import java.util.Vector;

public class Node<T extends Comparable<T>> {
    private Vector<T> arr;
    private final int size;
    private Node<T> next;
    private Node<T> prev;

    public Node() {
        this(10);
    }

    public Node(int nodeSize) {
        arr = new Vector<T>();
        next = null;
        size = nodeSize;
    }


    public void setNext(Node<T> _next) {
        next = _next;
    }

    public Node<T> getNext(){
        return next;
    }

    public T add(T value) throws ArrayStoreException {
        if(arr.size() == size) throw new ArrayStoreException();
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

    public void removeLast() throws ArrayIndexOutOfBoundsException {
        removeAt(size() - 1);
    }

    public T removeAt(int index) throws ArrayIndexOutOfBoundsException {
        return arr.remove(index);
    }

    public int size() {
        return arr.size();
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}