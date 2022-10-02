package Sprint_1.Uppgift_3b;

public class Person {
    private String namn;
    private String adress;
    private String födelsedatum;

    public Person(String namn, String adress, String födelsedatum) {
        this.namn = namn;
        this.adress = adress;
        this.födelsedatum = födelsedatum;
    }

    public String getNamn() {
        return namn;
    }

    public String getAdress() {
        return adress;
    }

    public String getFödelsedatum() {
        return födelsedatum;
    }
}
