package Sprint_2.Uppgift_12;

public class Bil extends Fordon implements Printable, Hjulburen {
    private int antalVäxlar;
    private int växelJustNu;

    private int antalHjul;


    public Bil(double hastighet, double vikt, int antalVäxlar, int växelJustNu, int antalHjul) {
        super(hastighet, vikt);
        this.antalVäxlar = antalVäxlar;
        this.växelJustNu = växelJustNu;
        this.antalHjul = antalHjul;
    }

    public void växla(int NyVäxel){
        if(NyVäxel>antalVäxlar||NyVäxel<0){
            System.out.println("Växel finns ej");
        }else{
            växelJustNu =NyVäxel;
        }
    }

    public int getAntalVäxlar() {
        return antalVäxlar;
    }

    public int getVäxelJustNu() {
        return växelJustNu;
    }

    public String printMe(){
        String cname = this.getClass().getSimpleName()+":";
        String s = String.format("%s \n"+
                        "Hastighet: %.01f\n" +
                        "Vikt: %.02f\n" +
                        "Antal Växlar: %d\n" +
                        "Nuvarande växel: %d\n",cname,getHastighet(),getVikt(),getAntalVäxlar(),getVäxelJustNu());
        return s;
    }

    public int getAntalHjul(){
        return antalHjul;
    }
}
