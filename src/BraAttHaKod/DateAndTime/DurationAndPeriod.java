package BraAttHaKod.DateAndTime;

import java.time.*;

public class DurationAndPeriod {


    public DurationAndPeriod(){

        //Duration mäter tid i sekunder och nanosekunder
        //Period mäter tid i år, månader och dagar

        LocalDate ld1 = LocalDate.of(2022,10,18);
        LocalTime lt1 = LocalTime.of(13,45,46);
        LocalDateTime ldt1 = LocalDateTime.of(ld1,lt1);

        LocalDate ld2 = LocalDate.of(2022,10,18);
        LocalTime lt2 = LocalTime.of(13,55,56);
        LocalDateTime ldt2 = LocalDateTime.of(ld2,lt2);

        //Duration
        Duration d = Duration.between(ldt1,ldt2);
        System.out.println(d);

        Duration d2 = Duration.ofHours(2);
        Duration d3 = Duration.ofSeconds(25);
        Duration d4 = Duration.ofMinutes(3);

        System.out.println(d.getSeconds());


        LocalDate ld3 = LocalDate.of(2022,10,18);
        LocalDate ld4 = LocalDate.of(2022,12,28);

        //Period
        Period p = Period.between(ld3,ld4);
        System.out.println(p);
        System.out.println(p.getMonths());
        System.out.println(p.getDays());

        Period p1 = Period.ofDays(16);
        Period p2 = Period.ofMonths(3);
        Period p3 = Period.ofYears(5);

        LocalDate ld5 = ld4.plusMonths(4);
        System.out.println(ld5);

    }









    public static void main(String[] args) {
        DurationAndPeriod dp = new DurationAndPeriod();
    }
}
