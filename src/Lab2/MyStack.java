package Lab2;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyStack() {
        list = new MyLinkedList<>();
    }


    public void push(T item) {
        list.addFirst(item);
    }


    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = list.getFirst();
        list.removeFirst();
        return data;
    }


    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst();
    }


    public boolean isEmpty() {
        return list.size() == 0;
    }


    public int size() {
        return list.size();
    }
}