package com.company;

import java.*;
import java.util.Vector;
import com.company.Node;

public class Main {

    public static void main(String[] args) {
        Node<Integer> integerNode=new Node<Integer>();
        integerNode.add(10);
        integerNode.add(21);
        integerNode.add(1);
        integerNode.add(2);
        integerNode.add(0);
        integerNode.add(9);
        integerNode.add(-33);
        for(int i=0; i<7; i++){
            System.out.print(integerNode.getAt(i)+" ");
        }
        integerNode.sort(true);
        System.out.println();
        for(int i=0; i<7; i++){
            System.out.print(integerNode.getAt(i)+" ");
        }
    }
}
