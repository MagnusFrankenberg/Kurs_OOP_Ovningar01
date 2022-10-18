package Sprint_1.Uppgift_10;

public class Anställd extends Person {
    private Position position;
    private Ersättning ersättning;

    public Anställd(String namn, String adress, String personnummer, Position position, Ersättning ersättning) {
        super(namn, adress, personnummer);
        this.position = position;
        this.ersättning = ersättning;
    }

    public Position getPosition() {
        return position;
    }

    public Ersättning getErsättning() {
        return ersättning;
    }
}
