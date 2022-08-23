package Stack;


/**
 * 复用自定义Array，实现Stack
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E>{
    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayStack(){
        array = new Array<E>();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Stack:"));
        builder.append("[");
        for(int i = 0;i < array.getSize();i++){
            builder.append(array.get(i));

            if(i != array.getSize() - 1){
                builder.append(", ");
            }
        }
        builder.append("]");

        return builder.toString();
    }
}
