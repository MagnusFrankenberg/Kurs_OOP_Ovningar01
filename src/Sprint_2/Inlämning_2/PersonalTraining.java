package Sprint_2.Inlämning_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonalTraining {

    protected Boolean isTest;
    public String filename = "src/Sprint_2/Inlämning_2/trainingHistory.txt";

    public PersonalTraining(Boolean isTest) {
        this.isTest = isTest;
    }

    //skriver gymbesök till fil (person p + Localdate.now) (+testdatum)
    public boolean writeTrainingSessionToFile(Person p, LocalDate nowDateAsTest){
        boolean wasWritten;
        LocalDate trainingDate;
        if(isTest){
            trainingDate = nowDateAsTest;
        }else{
            trainingDate = LocalDate.now();
        }
        String printString = String.format("%s, %s, %s",
                                            p.getName(),
                                            p.getPersonnummer(),
                                            trainingDate.toString());

        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename,true)))){
            out.println(printString);
            if(isTest)
                System.out.println(printString);
            wasWritten = true;
        }catch (Exception e){
            wasWritten = false;
            System.out.println("Fel uppstod, Gymbesöket kunde inte registreras");
        }
        return wasWritten;
    }


}
