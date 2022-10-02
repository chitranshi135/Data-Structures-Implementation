import java.util.*;
interface LinkedListMethods<T>
{
    boolean isEmpty();
    int size();
    void checkIndex(int index);
    T get(int index);
    public void push(T val);
    public void pop();
    int indexOf(T ob);
    T remove(int index);
    void add(int index,T Ob);
    void printList();
}
class Node<T>
{
    T data;
    Node<T> next;
    Node(T value)
    {
        this.data = value;
        this.next = null;
    }
    Node(T element , Node<T> address)
    {
        this.data = element;
        this.next = address;
    }
}

class LinkedList <T> implements LinkedListMethods<T>{
    protected Node<T> head;
    protected int size;
    LinkedList()
    {
        head = null;
        size = 0;
    }
    public boolean isEmpty()
    {
        return (size==0);
    }
    public int size()
    {
        return size;
    }
    public void checkIndex(int i)
    {
        if(i<0 || i>=size) {
            throw new IndexOutOfBoundsException("index = " + i + " and index must be greater than or equal to zero and less than size = " + size);
        }
    }
    public T get(int i)
    {
        checkIndex(i);
        Node<T> currNode = head;
        int x = 0;
        while(x<i)
        {
            currNode = currNode.next;
            x++;
        }
        return currNode.data;
    }
    public void push(T val)
    {
        Node<T> new_node = new Node<T>(val);
        new_node.next = head;
        head = new_node;
        size++;
    }
    public void pop()
    {
        if(isEmpty())
            throw new IllegalArgumentException("No element present to remove");
        Node<T> temp = head;
        while(temp.next.next!=null)
        {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }
    public T remove(int index)
    {
        checkIndex(index);
        T removedElement;
        if(index == 0)
        {
            removedElement = head.data;
            head = head.next;
        }
        else
        {
            Node<T> temp = head;
            Node<T> address;
            for(int x=0;x<index-1;x++)
            {
                temp = temp.next;
            }
            address = temp.next;
            temp.next = temp.next.next;
            removedElement = temp.next.data;
            address.next = null;
        }
        size--;
        return removedElement;
    }
    public void removeElement(T val)
    {
        Node<T> temp = head;
        Node<T> prev = null;
        if (temp != null && temp.data == val) {
            head = temp.next; // Changed head
            return;
        }
        while(temp.next!=null && temp.data!=val)
        {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }
    public void add(int index,T element)
    {
        if(index<0 || index>size)
        {
            throw new IndexOutOfBoundsException("index = " + index + " and index must be greater than or equal to zero and less than or equal to  "+size);
        }
        Node<T> new_node = new Node<T>(element);
        if(index==0)
        {
            new_node.next = head;
            head = new_node;
            size++;
        }
        else
        {
            Node<T> prev = head;
            for(int x=0;x<index-1;x++)
            {
                prev = prev.next;
            }
            new_node.next = prev.next;
            prev.next = new_node;
            size++;
        }
    }
    public int indexOf(T Ob)
    {
        Node<T> currNode = head;
        int i =0;
        while(currNode !=null && currNode.data.equals(Ob) == false)
        {
            currNode = currNode.next;
            i++;
        }
        if(currNode == null)
            return -1;
        else
            return i;
    }
    public void printList()
    {
        Node<T> temp = head;
        if(size==0)
        {
            System.out.println("[ ]");
        }
        else {
            System.out.print("[");
            while (temp != null) {
                if (temp.next == null)
                    System.out.println(temp.data + " ]");
                else
                    System.out.print(temp.data + " , ");
                temp = temp.next;
            }
        }
    }
}
public class Application{
    public static void main(String args[])
    {
        Scanner Sc = new Scanner(System.in);
        LinkedList<Character> A = new LinkedList<Character>();
        String st = "CHITRANSHI";
        int x=0;
        A.printList();
        System.out.println("Linked list empty : "+A.isEmpty());
        System.out.println();
        System.out.println("List after adding 6 elements from front:");
        for(x=5; x>=0; x--)
            A.push(st.charAt(x));
        A.printList();
        System.out.println("Size of linked list :"+ A.size());
        System.out.println();
        System.out.println("List after adding 4 elements at a specific index :");
        for(x=6; x<10 ; x++)
            A.add(A.size,st.charAt(x));
        A.printList();
        System.out.println("Size of linked list :"+ A.size());
        System.out.println();
        A.get(12);
        System.out.println();
//        System.out.println("List after removing last element : ");
//        A.pop();
//        A.printList();
//        System.out.println("Size of linked list :"+ A.size());
//        System.out.println();
//        System.out.println("List after removing element at index 5");
//        A.remove(5);
//        A.printList();
//        System.out.println("Size of linked list :"+ A.size());
//        System.out.println();
//        A.removeElement('N');
//        System.out.println("List after removing character 'N' ");
//        A.printList();
//        System.out.println("Size of linked list :"+ A.size());
//        System.out.println();
//        System.out.println("Index of character 'T' in list : "+A.indexOf('T'));
//        System.out.println();
//        System.out.println("Element of list at index 0 : "+A.get(0));
    }
}
