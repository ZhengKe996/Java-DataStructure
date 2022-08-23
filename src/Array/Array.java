package Array;


/***
 * 自定义数组类
 */
public class Array<E>{
    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参构造 默认长度为16
    public Array(){
        this(16);
    }


    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // get value
    public E get(int index){
        if(index < 0 || index > this.size) throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    // set value
    public void set(int index,E e){
        if(index < 0 || index > this.size) throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 判断是否包含e
    public boolean contains(E e){
        for(int i = 0;i < size;i++){
            if(data[i].equals(e)) return true;
        }
        return false;
    }

    // 查找 元素 e 的索引
    public int find(E e){
        for(int i = 0;i < size;i++){
            if(data[i].equals(e)) return i;
        }
        return -1;
    }

    // 删除 index 的元素
    public E remove(int index){
        if(index < 0 || index > this.size) throw new IllegalArgumentException("Remove failed. Index is illegal");
        E res = data[index];
        for(int i = index + 1;i < size;i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length / 2) resize(data.length / 2);
        return res;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    // 判断元素是否在数组中，有则删除
    public void removeElement(E e){
        int index = find(e);
        if(index != -1) remove(index);
    }


    // 在头插入一个元素 e
    public void addFirst(E e){
        add(0,e);
    }

    // 在尾插入一个元素 e
    public void addLast(E e){
        add(size,e);
    }

    // 在第 index 位置插入 e
    public void add(int index,E e){
        if(index < 0 || index > this.size) throw new IllegalArgumentException("Add failed. Index is illegal");

        if(size == data.length) resize(2 * data.length);

        for(int i = size - 1;i >= index;i++){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 数组扩容
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];

        for(int i = 0;i < size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    public void setSize(int size){
        this.size = size;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        builder.append("[");
        for(int i = 0;i < size;i++){
            builder.append(data[i]);
            if(i != size - 1) builder.append(", ");
        }
        builder.append("]");

        return builder.toString();
    }
}
