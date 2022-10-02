import java.util.*;
interface ListFunctions<T>
{
    int size();
    boolean isEmpty();
    void checkIndex(int index);
    T get(int index);
    int indexOf(T ob);
    T remove(int index);
    T removeFront();
    T removeRear();
    void addFront(T Ob);
    void addRear(T Ob);
    void add(int index,T Ob);
    String toString();
}
class ArrayList<T> implements ListFunctions<T>{
    protected int size;
    protected T[] element;
    ArrayList(int initialCapacity)
    {
        if(initialCapacity<1)
        {
            throw new IllegalArgumentException("initial capacity of list must be atleast one");
        }
        element = (T[]) new Object[initialCapacity];
    }
    ArrayList()
    {
        element=(T[]) new Object[10];
    }
    public void changeSize()
    {
        T[] arr =(T[]) new Object[2*size];
        for(int x=0;x<size;x++)
        {
            arr[x]=element[x];
        }
        element=arr;
    }
    public boolean isEmpty()
    {
        return (size==0);
    }
    public int size()
    {
        return size;
    }
    public void checkIndex(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IllegalArgumentException("Index size must be in the range 0 to "+ (size-1));
        }
    }
    public T get(int index)
    {
        checkIndex(index);
        return element[index];
    }
    public int indexOf(T ob)
    {
        for (int i = 0; i < size; i++)
        {
            if (element[i].equals(ob))
                return i;
        }
        return -1;
    }
    public T remove(int index)
    {
        checkIndex(index);
        T removedElement = element[index];
        for (int i = index + 1; i < size; i++)
            element[i-1] = element[i];
        size=size-1;
        element[size] = null; // enable garbage collection
        return removedElement;
    }
    public T removeFront()
    {
        if(isEmpty())
            throw new IllegalArgumentException("No element present to remove");
        T removedElement = element[0];
        for (int i = 1; i < size; i++)
            element[i-1] = element[i];
        size--;
        element[size]=null;
        return removedElement;
    }
    public T removeRear()
    {
        if(isEmpty())
            throw new IllegalArgumentException("No element present to remove");
        T removedElement = element[size-1];
        size--;
        element[size]=null;
        return removedElement;
    }
    public void addFront(T Ob)
    {
        if(size==element.length)
        {
            changeSize();
        }
        for (int i = size - 1; i >=0; i--)
            element[i + 1] = element[i];
        element[0]=Ob;
        size++;
    }
    public void addRear(T Ob)
    {
        if(size==element.length)
        {
            changeSize();
        }
        element[size]=Ob;
        size++;
    }
    public void add(int index,T Ob)
    {
        if(index<0||index>size)
        {
            throw new IndexOutOfBoundsException("Index size must be in the range 0 to "+ (size-1));
        }
        if(size==element.length)
        {
            changeSize();
        }
        for (int i = size - 1; i >= index; i--)
            element[i + 1] = element[i];

        element[index] = Ob;
        size++;
    }
    public String toString()
    {
        StringBuffer str = new StringBuffer("[");
        for (int i = 0; i < size; i++)
        {
            if (element[i] == null)
                str.append("null, ");
            else
                str.append(element[i].toString() + ", ");
        }

        if (size > 0)
            // removing last ", "
            str.delete(str.length() - 2, str.length());
        str.append("]");
        return new String(str);
    }
}
public class Application
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        ArrayList<String> A = new ArrayList<String>(5);
        int i;String s;
        System.out.println("###########################################################################");
        System.out.println("Implementing a string array list");
        System.out.println();
        System.out.println("Enter five Strings");
        for(i=1;i<=5;i++)
        {
            s=Sc.nextLine();
            A.add(i-1,s);
            System.out.println("Current Array list");
            System.out.println(A.toString());
            System.out.println();
            System.out.println("Size of list : "+A.size());
        }
        System.out.println();
        System.out.println("List empty : "+A.isEmpty());
        System.out.println("Array list");
        System.out.println(A.toString());
        System.out.println();
        System.out.println("Element of array list at index 2 : "+A.get(2));
        System.out.println();
        System.out.println("Enter the string whose index you want to find");
        s=Sc.nextLine();
        System.out.println("Index of element " +s+ " in the array list : "+A.indexOf(s));
        System.out.println();
        System.out.println("Reference of removed element at index 4 : "+A.remove(4));
        System.out.println("Current Array list");
        System.out.println(A.toString());
        System.out.println("REMOVING ELEMENTS OF ARRAY LIST FROM FRONT ");
        for(i=1;i<=2;i++)
        {
            A.removeFront();
            System.out.println("Current Array list");
            System.out.println(A.toString());
            System.out.println();
            System.out.println("Size of list : "+A.size());
            System.out.println();
        }
        System.out.println("REMOVING ELEMENTS OF ARRAY LIST FROM FRONT ");
        for(i=3;i<=4;i++)
        {
            A.removeRear();
            System.out.println("Current Array list");
            System.out.println(A.toString());
            System.out.println();
            System.out.println("Size of list : "+A.size());
            System.out.println();
        }
        System.out.println("List empty : "+A.isEmpty());
        System.out.println();
        System.out.println(A.size());
        System.out.println("###########################################################################");
        System.out.println("Implementing an Integer array list");
        System.out.println();
        ArrayList<Integer> B = new ArrayList<Integer>();
        for(i=1;i<=10;i++)
        {
            B.add(i-1,i);
            System.out.println("Current Array list");
            System.out.println(B.toString());
            System.out.println();
            System.out.println("Size of list : "+B.size());
        }
        System.out.println("List empty : "+B.isEmpty());
        System.out.println("Array list");
        System.out.println(B.toString());
        System.out.println();
        System.out.println("Element of array list at index 4 : "+B.get(4));
        System.out.println();
        System.out.println("Index of element 9 in the array list : "+B.indexOf(9));
        System.out.println();
        System.out.println("ADDING ELEMENTS TO ARRAY LIST FROM FRONT");
        for(i=11;i<=15;i++)
        {
            B.addFront(i);
            System.out.println("Current Array list");
            System.out.println(B.toString());
            System.out.println();
            System.out.println("Size of list : "+B.size());
            System.out.println();
        }
        System.out.println("ADDING ELEMENTS TO ARRAY LIST FROM REAR");
        for(i=16;i<=20;i++)
        {
            B.addRear(i);
            System.out.println("Current Array list");
            System.out.println(B.toString());
            System.out.println();
            System.out.println("Size of list : "+B.size());
            System.out.println();
        }
        System.out.println("Reference of removed element at index 4 : "+B.remove(4));
        System.out.println("Current Array list");
        System.out.println(B.toString());
        System.out.println("REMOVING ELEMENTS OF ARRAY LIST FROM FRONT ");
        for(i=1;i<=10;i++)
        {
            B.removeFront();
            System.out.println("Current Array list");
            System.out.println(B.toString());
            System.out.println();
            System.out.println("Size of list : "+B.size());
            System.out.println();
        }
        System.out.println("REMOVING ELEMENTS OF ARRAY LIST FROM FRONT ");
        for(i=1;i<=9;i++)
        {
            B.removeRear();
            System.out.println("Current Array list");
            System.out.println(B.toString());
            System.out.println();
            System.out.println("Size of list : "+B.size());
            System.out.println();
        }
        System.out.println("List empty : "+B.isEmpty());
        System.out.println();
        System.out.println("###########################################################################");
        System.out.println("Implementing a Character array list");
        System.out.println();
        ArrayList<Character> C = new ArrayList<Character>(15);
        for(i=1;i<=10;i++)
        {
            C.add(i-1,((char)(97+i-1)));
            System.out.println("Current Array list");
            System.out.println(C.toString());
            System.out.println();
            System.out.println("Size of list : "+C.size());
            System.out.println();
        }
        System.out.println("List empty : "+C.isEmpty());
        System.out.println("Array list");
        System.out.println(C.toString());
        System.out.println();
        System.out.println("Element of array list at index 9 :  "+C.get(9));
        System.out.println();
        System.out.println("Index of element c in the array list : "+C.indexOf('c'));
        System.out.println();
        System.out.println("ADDING ELEMENTS TO ARRAY LIST FROM FRONT");
        for(i=11;i<=15;i++)
        {
            C.addFront((char)(97+i-1));
            System.out.println("Current Array list");
            System.out.println(C.toString());
            System.out.println();
            System.out.println("Size of list : "+C.size());
            System.out.println();
        }
        System.out.println("ADDING ELEMENTS TO ARRAY LIST FROM FRONT");
        for(i=16;i<=20;i++)
        {
            C.addRear((char)(97+i-1));
            System.out.println("Current Array list");
            System.out.println(C.toString());
            System.out.println();
            System.out.println("Size of list : "+C.size());
            System.out.println();
        }
        System.out.println("Reference of removed element at index 4 : "+C.remove(4));
        System.out.println("Current Array list");
        System.out.println(C.toString());
        System.out.println();
        System.out.println("REMOVING ELEMENTS OF ARRAY LIST FROM FRONT ");
        for(i=1;i<=10;i++)
        {
            C.removeFront();
            System.out.println("Current Array list");
            System.out.println(C.toString());
            System.out.println();
            System.out.println("Size of list : "+C.size());
            System.out.println();
        }
        System.out.println("REMOVING ELEMENTS OF ARRAY LIST FROM FRONT ");
        for(i=1;i<=9;i++)
        {
            C.removeRear();
            System.out.println("Current Array list");
            System.out.println(C.toString());
            System.out.println();
            System.out.println("Size of list : "+C.size());
            System.out.println();
        }
        System.out.println("List empty : "+C.isEmpty());
        System.out.println();
    }
}