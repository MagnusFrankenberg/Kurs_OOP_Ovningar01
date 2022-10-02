package Sprint_1.Uppgift_2c;

public class Tåg extends Fordon implements Printable {
    private int antalVagnar;

    public Tåg(double hastighet, double vikt, int antalVagnar) {
        super(hastighet, vikt);
        this.antalVagnar = antalVagnar;
    }

    public void kopplaVagn(int antal){

        if((antalVagnar += antal)<0){
            System.out.println("Ej möjligt");
        }else{
            System.out.println("Tåget har nu "+antalVagnar+" antal vagnar");
        }
    }

    public int getAntalVagnar() {
        return antalVagnar;
    }

    public void printMe() {
        String cname = this.getClass().getSimpleName() + ":";
        System.out.printf("%s \n" +
                "Hastighet: %.01f\n" +
                "Vikt: %.02f\n" +
                "Antal Vagnar: %d\n", cname, getHastighet(), getVikt(), getAntalVagnar());
    }

}
