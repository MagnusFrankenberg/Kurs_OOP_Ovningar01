package Sprint_2.Inlämning_2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonalTrainingTest {

    boolean istest = true;
    PersonalTraining pT = new PersonalTraining(istest);


    @Test
    public void writeTrainingSessionToFile() {
        /*
        7911061234, Fritjoff Flacon
        2016-12-16
        7512166544, Greger Ganache
        2022-03-23
         */
        LocalDate nowDateAsYTest = LocalDate.of(2022, 10, 17);
        Person p1 = new Person("7911061234", "Fritjoff Flacon", LocalDate.of(2016, 12, 16));
        Person p2 = new Person("7512166544", "Greger Ganache", LocalDate.of(2022, 03, 23));

        assert (pT.writeTrainingSessionToFile(p1, nowDateAsYTest) == true);
        assert (pT.writeTrainingSessionToFile(p2, nowDateAsYTest) == true);
        assert (pT.writeTrainingSessionToFile(p2, nowDateAsYTest) != false);

    }
}