package com.company;

import java.*;
import java.util.ArrayList;
import java.util.Vector;
import com.company.Node;

public class Main {

    public static void main(String[] args) {
        ListArray<Integer> integerList = new ListArray<Integer>();
        integerList.add(10);
        integerList.add(21);
        integerList.add(1);
        integerList.add(2);
        integerList.add(0);
        integerList.add(9);
        integerList.add(-33);
        for(int i = 0; i < integerList.size(); i++){
            System.out.print(integerList.getAt(i)+" ");
        }
        integerList.sort(false);

//        integerList.removeLast();
//        integerList.removeLast();
//        integerList.removeLast();
//        integerList.removeLast();
//        integerList.removeLast();

        System.out.println();
        for(int i = 0; i < integerList.size(); i++){
            System.out.print(integerList.getAt(i)+" ");
        }
    }
}
