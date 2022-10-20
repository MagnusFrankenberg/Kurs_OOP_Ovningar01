package Sprint_2.Uppgift_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    ListManager lm = new ListManager();


    @Test
    void addObjectsToList() {

        lm.addObjectsToList();
        for(Fordon f:lm.fordonList){
            f.printMe();
        }


       // lm.getFordonList().get(0).printMe();
        //lm.getFordonList().get(1).printMe();
    }


    @Test
    void getFordonList() {
    }
}