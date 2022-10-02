package Sprint_1.Uppgift_3d;

public class Deltagande {

    private Student student;
    private Kurs kurs;


    public Deltagande(Student student, Kurs kurs) {
        this.student = student;
        this.kurs = kurs;
    }

    public Student getStudent() {
        return student;
    }

    public Kurs getKurs() {
        return kurs;
    }

}
