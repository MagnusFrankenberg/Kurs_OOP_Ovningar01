package Sprint_1.Uppgift_2a;

public class Cykel extends Fordon{
    private int antalVäxlar;
    private int växelJustNu;

    public Cykel(double hastighet, double vikt, int antalVäxlar, int växelJustNu) {
        super(hastighet, vikt);
        this.antalVäxlar = antalVäxlar;
        this.växelJustNu = växelJustNu;
    }

    public void växla(int nyVäxel){
        if(nyVäxel>antalVäxlar||nyVäxel<1){
            System.out.println("Växel finns ej");
        }else{
            this.växelJustNu=nyVäxel;
        }
    }
}
