package Sprint_1.Uppgift_2a;

public class Bil extends Fordon{
    private int antalVäxlar;
    private int växelJustrNu;


    public Bil(double hastighet, double vikt, int antalVäxlar, int växelJustrNu) {
        super(hastighet, vikt);
        this.antalVäxlar = antalVäxlar;
        this.växelJustrNu = växelJustrNu;
    }

    public void växla(int NyVäxel){
        if(NyVäxel>antalVäxlar||NyVäxel<0){
            System.out.println("Växel finns ej");
        }else{
            växelJustrNu=NyVäxel;
        }
    }

    public int getAntalVäxlar() {
        return antalVäxlar;
    }

    public int getVäxelJustrNu() {
        return växelJustrNu;
    }
}
