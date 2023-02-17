package com.thealgorithms.datastructures.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This entire class is used to build a Binary Tree data structure. There is the
 * Node Class and the Tree Class, both explained below.
 */
/**
 * A binary tree is a data structure in which an element has two
 * successors(children). The left child is usually smaller than the parent, and
 * the right child is usually bigger.
 *
 * @author Unknown
 */
public class BinaryTree {

    /**
     * This class implements the nodes that will go on the Binary Tree. They
     * consist of the data in them, the node to the left, the node to the right,
     * and the parent from which they came from.
     *
     * @author Unknown
     */
    static class Node {

        /**
         * Data for the node
         */
        public int data;
        /**
         * The Node to the left of this one
         */
        public Node left;
        /**
         * The Node to the right of this one
         */
        public Node right;
        /**
         * The parent of this node
         */
        public Node parent;

        /**
         * Constructor of Node
         *
         * @param value Value to put in the node
         */
        public Node(int value) {
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    /**
     * The root of the Binary Tree
     */
    private Node root;
    public boolean[] coverageArray;

    /**
     * Constructor
     */
    public BinaryTree() {
        root = null;

        this.coverageArray = new boolean[30];
        for(int i = 0; i < coverageArray.length; i++){
            coverageArray[i] = false;
        }
    }

    /**
     * Parameterized Constructor
     */
    public BinaryTree(Node root) {
        this.root = root;
    }

    public void getCoverage(){
        System.out.println(Arrays.toString(this.coverageArray));

        int counter = 0;
        for(int i = 0; i<this.coverageArray.length; i++){
            if(this.coverageArray[i]){
                counter++;
            }
        }

        double percentage = (double) counter / this.coverageArray.length;
        percentage = percentage * 100;

        System.out.println("PERCENTAGE COVERAGE: " + percentage);
    }

    /**
     * Method to find a Node with a certain value
     *
     * @param key Value being looked for
     * @return The node if it finds it, otherwise returns the parent
     */
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            coverageArray[0] = true; //===== branch ID 0 reached =========
            if (key < current.data) {
                coverageArray[1] = true; //===== branch ID 1 reached =========
                if (current.left == null) {
                    coverageArray[2] = true; //===== branch ID 2 reached ========
                    return current; // The key isn't exist, returns the parent
                }
                current = current.left;
            } else if (key > current.data) {
                coverageArray[3] = true; //===== branch ID 3 reached ==========
                if (current.right == null) {
                    coverageArray[4] = true; //===== branch ID 4 reached ==============
                    return current;
                }
                current = current.right;
            } else { // If you find the value return it
                return current;
            }
        }
        return null;
    }

    /**
     * Inserts certain value into the Binary Tree
     *
     * @param value Value to be inserted
     */
    public void put(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            coverageArray[5] = true; //===== branch ID 5 reached ========
            root = newNode;
        } else {
            // This will return the soon to be parent of the value you're inserting
            Node parent = find(value);

            // This if/else assigns the new node to be either the left or right child of the parent
            if (value < parent.data) {
                coverageArray[6] = true; //===== branch ID 6 reached ========
                parent.left = newNode;
                parent.left.parent = parent;
                return;
            } else {
                parent.right = newNode;
                parent.right.parent = parent;
                return;
            }
        }
    }

    /**
     * Deletes a given value from the Binary Tree
     *
     * @param value Value to be deleted
     * @return If the value was deleted
     */
    public boolean remove(int value) {
        // temp is the node to be deleted
        Node temp = find(value);

        // If the value doesn't exist
        if (temp.data != value) {
            coverageArray[7] = true; //===== branch ID 7 reached ========
            return false;
        }

        // No children
        if (temp.right == null && temp.left == null) {
            coverageArray[8] = true; //===== branch ID 8 reached ========
            if (temp == root) {
                coverageArray[9] = true; //===== branch ID 9 reached ========
                root = null;
            } // This if/else assigns the new node to be either the left or right child of the parent
            else if (temp.parent.data < temp.data) {
                coverageArray[10] = true; //===== branch ID 10 reached ========
                temp.parent.right = null;
            } else {
                temp.parent.left = null;
            }
            return true;
        } // Two children
        else if (temp.left != null && temp.right != null) {
            coverageArray[11] = true; //===== branch ID 11 reached ========
            Node successor = findSuccessor(temp);

            // The left tree of temp is made the left tree of the successor
            successor.left = temp.left;
            successor.left.parent = successor;

            // If the successor has a right child, the child's grandparent is it's new parent
            if (successor.parent != temp) {
                coverageArray[12] = true; //===== branch ID 12 reached ========
                if (successor.right != null) {
                    coverageArray[13] = true; //===== branch ID 13 reached ========
                    successor.right.parent = successor.parent;
                    successor.parent.left = successor.right;
                    successor.right = temp.right;
                    successor.right.parent = successor;
                } else {
                    successor.parent.left = null;
                    successor.right = temp.right;
                    successor.right.parent = successor;
                }
            }

            if (temp == root) {
                coverageArray[14] = true; //===== branch ID 14 reached ========
                successor.parent = null;
                root = successor;
                return true;
            } // If you're not deleting the root
            else {
                successor.parent = temp.parent;

                // This if/else assigns the new node to be either the left or right child of the parent
                if (temp.parent.data < temp.data) {
                    coverageArray[15] = true; //===== branch ID 15 reached ========
                    temp.parent.right = successor;
                } else {
                    temp.parent.left = successor;
                }
                return true;
            }
        } // One child
        else {
            // If it has a right child
            if (temp.right != null) {
                coverageArray[16] = true; //===== branch ID 16 reached ========
                if (temp == root) {
                    coverageArray[17] = true; //===== branch ID 17 reached ========
                    root = temp.right;
                    return true;
                }

                temp.right.parent = temp.parent;

                // Assigns temp to left or right child
                if (temp.data < temp.parent.data) {
                    coverageArray[18] = true; //===== branch ID 18 reached ========
                    temp.parent.left = temp.right;
                } else {
                    temp.parent.right = temp.right;
                }
                return true;
            } // If it has a left child
            else {
                if (temp == root) {
                    coverageArray[19] = true; //===== branch ID 19 reached ========
                    root = temp.left;
                    return true;
                }

                temp.left.parent = temp.parent;

                // Assigns temp to left or right side
                if (temp.data < temp.parent.data) {
                    coverageArray[20] = true; //===== branch ID 20 reached ========
                    temp.parent.left = temp.left;
                } else {
                    temp.parent.right = temp.left;
                }
                return true;
            }
        }
    }

    /**
     * This method finds the Successor to the Node given. Move right once and go
     * left down the tree as far as you can
     *
     * @param n Node that you want to find the Successor of
     * @return The Successor of the node
     */
    public Node findSuccessor(Node n) {
        if (n.right == null) {
            coverageArray[21] = true; //===== branch ID 21 reached ========
            return n;
        }
        Node current = n.right;
        Node parent = n.right;
        while (current != null) {
            coverageArray[22] = true; //===== branch ID 22 reached ========
            parent = current;
            current = current.left;
        }
        return parent;
    }

    /**
     * Returns the root of the Binary Tree
     *
     * @return the root of the Binary Tree
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Prints leftChild - root - rightChild This is the equivalent of a depth
     * first search
     *
     * @param localRoot The local root of the binary tree
     */
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            coverageArray[23] = true; //===== branch ID 23 reached ========
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    /**
     * Prints root - leftChild - rightChild
     *
     * @param localRoot The local root of the binary tree
     */
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            coverageArray[24] = true; //===== branch ID 24 reached ========
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    /**
     * Prints rightChild - leftChild - root
     *
     * @param localRoot The local root of the binary tree
     */
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            coverageArray[25] = true; //===== branch ID 25 reached ========
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }

    /**
     * Prints the tree in a breadth first search order This is similar to
     * pre-order traversal, but instead of being implemented with a stack (or
     * recursion), it is implemented with a queue
     *
     * @param localRoot The local root of the binary tree
     */
    public void bfs(Node localRoot) {
        // Create a queue for the order of the nodes
        Queue<Node> queue = new LinkedList<Node>();

        // If the give root is null, then we don't add to the queue
        // and won't do anything
        if (localRoot != null) {
            coverageArray[26] = true; //===== branch ID 26 reached ========
            queue.add(localRoot);
        }

        // Continue until the queue is empty
        while (!queue.isEmpty()) {
            coverageArray[27] = true; //===== branch ID 27 reached ========
            // Get the next node on the queue to visit
            localRoot = queue.remove();

            // Print the data from the node we are visiting
            System.out.print(localRoot.data + " ");

            // Add the children to the queue if not null
            if (localRoot.right != null) {
                coverageArray[28] = true; //===== branch ID 28 reached ========
                queue.add(localRoot.right);
            }
            if (localRoot.left != null) {
                coverageArray[29] = true; //===== branch ID 29 reached ========
                queue.add(localRoot.left);
            }
        }
    }
}
