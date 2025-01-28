import java.util.Vector;

public class StackVector<E> implements Stack<E>{
    protected Vector<E> data;

    public StackVector(){
        data = new Vector<E>();
    }

    @Override
    public void push(E item){
        //push
        data.add(item);
    }

    @Override
    public E pop() {
        //pop
        
    }

    @Override
    public E peek() {
        //peek
        
    }

    @Override
    public boolean empty() {
        //empty
        
    }

    @Override
    public int size() {
        //size
    }
 
}