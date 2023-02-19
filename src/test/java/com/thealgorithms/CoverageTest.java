package com.thealgorithms;

import java.util.ArrayList;
import java.util.Arrays;

import com.thealgorithms.datastructures.trees.BinaryTree;
import com.thealgorithms.maths.LongDivision;

public class CoverageTest {

    public static void testBinaryTree1(){
        BinaryTree t = new BinaryTree();
        t.put(3);
        t.put(5);
        t.put(7);
        t.put(9);
        t.put(12);
        
    
        assert(t.find(5).getData() == 5);
        assert(t.find(7).getData() == 7);
        t.getCoverage();
    }

    public static void testBinaryTree2(){
        BinaryTree t = new BinaryTree();
        t.put(3);
        t.put(5);
        t.put(7);
        t.put(9);
        t.put(12);
        t.remove(3);
        t.remove(5);
        t.remove(7);
        
    
        assert(t.getRoot().getData() == 9);
        t.getCoverage();
    }

    public static void testBinaryTree3(){
        BinaryTree t = new BinaryTree();
        t.put(3);
        t.put(5);
        t.put(7);
        t.put(9);
        t.put(12);
        t.remove(3);
        t.remove(5);
        t.remove(7);
        t.bfs(t.findSuccessor(t.getRoot()));
        t.preOrder(t.getRoot());
        t.postOrder(t.getRoot());
        t.inOrder(t.getRoot());
        
    
        assert(t.getRoot().getData() == 9);
        t.getCoverage();
    }


    public static void main(String[] args) {

        System.out.println("\n===== BinaryTree coverage test 1 =====\n");
        CoverageTest.testBinaryTree1();

        System.out.println("\n===== BinaryTree coverage test 2 =====\n");
        CoverageTest.testBinaryTree2();

        System.out.println("\n===== BinaryTree coverage test 3 =====\n");
        CoverageTest.testBinaryTree3();


        System.out.println("\n===== LongDivision coverage test =====\n");
        LongDivision l = new LongDivision();
        l.divide(10, 3);

    }


}

