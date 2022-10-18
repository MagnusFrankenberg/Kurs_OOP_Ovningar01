package Sprint_1.Uppgift_10;

public class Person {
    private String namn;
    private String adress;
    private String personnummer;

    public Person(String namn, String adress, String personnummer) {
        this.namn = namn;
        this.adress = adress;
        this.personnummer = personnummer;
    }

    public String getNamn() {
        return namn;
    }

    public String getAdress() {
        return adress;
    }

    public String getPersonnummer() {
        return personnummer;
    }
}
