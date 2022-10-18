package Sprint_1.Uppgift_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {

    Register r = new Register();



    @Test
    void skapaNyttKonto() {


        System.out.println(r.kundLista.get(0).getAdress());
    }
}