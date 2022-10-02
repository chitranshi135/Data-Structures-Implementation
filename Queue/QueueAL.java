
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

interface QueueALmethods<T>{

    boolean isEmpty();

    int size();

    T getFrontElement();

    T getRearElement();

    void enqueue(T data);

    T dequeue();

    int search(T value);

    void display();

}
public class QueueAL extends LinkedList<T> implements QueueALmethods<T>{

    QueueAL(int initial capacity){
        super(initial capacaity);
    }

    public T getFrontElement(){
        return super.get(0);
    }

    public T getRearElement(){
        return super.get(size-1);
    }

    public void enqueue(T data){
        if(size == 100000)
            throw new QueueOverflowException();
        super.addRear(data);
    }

    public T dequeue(){
        if(size == 0)
            throw new QueueUnderflowException();
        return super.removeFront();
    }

    public int search(T value){
        int i = super.indexOf(value);
        return (i == -1 ? -1 : (size - i));
    }

    public void display() {
        System.out.println(super.toString());
    }

    public T get(int index){
        return null;
    }

    public int indexOf(T ob){
        return -1;
    }

    public T remove(int index) {
        return null;
    }

    public T removeFront() {
        return null;
    }

    public T removeRear() {
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

