import java.util.*;
interface ListFunctions<T> {
    int size();

    boolean isEmpty();

    void checkIndex(int index);

    T get(int index);

    int indexOf(T ob);

    T remove(int index);

    T removeFront();

    T removeRear();

    void addFront(T Obj);

    void addRear(T Obj);

    void add(int index, T Ob);

    String toString();
}

class ArrayList<T> implements ListFunctions<T> {
    protected int size;
    protected T[] arr;

    ArrayList(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("initial capacity of list must be atleast one");
        }
        arr = (T[]) new Object[initialCapacity];
    }

    ArrayList() {
        this(10);
    }

    private void changeSize() {
        T[] tempArr = (T[]) new Object[2 * size];
        for (int index = 0; index < size; index++) {
            tempArr[index] = arr[index];
        }
        arr = tempArr;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index must be in the range 0 to " + (size - 1));
        }
    }

    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    public int indexOf(T ob) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(ob))
                return i;
        }
        return -1;
    }

    public T remove(int index) {
        checkIndex(index);
        T removedElement = arr[index];
        for (int i = index + 1; i < size; i++)
            arr[i - 1] = arr[i];
        size = size - 1;
        arr[size] = null; // enable garbage collection
        return removedElement;
    }

    public T removeFront() {
        if (isEmpty())
            throw new IllegalArgumentException("No element present to remove");
        T removedElement = arr[0];
        for (int i = 1; i < size; i++)
            arr[i - 1] = arr[i];
        size--;
        arr[size] = null;
        return removedElement;
    }

    public T removeRear() {
        if (isEmpty())
            throw new IllegalArgumentException("No element present to remove");
        T removedElement = arr[size - 1];
        size--;
        arr[size] = null;
        return removedElement;
    }

    public void addFront(T Obj) {
        if (size == arr.length) {
            changeSize();
        }
        for (int i = size - 1; i >= 0; i--)
            arr[i + 1] = arr[i];
        arr[0] = Obj;
        size++;
    }

    public void addRear(T Obj) {
        if (size == arr.length) {
            changeSize();
            System.out.println(arr.length+","+size);
        }
        arr[size] = Obj;
        size++;
    }

    public void add(int index, T Ob) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index must be in the range 0 to " + (size - 1));
        }
        if (size == arr.length) {
            changeSize();
        }
        for (int i = size - 1; i >= index; i--)
            arr[i + 1] = arr[i];

        arr[index] = Ob;
        size++;
    }

    public String toString() {
        StringBuffer str = new StringBuffer("[");
        for (int i = 0; i < size; i++) {
            if (arr[i] == null)
                str.append("null, ");
            else
                str.append(arr[i].toString() + ", ");
        }

        if (size > 0)
            // removing last ", "
            str.delete(str.length() - 2, str.length());
        str.append("]");
        return new String(str);
    }
}

interface StackALmethods<T> {
    public boolean isEmpty();

    public int size();

    public void push(T val);

    public T pop();

    public T peek();

    public int search(T value);

    public void display();
}

class StackAL<T> extends ArrayList<T> implements StackALmethods<T> {
    StackAL(int initialCapacity) {
        super(initialCapacity);
    }

    public void push(T val) {
        super.addRear(val);
    }

    public T pop() {
        return super.removeRear();
    }

    public T peek() {
        if (super.isEmpty())
            throw new IllegalArgumentException("Stack empty");
        return super.get(size - 1);
    }

    public int search(T value) {
        int i = super.indexOf(value);
        return (i == -1 ? -1 : (size - i));
    }

    public void display() {
        System.out.println(super.toString());
    }

    public T get(int index) {
        return null;
    }

    public T remove(int index) {
        return null;
    }

    public T removeFront() {
        return null;
    }

    public void addFront(T Ob) {
    }

    public void add(int index, T Ob) {
    }


    public void checkIndex(int index) {
    }

    public void addRear(T Obj) {
    }

    public String toString(){
        return null;
    }
}

interface LinkedListMethods<T>
{
    boolean isEmpty();

    int size();

    void checkIndex(int index);

    T get(int index);

    void push(T val);

    T pop();

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

    public T pop()
    {
        if(isEmpty())
            throw new IllegalArgumentException("No element present to remove");
        Node<T> temp = head;
        if(temp.next == null){
            size--;
            return temp.data;
        }
        while(temp.next.next!=null)
        {
            temp = temp.next;
        }
        T removedElement = temp.next.data;
        temp.next = null;
        size--;
        return removedElement;
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

interface StackLLmethods<T>
{
    boolean isEmpty();

    int getSize();

    void push(T val);

    T pop();

    T peek();

    int search(T value);

    void display();
}

class StackLL<T> extends LinkedList<T> implements StackLLmethods<T>
{
    StackLL()
    {
        super();
    }

    public int getSize()
    {
        return size;
    }

    public void push(T val)
    {
        Node<T> new_node = new Node<T>(val);
        if(super.isEmpty())
            head = new_node;
        else {
            Node<T> temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new_node;
        }
        size++;
    }

    public T peek()
    {
        if(super.isEmpty())
            throw new IllegalArgumentException("Stack empty");
        Node<T> temp = head;
        while(temp.next != null)
            temp = temp.next;
        return temp.data;
    }

    public int search(T value)
    {
        int i = super.indexOf(value);
        return (i==-1 ?-1:(size-i));
    }

    public void display()
    {
        super.printList();
    }

    public void add(int index,T element) {
    }

    public void removeElement(T val) {
    }

    public T remove(int index)
    {
        return null;
    }

    public void checkIndex(int index){
    }

    public T get(int index){
        return null;
    }
}
public class Application{
    public static void main(String args[])
    {
        String name = "CHITRANSHI";
        int id = 550150202;
        StackAL<Integer> stackObjAL = new StackAL<Integer>((id + "").length());
        StackLL<Character> stackObjLL = new StackLL<Character>();
        System.out.println("###IMPLEMENTING STACK USING ARRAYLIST###");
        System.out.println("Size of stack : "+stackObjAL.size());
        System.out.println("Is stack empty : "+stackObjAL.isEmpty());
        System.out.println("Current stack : ");
        stackObjAL.display();
        System.out.println();
        int c ;
        while(id>0)
        {
            stackObjAL.push(id%10);
            id /= 10;
        }
        System.out.println("Size of stack : "+stackObjAL.size());
        System.out.println("Is stack empty : "+stackObjAL.isEmpty());
        System.out.println("Current stack : ");
        stackObjAL.display();
        System.out.println();
        System.out.println("Index of 1 in stack : "+stackObjAL.search(1));
        System.out.println("Index of 7 in stack : "+stackObjAL.search(7));
        System.out.println("Element at top of stack : "+stackObjAL.peek());
        System.out.println("Element removed : "+stackObjAL.pop());
        System.out.println("Element removed : "+stackObjAL.pop());
        stackObjAL.addFront(9);
        System.out.println("Current stack : ");
        stackObjAL.display();
        System.out.println("Size of stack : "+stackObjAL.size());
        System.out.println("Is stack empty : "+stackObjAL.isEmpty());
        System.out.println();
        System.out.println("###IMPLEMENTING STACK USING LINKED LIST###\n");
        System.out.println("Size of stack : "+stackObjLL.size());
        System.out.println("Is stack empty : "+stackObjLL.isEmpty());
        System.out.println("Current stack : ");
        stackObjLL.display();
        System.out.println();
        c = 0;
        while(c< name.length())
        {
            stackObjLL.push(name.charAt(c));
            c++;
        }
        System.out.println("Size of stack : "+stackObjLL.size());
        System.out.println("Is stack empty : "+stackObjLL.isEmpty());
        System.out.println("Current stack : ");
        stackObjLL.display();
        System.out.println();
        System.out.println("Index of 'N' in stack : "+stackObjLL.search('N'));
        System.out.println("Index of 'J' in stack : "+stackObjLL.search('J'));
        System.out.println("Element at top of stack : "+stackObjLL.peek());
        System.out.println("Element removed : "+stackObjLL.pop());
        System.out.println("Element removed : "+stackObjLL.pop());
        System.out.println("Element removed : "+stackObjLL.pop());
        System.out.println("Current stack : ");
        stackObjLL.display();
        System.out.println("Size of stack : "+stackObjLL.size());
        System.out.println("Is stack empty : "+stackObjAL.isEmpty());
        System.out.println();
    }
}
