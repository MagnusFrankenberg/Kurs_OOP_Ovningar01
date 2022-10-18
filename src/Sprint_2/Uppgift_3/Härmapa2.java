package Sprint_2.Uppgift_3;

import java.util.*;

public class Härmapa2 {

    public Härmapa2(){
    Scanner sc = new Scanner(System.in);
    String temp;

    while(true) {

        System.out.print("Skriv något ->");
        temp = sc.nextLine();
        System.out.printf("Du skrev: %s\n", temp);
    }
}
    public static void main(String[] args) {
        Härmapa2 h = new Härmapa2();
    }




}
