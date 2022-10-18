package Sprint_1.Uppgift_10;

public enum KontoTyp {

    PERSONKONTO("Personkonto"),
    SPARKONTO("Sparkonto"),
    FÖRMÖGENHETSKONTO("Förmögenhetskonto"),
    VÄRDEPAPPERSKONTO("Värdepapperskonto"),
    INVESTERINGSSPARKONTO("Investeringssparkonto");

    public final String kontoprodukt;
    KontoTyp(String s){

        kontoprodukt = s;
    }
}
