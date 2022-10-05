package Sprint_1.inlämningsuppgift_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KaktusTest {

    public Växt kaktus = new Kaktus("Kalle",2.2);

    @Test
    void vätskeBehovPerDag() {

        assert(kaktus.VätskeBehovPerDag()==0.02);
        assert(kaktus.VätskeBehovPerDag()!=0);
    }
}