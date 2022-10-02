package Sprint_1.Uppgift_3a;

public class Lärare extends Person{
    Kurs[] lärarensKurser = new Kurs[100];


    public Lärare(String namn, String adress, String födelsedatum) {
        super(namn, adress, födelsedatum);
    }

    public Kurs[] getLärarensKurser() {
        return lärarensKurser;
    }


    public void setLärarensKurser(Kurs kurs) {
        for (int i = 0; i < lärarensKurser.length; i++) {
            if(lärarensKurser[i]==null){
                lärarensKurser[i]=kurs;
                break;
            }
        }
    }
}
