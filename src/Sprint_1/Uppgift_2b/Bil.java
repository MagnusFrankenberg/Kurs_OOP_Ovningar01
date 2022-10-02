package Sprint_1.Uppgift_2b;

public class Bil extends Fordon {
    private int antalVäxlar;
    private int växelJustNu;


    public Bil(double hastighet, double vikt, int antalVäxlar, int växelJustrNu) {
        super(hastighet, vikt);
        this.antalVäxlar = antalVäxlar;
        this.växelJustNu = växelJustrNu;
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

    public void printMe(){
        String cname = this.getClass().getSimpleName()+":";
        System.out.printf("%s \n"+
                        "Hastighet: %.01f\n" +
                        "Vikt: %.02f\n" +
                        "Antal Växlar: %d\n" +
                        "Nuvarande växel: %d\n",cname,getHastighet(),getVikt(),getAntalVäxlar(),getVäxelJustNu());
    }
}
