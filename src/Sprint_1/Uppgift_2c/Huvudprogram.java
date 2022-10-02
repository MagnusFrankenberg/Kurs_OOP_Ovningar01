package Sprint_1.Uppgift_2c;

public class Huvudprogram {

    public static void main(String[] args) {

        Fordon bil = new Bil(52,1200,5,3);
        Fordon båt = new Båt(25,34000,25000);
        Fordon tåg = new Tåg(150,300,12);
        Fordon cykel = new Cykel(30,8.5,14,7);

        Printable p1 = bil;
        Printable p2 = båt;
        Printable p3 = tåg;
        Printable p4 = cykel;

        Huvudprogram h = new Huvudprogram();
        h.skrivUtMedPrintable(p1,p2,p3,p4);
    }
    public void skrivUtMedPrintable(Printable p1, Printable p2, Printable p3, Printable p4){
        p1.printMe();
        System.out.println();
        p2.printMe();
        System.out.println();
        p3.printMe();
        System.out.println();
        p4.printMe();

    }
}
