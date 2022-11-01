package Sprint_3.Uppgift_13;

public class Medicine extends Thread{

    String medicinTyp;
    int ggrMin;

    public Medicine(String medicinTyp, int ggrMin) {
        this.medicinTyp = medicinTyp;
        this.ggrMin = ggrMin;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep((60000 / ggrMin));
                System.out.println("Nu ska du ta "+medicinTyp);
            }catch (InterruptedException e){
                break;
            }
        }
    }

}
