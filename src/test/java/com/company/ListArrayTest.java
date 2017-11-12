package com.company;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class ListArrayTest {

    @Test
    void add() {
        ListArray<Integer> l = new ListArray<>(3);
        l.add(4);
        assertEquals(1, l.size());
        assertEquals(4, (int)l.getLast());
        l.add(1);
        l.add(2);
        l.add(3);
        assertEquals(4, l.size());
        assertEquals(3, (int)l.getLast());
    }

    @Test
    void removeLast() {
        ListArray<Integer> l = new ListArray<>(3);
        l.add(4);
        l.removeLast();
        assertEquals(0, l.size());
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.removeLast();
        assertEquals(3, l.size());
        assertEquals(3, (int)l.getLast());
    }

    @Test
    public void removeLastFromEmpty() {
        boolean exceptionThrown = false;
        try {
            ListArray<Integer> l = new ListArray<>(3);
            l.add(4);
            l.removeLast();
            l.removeLast();
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertEquals(true, exceptionThrown);
    }

    @Test
    void getAt() {

    }

    @Test
    void setAt() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void sort() {
    }

}