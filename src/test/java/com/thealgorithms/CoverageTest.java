package com.thealgorithms;

import java.util.ArrayList;
import java.util.Arrays;

import com.thealgorithms.datastructures.trees.BinaryTree;
import com.thealgorithms.maths.LongDivision;

public class CoverageTest {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.put(3);
        t.put(5);
        t.find(3);
        t.find(10);

        System.out.println("\n===== BinaryTree coverage test =====\n");
        t.getCoverage();


        System.out.println("\n===== LongDivision coverage test =====\n");
        LongDivision l = new LongDivision();
        l.divide(10, 3);

    }


}

