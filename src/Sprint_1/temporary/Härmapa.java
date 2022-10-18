package Sprint_1.temporary;
import java.util.Scanner;
public class Härmapa {

    public Härmapa() {
        Scanner sc = new Scanner(System.in);
        String temp;

        while (true) {
            System.out.println("Skriv ett ord");
            temp = sc.next();
            System.out.println("Du skrev: " + temp);
        }
    }
    public static void main(String[] args) {
        Härmapa sc= new Härmapa();
    }

}
