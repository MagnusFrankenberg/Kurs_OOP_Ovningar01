package Sprint_1.Uppgift_4a;


    import java.time.LocalDate;

    public class Kurstillfälle extends Deltagande{

        LocalDate datum;
        Boolean ärNärvarande;

        public Kurstillfälle(LocalDate datum,Student student, Kurs kurs) {
            super(student, kurs);
            this.datum = datum;
        }

        public LocalDate getDatum() {
            return datum;
        }

        public void setDatum(LocalDate datum) {
            this.datum = datum;
        }

        public Boolean getÄrNärvarande() {
            return ärNärvarande;
        }

        public void setÄrNärvarande(Boolean ärNärvarande) {
            this.ärNärvarande = ärNärvarande;
        }
    }