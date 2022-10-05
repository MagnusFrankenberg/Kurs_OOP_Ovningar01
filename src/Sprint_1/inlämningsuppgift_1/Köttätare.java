package Sprint_1.inlämningsuppgift_1;

//Detta är en subklass till Växt och ärver därför alla variabler och metoder från Växt,
public class Köttätare extends Växt {

    //Relevant enum skickas till superklassens konstruktor
    public Köttätare(String namn, double längd) {
        super(namn, längd, Vätska.PROTEINDRYCK);
    }

    //Implementation av superklassens abstrakta metod med relevant formel för Växt-typen.
    @Override
    public double VätskeBehovPerDag() {
        double literVätska = 0.1 + (0.2 * getLängd());
        return literVätska;
    }

}
