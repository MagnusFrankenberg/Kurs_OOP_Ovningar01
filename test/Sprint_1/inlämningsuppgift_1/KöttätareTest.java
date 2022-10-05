package Sprint_1.inlämningsuppgift_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KöttätareTest {

    public Växt köttätare = new Köttätare("Audrey2",10);

    @Test
    void vätskeBehovPerDag() {

        assert(köttätare.VätskeBehovPerDag()==0.1 + (0.2 * köttätare.getLängd()));
        assert(köttätare.VätskeBehovPerDag()==0.1 + (0.2 * 10));
        assert(köttätare.VätskeBehovPerDag()==2.1);
        assert(köttätare.VätskeBehovPerDag()!=0);

    }
}