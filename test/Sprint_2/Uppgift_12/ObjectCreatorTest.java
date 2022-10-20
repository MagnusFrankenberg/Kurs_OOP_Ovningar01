package Sprint_2.Uppgift_12;

import org.junit.jupiter.api.Test;

class ObjectCreatorTest {

    ObjectCreator sf = new ObjectCreator();


    @Test
    void createObject() {

        Fordon f = sf.createObject();
        f.printMe();

    }
}