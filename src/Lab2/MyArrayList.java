package Lab2;

import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] elements;
    private int length;
    private int capacity=5;

    public MyArrayList(){
        elements= new Object[capacity];
        length=0;
    }

    public void increaseCapacity(){
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];

        for (int i = 0; i < length; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }
    @Override
    //elements.length here is abuild in function or capacity like 1,2,3,null,null here elements.length=3
    // just length is filled cells so it will be 3
    public void add(T item) {
        if(length== elements.length){
            increaseCapacity();
        }
        elements[length++]=item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index]=item;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if(elements.length==length){
            increaseCapacity();
        }
        //so element[length]= null it will be element[length -1] and so on
        for(int i=length;i>index;i--){
            elements[i]=elements[i-1];
        }

        elements[index]=item;
        length++;

    }

    @Override
    public void addFirst(T item) {
        if(length==elements.length){
            increaseCapacity();
        }
        for(int i=length;i>0;i--){
            elements[i]=elements[i-1];
        }
        elements[0]=item;
        length++;
    }

    @Override
    public void addLast(T item) {
        if(length==elements.length){
            increaseCapacity();
        }
        elements[length++]=item;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        checkIndex(0);
        return (T) elements[0] ;
    }

    public void checkIndex(int index){
        if(index>=elements.length || index<0){
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    @Override
    public T getLast() {
        checkIndex(length-1);
        return (T) elements[length-1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);

        elements[index]=null;
        for(int i=index;i<length-1;i++){
            elements[i]=elements[i+1];
        }
        elements[length-1]=null;
        length--;
    }

    @Override
    public void removeFirst() {
        checkIndex(0);

        elements[0]=null;
        for(int i=0;i<length-1;i++){
            elements[i]=elements[i+1];
        }
        elements[length-1]=null;
        length--;
    }

    @Override
    public void removeLast() {
        elements[length-1]=null;
        length--;
    }

    @Override
    public void sort() {
        for(int i=0; i<length-1;i++){
            for(int j=0;j<length-1-i;j++){
                if (((T) elements[j]).compareTo((T) elements[j + 1]) > 0) {
                    T temp = (T) elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for(int i=0;i<length-1;i++){
            if (elements[i]==object){
                return i;
            }
        }
        throw new IndexOutOfBoundsException("We dont have such an object?!");
    }

    @Override
    public int lastIndexOf(Object object) {
        for(int i=length-1;i>0;i--){
            if (elements[i].equals(object)){
                return i;
            }
        }
        throw new IndexOutOfBoundsException("We dont have such an object?!");
    }

    @Override
    public boolean exists(Object object) {
        boolean flag=false;
        for(int i=0;i<elements.length;i++){
           if(elements[i]==object){
               flag=true;
           }
        }
        return flag;
    }

    @Override
    public Object[] toArray() {
        //we didnt just return elementss becaose we dont want to have nulls in toArray
        Object[] result= new Object[length];
        for(int i=0;i<length;i++){
            result[i]=elements[i];
        }
        return result;
    }

    @Override
    public void clear() {
        for(int i=0;i<elements.length;i++){
            elements[i]=null;
        }
        length=0;
    }

    @Override
    public int size() {
        return length;
    }


    @Override
    //i didnt get why do i need an iterator at first place
    public Iterator<T> iterator() {
        return null;
    }
}