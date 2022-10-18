package Sprint_1.Uppgift_10;

public class KundProdukt {
    private Kund kund;
    private Bankprodukt bankprodukt;

    public KundProdukt(Kund kund, Bankprodukt bankprodukt) {
        this.kund = kund;
        this.bankprodukt = bankprodukt;
    }

    public Kund getKund() {
        return kund;
    }

    public Bankprodukt getBankprodukt() {
        return bankprodukt;
    }
}
