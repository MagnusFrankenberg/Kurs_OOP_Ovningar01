package BraAttHaKod.TCP.MultiClientServer;

import java.io.Serializable;

public class Respons implements Serializable {

    Person p;
    boolean foundPerson;

    public Respons(Person p, boolean foundPerson) {
        this.p = p;
        this.foundPerson = foundPerson;
    }
}
