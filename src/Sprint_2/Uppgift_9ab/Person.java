package Sprint_2.Uppgift_9ab;

public class Person {

    String namn;
    String gatuadress;
    String postort;
    int ålder;
    int vikt;
    int längd;

    public Person(String namn, String gatuadress, String postort, int ålder, int vikt, int längd) {
        this.namn = namn;
        this.gatuadress = gatuadress;
        this.postort = postort;
        this.ålder = ålder;
        this.längd = längd;
        this.vikt = vikt;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s\n%d, %d, %d\n",namn,gatuadress,postort,ålder,vikt,längd);
    }
}
