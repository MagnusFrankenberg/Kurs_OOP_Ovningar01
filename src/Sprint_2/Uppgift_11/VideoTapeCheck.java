package Sprint_2.Uppgift_11;


import javax.swing.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;



public class VideoTapeCheck {

    protected boolean isTest;


    public static void main(String[] args) {
        VideoTapeCheck vt = new VideoTapeCheck(false);
    }

    public VideoTapeCheck(boolean isTest) {
        this.isTest = isTest;

        if (!isTest) {
            if(tapeHasEnoughSpace(null, null, null, null)){
                JOptionPane.showMessageDialog(null,"Det finns tillräckligt med utrymme kvar på bandet!");
            }else{
                JOptionPane.showMessageDialog(null,"Tyvärr, videobandet kommer inte räcka");
            }
        }


    }

    public LocalTime takeUserTimeInput(String message, String testinput) {
        String input = null;
        LocalTime aTime = null;
        boolean tryagain = true;
        while (tryagain) {
            if (isTest) {
                input = testinput;
            } else {
                input = JOptionPane.showInputDialog(message);
            }
            try {
                aTime = LocalTime.parse(input);
                tryagain = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Otillåtet format på input");
            }
        }
        return aTime;
    }


    public Duration takeUserDurationInput(String message, String testinput) {
        String input = null;
        Duration aDuration = null;
        boolean tryagain = true;
        while (tryagain) {
            if (isTest) {
                input = testinput;
            } else {
                input = JOptionPane.showInputDialog(message);
            }
            try {
                int i = Integer.parseInt(input);
                aDuration = Duration.of(i, ChronoUnit.MINUTES);
                tryagain = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Otillåtet format på input");
            }
        }
        return aDuration;
    }


    public boolean tapeHasEnoughSpace(String vlength, String vleft, String start, String stop) {

        Duration tapeTotalLength = takeUserDurationInput("Ange videobandets totala längd i minuter", vlength);
        Duration alreadyUsedMinutes = takeUserDurationInput("Ange redan använt utrymme på bandet i minuter", vleft);
        Duration freeMinutesOnTape = tapeTotalLength.minus(alreadyUsedMinutes);

        LocalTime TVshowStartTime = takeUserTimeInput("Ange tid då TV-programmet startar (tt:mm)", start);
        LocalTime TVshowEndTime = takeUserTimeInput("Ange tid då TV-programmet slutar (tt:mm)", stop);
        Duration TVshowDuration = Duration.between(TVshowStartTime, TVshowEndTime);

        boolean isEnoughSpace = (freeMinutesOnTape.compareTo(TVshowDuration) >= 0);
        return isEnoughSpace;
    }

}
