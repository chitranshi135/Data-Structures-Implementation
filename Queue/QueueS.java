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

class QueueOverflowException extends RuntimeException {
    public QueueOverflowException() {
        super("Queue is full");
    }
}

class QueueUnderflowException extends RuntimeException {
    public QueueUnderflowException() {
        super("Queue is empty");
    }
}
public class QueueS<T> {

    protected int size;

    StackLL<T> stack1 = new StackLL<T>();
    StackLL<T> stack2 = new StackLL<T>();

    QueueS(){
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public void enqueue(T data){
        if(size == 100000)
            throw new QueueOverflowException();
        stack1.push(data);
        size++;
    }

    public T dequeue()
    {
        if(size == 0)
            throw new QueueUnderflowException();

        if(stack2.size()==0) {
            while (stack1.size() != 0)
                stack2.push(stack1.pop());
        }
        T x = stack2.pop();
        size--;
        while(stack2.size != 0){
            stack1.push(stack2.pop());
        }
        return x;
    }

    public T getFrontElement(){
        if(size == 0)
            throw new QueueUnderflowException();
        if(stack2.size()==0){
            while (stack1.size() != 0)
            {
                stack2.push(stack1.pop());
            }
        }
        T x = stack2.peek();
        while(stack2.size != 0){
            stack1.push(stack2.pop());
        }
        return x;
    }

    public T getRearElement(){
        if(size == 0)
            throw new QueueUnderflowException();
        return stack1.peek();
    }

    public int  search(T value){
        int i = stack1.search(value);
        return (i==-1)?-1 : size-i+1 ;
    }
    public void displayQueue(){
        stack1.display();
    }
    public static void main(String args[]){
        QueueS<Integer> obj = new QueueS<Integer>();
        System.out.println("Is queue empty : "+obj.isEmpty());
        System.out.println(obj.size());
        obj.displayQueue();
        obj.enqueue(2);
        obj.enqueue(0);
        obj.enqueue(2);
        obj.enqueue(0);
        obj.enqueue(5);
        obj.enqueue(1);
        obj.enqueue(0);
        obj.enqueue(5);
        obj.enqueue(5);
        obj.displayQueue();
        System.out.println("Front : "+obj.getFrontElement());
        System.out.println("Rear : "+obj.getRearElement());
        System.out.println("Position of 5 in queue : "+obj.search(5));
        System.out.println("Element Removed : "+obj.dequeue());
        System.out.println("Element Removed : "+obj.dequeue());
        System.out.println("Element Removed : "+obj.dequeue());
        System.out.println("Element Removed : "+obj.dequeue());
        System.out.println("Element Removed : "+obj.dequeue());
        obj.displayQueue();
        System.out.println("Element Removed : "+obj.dequeue());
        System.out.println("Element Removed : "+obj.dequeue());
        System.out.println("Element Removed : "+obj.dequeue());
        System.out.println("Element Removed : "+obj.dequeue());
        System.out.println("Element Removed : "+obj.dequeue());
    }
}

