package Sprint_1.Uppgift_2a;

public class Tåg extends Fordon{
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
}
