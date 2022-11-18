package Sprint_3.Uppgift_14c;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    List<Object> l = new ArrayList<>();

    public synchronized void put(Object obj) {
        l.add(obj);
        notify();
    }

    public synchronized Object take() {
        while (l.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        Object obj = l.get(0);
        l.remove(0);
        return obj;
    }

    public void printQueue(){
        l.forEach(o -> System.out.println(o));
    }

    public int leftInQueue(){
        return l.size();
    }
}


