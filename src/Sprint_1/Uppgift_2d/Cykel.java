package Sprint_1.Uppgift_2d;

public class Cykel extends Fordon implements Printable, Hjulburen {
    private int antalVäxlar;
    private int växelJustNu;
    private int antalHjul;

    public Cykel(double hastighet, double vikt, int antalVäxlar, int växelJustNu, int antalHjul) {
        super(hastighet, vikt);
        this.antalVäxlar = antalVäxlar;
        this.växelJustNu = växelJustNu;
        this.antalHjul = antalHjul;
    }

    public void växla(int nyVäxel){
        if(nyVäxel>antalVäxlar||nyVäxel<1){
            System.out.println("Växel finns ej");
        }else{
            this.växelJustNu=nyVäxel;
        }
    }

    public int getAntalVäxlar() {
        return antalVäxlar;
    }

    public int getVäxelJustNu() {
        return växelJustNu;
    }

    public void printMe(){
        String cname = this.getClass().getSimpleName()+":";
        System.out.printf("%s \n"+
                "Hastighet: %.01f\n" +
                "Vikt: %.02f\n" +
                "Antal Växlar: %d\n" +
                "Nuvarande växel: %d\n",cname,getHastighet(),getVikt(),getAntalVäxlar(),getVäxelJustNu());
    }

    public int getAntalHjul(){
        return antalHjul;
    }
}
