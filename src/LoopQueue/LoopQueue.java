package LoopQueue;

public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(16);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0;i < size;i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public void enqueue(E e){
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue(){
        if(isEmpty()) throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == getSize() / 4 && getCapacity() / 2 != 0) resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront(){
        if(isEmpty()) throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        return data[front];
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Queue: size = %d, capacity = %d\n",size,getCapacity()));
        builder.append("front [");
        for(int i = front;i != tail - 1;i = (i + 1) % data.length){
            builder.append(data[i]);
            if((i + 1) % data.length != tail) builder.append(", ");
        }
        builder.append("] tail");

        return builder.toString();
    }
}
