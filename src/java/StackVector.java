import java.util.Vector;

public class StackVector<E> implements Stack<E> {
    protected Vector<E> data;

    public StackVector() {
        data = new Vector<E>();
    }

    @Override
    public void push(E item) {
        data.add(item);
    }

    @Override
    public E pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.remove(data.size() - 1);
    }

    @Override
    public E peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.lastElement();
    }

    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }
}
