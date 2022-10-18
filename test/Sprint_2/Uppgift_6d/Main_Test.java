package Sprint_2.Uppgift_6d;

import org.junit.jupiter.api.Test;

public class Main_Test {

    Main m = new Main();

    @Test
    public void inputInt_Test(){

        String message = "Ange ett heltal";
        assert(m.inputInt(message)==5);




    }
}
