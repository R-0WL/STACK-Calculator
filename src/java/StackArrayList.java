import java.util.ArrayList;

public class StackArrayList<E> implements Stack<E> {
    protected ArrayList<E> data;

    public StackArrayList() {
        data = new ArrayList<E>();
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
        return data.remove(size() - 1);
    }

    @Override
    public E peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.get(size() - 1);
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return data.size();
    }
}
