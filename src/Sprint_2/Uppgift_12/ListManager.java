package Sprint_2.Uppgift_12;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListManager {

    List<Fordon> fordonList;

    public void addObjectsToList(){
        fordonList = new ArrayList<>();
        ObjectCreator oc = new ObjectCreator();
        Fordon f;
        do{
            f= oc.createObject();
            if(f!=null)
            fordonList.add(f);
        }while(f!=null);
    }

    public List<Fordon> getFordonList() {
        return fordonList;
    }
}
