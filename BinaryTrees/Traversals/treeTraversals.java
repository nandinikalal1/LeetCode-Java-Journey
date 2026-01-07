package Traversals;
import java.util.*; //for level order traversal(queue)
public class treeTraversals {

//how do we traverse in trees
//recursively -> preorder, in order, post order. Iteratively -> Level order
// 1. Preorder: Root -> Left SubTree -> Right SubTree
//Rule: Print root first, next left subtree and next right subtree

    //1. Creating node class
    static class Node{ //static
        int data;
        Node left;
        Node right;
        //Constructor
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
//2. Creating binary tree class - static
//we store nodes in form of array in buildTree class
//we return Node - Tree's root
//we have to keep increasing index and go to all numbers in the given sequence
//take the data from them all and create nodes
//so lets create index variable
static class BinaryTree{
    static int idx = -1; // static - dont need to create new object. because for every recursion we want index to update fpr every node and update
public static Node buildTree(int nodes[]) {
    idx++; //to update for all nodes, beginning it is -1, but after first call it becomes 0
    //check nodes of indx are -1, if yes return null. we dont need to create child nodes left and right so return null
    if(idx >= nodes.length) return null; //safety
    if(nodes[idx] == -1){
        return null;
    }
    Node newNode = new Node(nodes[idx]); //if not -1, we have to create new node. what ever at the index has data ofnode, we store and create new node
    newNode.left = buildTree(nodes); // node and its left sub tree and next right sub tree
    //calling buildTree again for nodes, assume buildtree is recursive function it will automaticaly create. here = is attaching buildTree
    newNode.right = buildTree(nodes);//right subtree
     return newNode;//finaly return the new node
}

public static void preorder(Node root){ //function - pass root node in it
    //BaseCase - if root is null (current node,leaf or root is null) dont print anything, return
    if(root == null){
        return;
    }
    System.out.print(root.data+" "); //rule 1 print root.data
    preorder(root.left);//rule 2 print left - preorder func does it
    preorder(root.right);//rule 3 print right - preorder func does it
}
public static void inorder(Node root){ //function for inorder traversal
   
    if(root == null){ //base case
        return;
    }
    inorder(root.left);
    System.out.print(root.data+ " ");
    inorder(root.right);  
}
public static void postorder(Node root){
    if(root == null){ //Base case
        return;
    }
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data+ " ");
}
//level order Traversal - return type is not node, it is void
public static void levelOrder(Node root){ //we pass root node
    if(root == null){
        return;
    }
//To Implement level order we need to create Queue
Queue<Node> q = new LinkedList<>(); //we will store nodes in queue
q.add(root); //1st step add root
q.add(null); // 2nd step add null
while(!q.isEmpty()){ //create a loop, till our queue q becomes empty
    Node currNode = q.remove(); //we will remove elements one by one from queue and store in node
    if(currNode == null){ //check if current node is null
        System.out.println();//print next line if current node null
        if(q.isEmpty()){ // if queue is empty now?? we printed all level order
            break; // we need not do anything so break
        }else{ // if elements are still left over in queue
            q.add(null); // add null to the queue so at this level line is printed
        }
        }else{ // if we dont have null in the queue
            System.out.print(currNode.data+ " "); // current node data print
            if(currNode.left != null){ //check left child is null
                q.add(currNode.left); //if not null add to queue
            }
            if(currNode.right != null){ //check right child is null
                q.add(currNode.right); //if not null add to queue
            } 
        }
    }
}
}



public static void main(String args[]){
    //array - preorder traversal of binary tree
    //root first, next left sub tree, next right sub tree & -1 means no child node (NULL)

    int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1} ;//stored preorder sequence in array called nodes
    //create binary tree
    BinaryTree tree = new BinaryTree();
    Node root = tree.buildTree(nodes);
    
    //tree.preorder(root);
    //tree.inorder(root);
    //tree.postorder(root);
    tree.levelOrder(root);
}
}



//Time Complexity for PostOrder, InOrder, PreOrder: We went on each node once - n nodes O(n)
//For Level Order - we process each node two times add to the queue and remove it so 2n -> O(2n) -> O(n)
