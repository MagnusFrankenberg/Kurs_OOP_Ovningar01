package BraAttHaKod.DateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateAndTime {

    public DateAndTime(){

        //current Date and time in nanosec, greenwich,  not adjusted for Localality
        Instant i = Instant.now();
        System.out.println(i);

        //Below takes computer date/time

        LocalTime lt = LocalTime.now();
        LocalTime lt2 = LocalTime.of(13,45,56);
        LocalTime lt3 = LocalTime.parse("14:45:55");

        System.out.println(lt3);

        LocalDate ld = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2022,10,18);
        LocalDate ld3 = LocalDate.parse("2018-03-12");
        System.out.println(ld3);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);


        //gives an ugly print, so needs some formatting....
        LocalDateTime ldt2 = LocalDateTime.of(ld3,lt3);
        System.out.println(ldt2);



        //To get a certain pattern use:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY MM dd");
        System.out.println(dtf.format(ldt2));

        // and including time as well:
        System.out.println(DateTimeFormatter.ofPattern("YYYY MM dd : HH mm ss").format(ldt2));

        ZoneId zId = ZoneId.of("CET");
        ZonedDateTime zdt = ZonedDateTime.of(ld2,lt2,zId);
        System.out.println(zdt);

        ZoneId zId2 = ZoneId.of("America/Toronto");
        TimeZone tz = TimeZone.getTimeZone("America/Toronto");
        ZonedDateTime zdt2 = ZonedDateTime.of(ld2,lt2,zId2);
        System.out.println(zdt2);


        //Få nuvarande tid baserat på tidszon, exempel
        Instant nowUtc = Instant.now();
        ZoneId americaToronto = ZoneId.of("America/Toronto");
        ZonedDateTime nowAmericaToronto = ZonedDateTime.ofInstant(nowUtc, americaToronto);
        System.out.println(nowUtc);
        System.out.println(nowAmericaToronto);




    }












    public static void main(String[] args) {
        DateAndTime d = new DateAndTime();
    }
}
