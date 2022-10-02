import java.util.*;
//Chitranshi Srivastava
//202051055
class Node
{
    int data;
    int count;
    Node left,right;
    Node(int key)
    {
        this.count = 1;
        this.data = key;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree
{
    Node root;
    BinaryTree()
    {
        root = null;
    }

    //method to create a level order tree
    public Node buildTree(int[] arr, int i ,Node root)
    {
        // Base case for recursion
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;

            // left child
            root.left = buildTree(arr, 2 * i + 1 ,root.left );

            // right child
            root.right = buildTree(arr, 2 * i + 2, root.right);
        }
        return root;
    }

    public void inOrder(Node root)
    {
        if(root == null)
            return;
        else
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root)
    {
        if(root == null)
            return;
        else
        {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root)
    {
        if(root == null)
            return;
        else
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
}

class BinarySearchTree
{
    Node root;

    BinarySearchTree(){
        root = null;
    }

    public void insert(int key)
    {
        root = insertNode(root,key);
    }

    public Node insertNode(Node root, int data)
    {
        //If root is null(tree empty), then no comparisons required
        if(root == null)
        {
            root = new Node(data);
            return root;
        }

        //If the value is smaller,insert in the left subtree
        if(data < root.data)
        {
            root.left = insertNode(root.left, data);
        }
        //If the value is greater,insert in the right subtree
        else if(data > root.data)
        {
            root.right = insertNode(root.right, data);
        }
        else
        {
            root.count++;
        }

        return root;
    }

    //method to find minimum in a binary search tree(BST)
    public Node minValue(Node root)
    {
        Node min = root;
        while (root.left != null)
        {
            min = root.left;
            root = root.left;
        }
        return min;
    }

    public Node deleteNode(Node root, int val)
    {
        //if element is not present in BST
        if (root == null)
            return null;

        if(val < root.data)
            root.left = deleteNode(root.left, val);

        else if(val > root.data)
            root.right = deleteNode(root.right, val);

            // if val == root.data ,the current node is the node to be deleted
        else
        {
            if(root.count > 1) {
                root.count--;
                return root;
            }
            // if node has only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // if node has two children,we find the min in the right subtree
            Node temp  = minValue(root.right);
            root.data = temp.data;
            root.count = temp.count;
            temp.count = 1;

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public Node search(Node root,int val)
    {
        //if tree is empty or value not found,null is returned
        //if found,the root is returned
        if(root == null || root.data == val)
            return root;
            //larger values in right subtree
        else if(val > root.data)
            return search(root.right,val);
            //smaller values in left subtree
        else
            return search(root.left,val);
    }

    //method to find maximum in a binary tree
    public int max_val(Node node)
    {
        if (node == null)
            return Integer.MIN_VALUE;

        int val = node.data;
        int left_val = max_val(node.left);
        int right_val = max_val(node.right);

        if (left_val > val)
            val = left_val;
        if (right_val > val)
            val = right_val;
        return val;
    }

    //method to find minimum in a binary tree
    public int min_val(Node node)
    {
        if (node == null)
            return Integer.MAX_VALUE;

        int val = node.data;
        int left_val = min_val(node.left);
        int right_val = min_val(node.right);

        if (left_val < val)
            val = left_val;
        if (right_val < val)
            val = right_val;
        return val;
    }

    public boolean isBST(Node node)
    {
        // an empty tree is BST
        if (node == null)
            return true;

        if(node.left != null && node.data == node.left.data)
            return false;

        if(node.right != null && node.data == node.right.data)
            return false;

        // if max in left subtree greater than root of that subtree, then it is not a BST
        if (node.left != null && max_val(node.left) > node.data)
            return false;

        // if min in right subtree greater than root of that subtree, then it is not a BST
        if (node.right != null && min_val(node.right) < node.data)
            return false;

        //now checking recursively for subtree for each node
        if(!isBST(node.left) || !isBST(node.right))
            return false;

        //if all above conditions pass, then it is a BST
        return true;
    }

    public void inorder(Node root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.println(root.data+"(count = "+root.count+")");
            inorder(root.right);
        }
    }

}

public class Driver
{
    public static void main(String args[])
    {
        Scanner Sc = new Scanner(System.in);
        BinarySearchTree Ob = new BinarySearchTree();
        System.out.println("Enter the number of elements you want to add in a binary search tree");
        int n = Sc.nextInt();
        System.out.println("Enter the elements you want to add in a binary search tree");
        int x,val;
        for(x = 0;x < n; x++) {
            val = Sc.nextInt();
            Ob.root = Ob.insertNode(Ob.root, val);
        }
        System.out.println("__________________________________________________________________________________________________________________________");
        System.out.println("INORDER TRAVERSAL OF THE CREATED BINARY SEARCH TREE");
        Ob.inorder(Ob.root);
        System.out.println();
        System.out.println("__________________________________________________________________________________________________________________________");
        System.out.println("Enter a value to search in the created binary search tree");
        val = Sc.nextInt();
        if(Ob.search(Ob.root, val) != null)
            System.out.println(val+" is present in the created binary search tree");
        else
            System.out.println(val+" is not  present in the created binary search tree");
        System.out.println("__________________________________________________________________________________________________________________________");
        System.out.println("Enter a value to search in the created binary search tree");
        val = Sc.nextInt();
        if(Ob.search(Ob.root, val) != null)
            System.out.println(val+" is present in the created binary search tree");
        else
            System.out.println(val+" is not present in the created binary search tree");
        System.out.println("_________________________________________________________________________________________________________________________");
        System.out.println("Enter a value to delete from  the created binary search tree");
        val = Sc.nextInt();
        System.out.println("INORDER TRAVERSAL OF THE CURRENT BINARY SEARCH TREE BEFORE DELETING "+val);
        Ob.inorder(Ob.root);
        System.out.println();
        Ob.root = Ob.deleteNode(Ob.root, val);
            System.out.println("If element is not present in binary search tree.Then no element is deleted and no change in BST");
        System.out.println("INORDER TRAVERSAL OF THE CURRENT BINARY SEARCH TREE AFTER DELETING "+val);
        Ob.inorder(Ob.root);
        System.out.println();
        System.out.println("__________________________________________________________________________________________________________________________");
        System.out.println("Verifying the isBST() method for the created Binary Search Tree");
        //The answer should be true as we have created a binary search tree
        System.out.println("Is the created Binary Search tree , a binary search tree : "+Ob.isBST(Ob.root));
        System.out.println("__________________________________________________________________________________________________________________________");
        System.out.println("Enter the number of elements you want to add in a binary tree");
        n = Sc.nextInt();
        System.out.println("Enter the elements of the binary tree");
        int[] a = new int[n];
        for(x = 0;x < n; x++)
            a[x] = Sc.nextInt();
        System.out.println("Creating a binary tree");
        BinaryTree tree = new BinaryTree();
        tree.root = tree.buildTree(a,0,tree.root);
        System.out.println("Inorder traversal of the binary tree : ");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println("Is the created binary tree a Binary Search Tree : "+Ob.isBST(tree.root));
        System.out.println("__________________________________________________________________________________________________________________________");
    }
}


