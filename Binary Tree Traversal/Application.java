import java.util.*;
class Node<T>
{
    T data;
    Node<T> left,right;
    Node(T key)
    {
        this.data = key;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree<T>
{
    Node<T> root;
    BinaryTree()
    {
        root = null;
    }

    //method to create a level order tree
    public static Node buildTree(int[] arr, int i ,Node root)
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

    public static void inOrder(Node root)
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

    public static void preOrder(Node root)
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

    public static void postOrder(Node root)
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

public class Application
{
    public static void main(String args[])
    {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = Sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements");
        for(int x = 0; x< n; x++)
            arr[x] = Sc.nextInt();
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
         tree.root = tree.buildTree(arr,0,tree.root);
        System.out.println("Binary tree created.");
        System.out.println("_____________________________________________________________________________________");
        System.out.println(" ");
        System.out.println("INORDER TRAVERSAL");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println(" ");
        System.out.println("_____________________________________________________________________________________");
        System.out.println(" ");
        System.out.println("PREORDER TRAVERSAL");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println(" ");
        System.out.println("_____________________________________________________________________________________");
        System.out.println(" ");
        System.out.println("POSTORDER TRAVERSAL");
        tree.postOrder(tree.root);
        System.out.println();
        System.out.println(" ");
        System.out.println("_____________________________________________________________________________________");

    }
}
