package Sprint_3.Uppgift_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StenSaxPåseTest {

    StenSaxPåse st = new StenSaxPåse();

    @Test
    void computerChoice() {
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
        System.out.println(st.computerChoice());
    }

    @Test
    void playGame() {
        System.out.println(st.playGame("STEN","STEN"));
        System.out.println(st.playGame("STEN","SAX"));
        System.out.println(st.playGame("STEN","PÅSE"));
        System.out.println(st.playGame("SAX","STEN"));
        System.out.println(st.playGame("SAX","SAX"));
        System.out.println(st.playGame("SAX","PÅSE"));
        System.out.println(st.playGame("PÅSE","STEN"));
        System.out.println(st.playGame("PÅSE","SAX"));
        System.out.println(st.playGame("PÅSE","PÅSE"));

    }
}