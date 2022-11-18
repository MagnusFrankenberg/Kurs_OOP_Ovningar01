package Sprint_4.Uppg_15a;

import java.util.*;

public class QueueClass <T> implements Queable<T> {
    List<T> list = new ArrayList<>();


    @Override
    public void put(T content) {
        list.add(content);
    }

    @Override
    public T take() {
        T content = list.get(0);
        list.remove(0);
        return content;
    }

    @Override
    public int size() {
        return list.size();
    }
}
