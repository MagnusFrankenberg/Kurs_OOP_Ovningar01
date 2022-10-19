package Sprint_2.Uppgift_11;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class VideoTapeCheckTest {

    VideoTapeCheck vtc = new VideoTapeCheck(true);

    @Test
    void takeUserTimeInput() {

        String m = "Ange tid då TV-programmet börjar (tt:mm)";
        String testinput = "14:45";

        assert (vtc.takeUserTimeInput(m,testinput).equals(LocalTime.of(14,45)));
        assert (!vtc.takeUserTimeInput(m,testinput).equals(LocalTime.of(14,34)));
    }

    @Test
    void takeUserDurationInput() {
        String m = "Ange videobandets längd (hela minuter)";
        String testinput = "34";

        assert (vtc.takeUserDurationInput(m,testinput).equals(Duration.of(34, ChronoUnit.MINUTES)));
        assert (!vtc.takeUserDurationInput(m,testinput).equals(Duration.of(22, ChronoUnit.MINUTES)));

    }


    @Test
    void tapeHasEnoughSpace() {

        /*
        public boolean tapeHasEnoughSpace(){
        Duration tapeTotalLength = takeUserDurationInput("Ange videobandets totala längd i minuter",null);
        Duration alreadyUsedMinutes = takeUserDurationInput("Ange redan använt utrymme på bandet i minuter", null);
        Duration freeMinutesOnTape = tapeTotalLength.minus(alreadyUsedMinutes);

        LocalTime TVshowStartTime = takeUserTimeInput("Ange tid då TV-programmet startar (tt:mm)",null);
        LocalTime TVshowEndTime = takeUserTimeInput("Ange tid då TV-programmet slutar (tt:mm)",null);
        Duration TVshowDuration = Duration.between(TVshowStartTime,TVshowEndTime);

        boolean isEnoughspace = (freeMinutesOnTape.get(ChronoUnit.MINUTES) >= TVshowDuration.get(ChronoUnit.MINUTES));
        return isEnoughspace;
    }
         */
        String totallängd = "180";
        String redananvänt = "100";
        String starttid = "13:05";
        String sluttid1 = "14:05";
        String sluttid2 = "15:35";

        assert (vtc.tapeHasEnoughSpace(totallängd,redananvänt,starttid,sluttid1)==true);
        assert (vtc.tapeHasEnoughSpace(totallängd,redananvänt,starttid,sluttid2)==false);



    }
}