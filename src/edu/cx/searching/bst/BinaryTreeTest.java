package edu.cx.searching.bst;


public class BinaryTreeTest {
    private static Node rootNode = null;

    public BinaryTreeTest() {
        init();
    }

    private void init() {
        int data[] = {12, 11, 34, 45, 67, 38, 56, 43, 22, 8};
        rootNode = new Node(data[0]);
        System.out.println("构造的二叉树的数据结构:");
        System.out.println("--------------start----------------------");
        System.out.println(data[0] + ":rootNode");
        for (int i = 1; i < data.length; i++) {
            System.out.print(data[i] + ":");
            rootNode.insertTree(rootNode, data[i]);
        }
        System.out.println("----------------end--------------------");
    }

    class Node {
        int data;//数据域
        Node leftChild;//指针域
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = null;// 构造一个新节点是，左右子树为空
            rightChild = null;
        }

        private void insertTree(Node root, int data) {
            /**
             * 1 对于新节点还没递归而言，每次的root都是从开始的。树的节点越多，比如30层，每新增一个节点都要遍历30次。
             * 2 递归中的，有些节点临时充当根节点。
             */
            if (data >= root.data) {
                if (root.rightChild == null) {
                    System.out.println(" -> new rightChild");
                    root.rightChild = new Node(data);
                } else {
                    System.out.print(" -> rightChild");
                    // 递归
                    insertTree(root.rightChild, data);
                }
            } else {
                if (root.leftChild == null) {
                    System.out.println(" -> new leftChild");
                    root.leftChild = new Node(data);
                } else {
                    System.out.print(" -> leftChild");
                    insertTree(root.leftChild, data);
                }
            }
        }
    }


    public static void main(String args[]) {
        // 创建一棵树
        BinaryTreeTest b = new BinaryTreeTest();
        // Node rootNode = new Node(12);
        System.out.println("前序遍历----");
        preOrderTraverse(rootNode);
    }

    public static void preOrderTraverse(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraverse(root.leftChild);
            preOrderTraverse(root.rightChild);
        }
    }

    public static void inOrderTraverse(Node root) {
        if (root != null) {
            inOrderTraverse(root.leftChild);
            System.out.print(root.data + " ");
            inOrderTraverse(root.rightChild);
        }
    }

    public static void postOrderTraverse(Node root) {
        if (root != null) {
            postOrderTraverse(root.leftChild);
            postOrderTraverse(root.rightChild);
            System.out.print(root.data + " ");
        }
    }
}
