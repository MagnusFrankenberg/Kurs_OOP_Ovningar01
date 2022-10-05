package Sprint_1.inlämningsuppgift_1;

//Enum med de tre förutbestämda vätskorna
public enum Vätska {

    KRANVATTEN ("Kranvatten"),
    PROTEINDRYCK ("Proteindryck"),
    MINERALVATTEN ("Mineralvatten");

    public final String substans;
    Vätska(String s){
        substans = s;
    }
}
