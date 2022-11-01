package Sprint_3.Inlämn_kladd_b;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class Spelplan_GUITest {



    Spelplan_GUI s = new Spelplan_GUI(4);

    @Test
    void isPermittedSwap_Test() {
        JPanel ej= new JPanel();
        ej.setName("8");
        JPanel nj = new JPanel();
        nj.setName("7");

        assert (s.isPermittedSwap(ej,nj));

    }
}