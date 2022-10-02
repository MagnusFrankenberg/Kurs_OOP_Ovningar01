package Sprint_1.Uppgift_1c;


public class Main {

    public Main(){

        Bil b1 = new Bil("ABC123","KIA","SPORTAGE");
        Bil b2 = new Bil("ABC456","VOLVO","XC90");
        Bil b3 = new Bil("BCD123","Peugeot","306");

        Bilägare p1 = new Bilägare("Kalle","Lilla Gränd 2",23);
        Bilägare p2 = new Bilägare("Bamse","Stora Gatan 3",45);
        Bilägare p3 = new Bilägare("Lisa","Lilla Gatan 5",60);

        b1.setÄgare(p1);
        b2.setÄgare(p2);
        b3.setÄgare(p3);

        System.out.println(b1.getMärke()+" "+b1.getÄgare().getNamn());
        System.out.println(b2.getMärke()+" "+b2.getÄgare().getNamn());
        System.out.println(b3.getMärke()+" "+b3.getÄgare().getNamn());

        b2.bytÄgare(p3);
        System.out.println();
        System.out.println(b1.getMärke()+" "+b1.getÄgare().getNamn());
        System.out.println(b2.getMärke()+" "+b2.getÄgare().getNamn());
        System.out.println(b3.getMärke()+" "+b3.getÄgare().getNamn());

    }

    public static void main(String[] args) {

        Main m = new Main();

    }
}
