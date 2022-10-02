package Sprint_1.Uppgift_2b;

public class Huvudprogram {


    public static void main(String[] args) {

        Fordon bil = new Bil(52,1200,5,3);
        Fordon båt = new Båt(25,34000,25000);
        Fordon tåg = new Tåg(150,300,12);
        Fordon cykel = new Cykel(30,8.5,14,7);

        Huvudprogram h = new Huvudprogram();
        h.skrivUtFordonsdata(bil,båt,tåg,cykel);
    }

    public void skrivUtFordonsdata(Fordon f1, Fordon f2, Fordon f3, Fordon f4){
        f1.printMe();
        System.out.println();
        f2.printMe();
        System.out.println();
        f3.printMe();
        System.out.println();
        f4.printMe();
    }

}
