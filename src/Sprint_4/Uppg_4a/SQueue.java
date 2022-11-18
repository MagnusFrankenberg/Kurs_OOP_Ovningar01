package Sprint_4.Uppg_4a;

import java.util.*;

public class SQueue {

    List<Object> olist = new ArrayList<>();

    public synchronized void put(Object obj){
        olist.add(obj);
        notify();
    }

    public synchronized Object take(){
        while(olist.isEmpty())
            try{
                wait();
            }catch (InterruptedException e){
                return null;
            }
        Object obj = olist.get(0);
        olist.remove(0);
        return obj;
    }



}
