package com.company;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class ListArrayTest {
    @Test
    public void add() {
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
    public void removeLast() {
        ListArray<Integer> l = new ListArray<>(3);
        l.add(4);
        l.removeLast();
        assertEquals(0, l.size());
        l.add(1);
        l.add(2);
        l.add(3);
        assertEquals(3, l.size());
        assertEquals(3, (int)l.getLast());
        l.add(4);
        l.removeLast();
        assertEquals(3, l.size());
        assertEquals(3, (int)l.getLast());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeLastFromEmpty() {
        ListArray<Integer> l = new ListArray<>(3);
        l.add(4);
        l.removeLast();
        l.removeLast();
    }

    @Test
    public void getAt() {
        ListArray<Integer> l = new ListArray<>(3);
        l.add(4);
        assertEquals(4, (int)l.getAt(0));
        l.add(1);
        l.add(2);
        assertEquals(4, (int)l.getAt(0));
        assertEquals(1, (int)l.getAt(1));
        assertEquals(2, (int)l.getAt(2));
        l.add(3);
        assertEquals(4, (int)l.getAt(0));
        assertEquals(1, (int)l.getAt(1));
        assertEquals(2, (int)l.getAt(2));
        assertEquals(3, (int)l.getAt(3));
    }

    @Test
    public void getAtNodeSize1() {
        ListArray<Integer> l = new ListArray<>(1);
        l.add(4);
        assertEquals(4, (int) l.getAt(0));
        l.add(1);
        l.add(2);
        assertEquals(4, (int) l.getAt(0));
        assertEquals(1, (int) l.getAt(1));
        assertEquals(2, (int) l.getAt(2));
        l.add(3);
        assertEquals(4, (int) l.getAt(0));
        assertEquals(1, (int) l.getAt(1));
        assertEquals(2, (int) l.getAt(2));
        assertEquals(3, (int) l.getAt(3));
    }

    @Test
    public void sort() {
        ListArray<Integer> integerList = new ListArray<Integer>(3);
        Integer[] arr = new Integer[]{10, 21, 1, 2, 0, 9, -33};
        integerList.fill(arr);
        integerList.sort(false);
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(l);
        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), integerList.getAt(i));
        }
    }

    @Test
    public void sort1value() {
        ListArray<Integer> integerList = new ListArray<Integer>();
        Integer[] arr = new Integer[]{10};
        integerList.fill(arr);
        integerList.sort(false);
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(l);
        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), integerList.getAt(i));
        }
    }

    @Test
    public void sortEmpty() {
        ListArray<Integer> integerList = new ListArray<Integer>();
        integerList.sort(false);
    }

    @Test
    public void sortDesc() {
        ListArray<Integer> integerList = new ListArray<Integer>(3);
        Integer[] arr = new Integer[]{10, 21, 1, 2, 0, 9, -33};
        integerList.fill(arr);
        integerList.sort(true);
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(l, Collections.reverseOrder());
        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), integerList.getAt(i));
        }
    }

    @Test
    public void sort1valueDesc() {
        ListArray<Integer> integerList = new ListArray<Integer>();
        Integer[] arr = new Integer[]{10};
        integerList.fill(arr);
        integerList.sort(true);
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(l, Collections.reverseOrder());
        for (int i = 0; i < l.size(); ++i) {
            assertEquals(l.get(i), integerList.getAt(i));
        }
    }
}