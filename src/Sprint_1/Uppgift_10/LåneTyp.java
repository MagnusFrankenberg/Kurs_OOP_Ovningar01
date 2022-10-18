package Sprint_1.Uppgift_10;

public enum LåneTyp {

    BOSTADSLÅN("Bostadslån"),
    BILLÅN("Billån"),
    KONSUMTIONSLÅN("Konsumtionslån"),
    FÖRETAGSLÅN("Företagslån");

    public final String låneprodukt;
    LåneTyp(String s){

        låneprodukt = s;
    }
}
