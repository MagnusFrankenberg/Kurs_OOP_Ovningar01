package Sprint_1.Uppgift_3a;

public class Kurs {
    private String kursNamn;
    private Student[] klasslista = new Student[100];
    private Lärare lärare;

    public Kurs(String kursNamn) {
        this.kursNamn = kursNamn;
    }

    public Kurs(String kursNamn, Student[] klasslista, Lärare lärare) {
        this.kursNamn = kursNamn;
        this.klasslista = klasslista;
        this.lärare = lärare;
    }

    public String getKursNamn() {
        return kursNamn;
    }

    public void setKursNamn(String kursNamn) {
        this.kursNamn = kursNamn;
    }

    public Student[] getKlasslista() {
        return klasslista;
    }

    public void setKlasslista(Student[] klasslista) {
        this.klasslista = klasslista;
    }

    public Lärare getLärare() {
        return lärare;
    }

    public void setLärare(Lärare lärare) {
        this.lärare = lärare;
    }

    public void skrivUt() {
        System.out.printf("Kursnamn: %s\nLärare: %s\n\nStudenter:\n",kursNamn,lärare.getNamn());

        for(Student s:klasslista){
            if(s==null){
                break;
            }
            System.out.printf("%s, %s, %s\n",s.getNamn(),s.getAdress(),s.getFödelsedatum());
        }
        System.out.println("\n_______________________");
    }
}
