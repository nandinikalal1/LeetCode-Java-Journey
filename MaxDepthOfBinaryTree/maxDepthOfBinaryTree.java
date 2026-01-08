//max depth of tree is height of tree. root node to leaf. can be calculated in terms of number of nodes or edges connecting nodes
import java.util.*;

//Calculates Maximum Depth of a Binary Tree. Tree is built from a LEVEL ORDER array representation.

public class maxDepthOfBinaryTree {
    //NODE CLASS
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    //BUILD TREE FROM ARRAY
    public static Node buildTree(Integer[] arr) {
        // If array is empty or root is null
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            Node current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    //MAX DEPTH LOGIC 
    public static int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    //MAIN METHOD 
    public static void main(String[] args) {

        Integer[] treeInput = {1, 2, 3, 4, 5, null, null};

        // Build tree
        Node root = buildTree(treeInput);

        // Calculate max depth
        int depth = maxDepth(root);

        System.out.println("Maximum Depth of Binary Tree: " + depth);
    }
}
