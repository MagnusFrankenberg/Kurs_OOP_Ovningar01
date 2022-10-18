package Sprint_2.Uppgift_6ab;

import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);

    public Main(){

            int pris = inputInt("Ange pris");
            int betalning = inputInt("Ange belopp du betalar med");

            VäxelTillbaka v = new VäxelTillbaka();

            int totalväxel = v.totalVäxel(pris, betalning);

            if (totalväxel <= 0) {
                System.out.println(v.ejNågonVäxel(totalväxel));
                return;
            }
            v.växelList = v.beräknaVäxelTillbaka(totalväxel);

            System.out.println(v.skapaVäxelString(v.växelList));


    }


    public static void main(String[] args) {
        Main p = new Main();
    }

    public int inputInt(String message){
        int input;
        while(true){
            System.out.println(message);
            if(sc.hasNextInt()){
                input = sc.nextInt();
                break;
            }else{
                sc.next();
                System.out.println("Input måste vara ett heltal");
            }
        }
        return input;
    }


}
