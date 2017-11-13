package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class ListArray<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;
    private final int nodeSize;
    private int size = 0;

    public ListArray() {
        this(10);
    }

    public ListArray(int _nodeSize) {
        nodeSize = _nodeSize;
        head = new Node<T>(nodeSize);
        tail = head;
    }

    public void fill(T[] values) {
        for (T val : values) {
            this.add(val);
        }
    }

    public void add(T value) {
        try {
            tail.add(value);
            size++;
        } catch (ArrayStoreException e) {
            Node<T> newNode = new Node<T>(nodeSize);
            connectNodes(tail, newNode);
            tail = newNode;
            this.add(value);
        }
    }

    public void removeLast() throws ArrayIndexOutOfBoundsException {
        try {
            tail.removeLast();
            size--;
        } catch (ArrayIndexOutOfBoundsException e) {
            Node<T> newTail = tail.getPrev();
            if (newTail == null) {
                throw e;
            }
            newTail.setNext(null);
            tail.setPrev(null);
            tail = newTail;
            this.removeLast();
        }
        if (tail.size() == 0 && tail.getPrev() != null) {
            Node<T> newTail = tail.getPrev();
            newTail.setNext(null);
            tail = newTail;
        }
    }

    public T getAt(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int nodeNumber = index / nodeSize;
        Node<T> node = head;
        for (int i = 0; i < nodeNumber; ++i) {
            node = node.getNext();
        }
        return node.getAt(index % nodeSize);
    }

    public T getLast() throws ArrayIndexOutOfBoundsException {
        return getAt(size() - 1);
    }

    public void setAt(T value, int index) throws ArrayIndexOutOfBoundsException {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int nodeNumber = index / nodeSize;
        Node<T> node = head;
        for (int i = 0; i < nodeNumber; ++i) {
            node = node.getNext();
        }
        node.setAt(value, index % nodeSize);
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = new Node<>(nodeSize);
        tail = head;
        size = 0;
    }

    public void sort(boolean desc) {
        ArrayList<T> asArr = this.toArray();
        if (desc) {
            Collections.sort(asArr, Collections.reverseOrder());
        } else {
            Collections.sort(asArr);
        }
        this.clear();
        for (T val : asArr) {
            this.add(val);
        }
    }

    void connectNodes(Node<T> left, Node<T> right) {
        left.setNext(right);
        right.setPrev(left);
    }

    ArrayList<T> toArray() {
        ArrayList<T> allValues = new ArrayList<T>();
        Node<T> node = head;
        while (node != null) {
            for (int i = 0; i < node.size(); ++i) {
                allValues.add(node.getAt(i));
            }
            node = node.getNext();
        }
        return allValues;
    }
}
