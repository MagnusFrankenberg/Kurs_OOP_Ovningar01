package Sprint_4.Uppg_15b;

import java.util.ArrayList;
import java.util.List;

public class QueueClass <T extends Number>  implements Queable<T> {
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


    //It works to convert all numbers to double, but in this way, we cannot have a generic result
    //För ett generiskt resultat, se facit på Sigruns Git.
    public double getValueInDoubleFormat(){
        double sum = 0.0;
        //Number sum = 0;

        for (T t : list){
            sum += t.doubleValue();
        }
        return sum;
    }


}
