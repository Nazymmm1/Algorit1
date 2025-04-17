package Lab2;

public class MyQueue<T extends Comparable<T>>  {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }


    public void enqueue(T item) {
        list.addLast(item);
    }


    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = list.getFirst();
        list.removeFirst();
        return data;
    }


    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
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