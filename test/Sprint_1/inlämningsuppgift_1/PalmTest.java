package Sprint_1.inlämningsuppgift_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalmTest {

    Växt palm = new Palm("Olle", 10.2);

    @Test
    void vätskeBehovPerDag() {

        assert (palm.VätskeBehovPerDag() == 0.5 * palm.getLängd());
        assert (palm.VätskeBehovPerDag() == 0.5 * 10.2);
        assert (palm.VätskeBehovPerDag() == 5.1);
        assert (palm.VätskeBehovPerDag() != 0);


    }
}