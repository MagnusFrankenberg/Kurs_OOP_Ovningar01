package Sprint_1.Uppgift_3a;


public class Student extends Person {

    Kurs[] studentensKurser = new Kurs[100];

    public Student(String namn, String adress, String födelsedatum) {
        super(namn, adress, födelsedatum);
    }

    public Kurs[] getStudentensKurser() {
        return studentensKurser;
    }

    public void setStudentensKurser(Kurs kurs) {
        for (int i = 0; i < studentensKurser.length; i++) {
            if(studentensKurser[i]==null){
                studentensKurser[i]=kurs;
                break;
            }
        }
    }

    public void skrivUt() {
        System.out.printf("Studentens namn: %s\n",getNamn());

        for(Kurs k:studentensKurser){
            if(k==null){
                break;
            }
            System.out.printf("Kurs: %s, Lärare: %s\n",k.getKursNamn(),k.getLärare().getNamn());
        }
        System.out.println("\n_______________________");
    }


}

