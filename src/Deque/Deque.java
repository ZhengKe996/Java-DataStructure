package Deque;

public class Deque<E>{
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public Deque(){
        this(16);
    }

    public Deque(int capacity){
        data = (E[])new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public void addLast(E e){
        if(size == getSize()) resize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void addFront(E e){
        if(size == getSize()) resize(getCapacity() * 2);
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0;i < size;i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

}
