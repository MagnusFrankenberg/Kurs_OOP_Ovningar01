package Sprint_3.Inlämn_kladd_a;

import org.junit.jupiter.api.Test;

class SpelplanTest {

    Spelplan sp = new Spelplan(4);

    @Test
    void isPossibleNewPosition() {
        Position oldP = new Position(1,1,1);
        Position newP = new Position(2,1,5);


        System.out.println(sp.isPossibleNewPosition(oldP,newP));
    }
}