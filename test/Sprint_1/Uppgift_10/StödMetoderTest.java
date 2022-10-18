package Sprint_1.Uppgift_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StödMetoderTest {

    StödMetoder st = new StödMetoder();
    String prefix = "01-";

    @Test
    void skapaIdNummer() {
        System.out.println(st.skapaIdNummer(prefix,8));
    }
}