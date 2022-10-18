package Sprint_2.Inlämning_2;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class GymReceptionTest {

    boolean istest = true;


    GymReception gr = new GymReception(istest);


    @Test
    public void trimArrayTest() {
        String[] s = {"7703021234", " Alhambra Aromes"};

        assert (gr.trimArray(s)[0].length() == 10);
        assert (gr.trimArray(s)[0].charAt(9) == '4');
        assert (gr.trimArray(s)[1].length() == 15);
        assert (gr.trimArray(s)[1].charAt(0) == 'A');
        assert (gr.trimArray(s)[1].equals("Alhambra Aromes"));
        assert (gr.trimArray(s)[0].length() != 100);
    }


    @Test
    public void stringToDateTest() {
        String s = "2022-06-30";
        assert (gr.stringToDate(s).equals(LocalDate.parse("2022-06-30")));
        System.out.println(gr.stringToDate(s).getMonthValue());
        assert (gr.stringToDate(s).getMonthValue()==6);
        System.out.println(gr.stringToDate(s).getDayOfMonth());
        assert (gr.stringToDate(s).getDayOfMonth()==30);
        assert (gr.stringToDate(s).getDayOfMonth()!=200);
    }


    @Test
    public void createOnePerson(){
        String firstRow = "8512021234, Chamade Coriola";
        String secondRow = "2018-03-12";
        Person p = gr.createOnePerson(firstRow,secondRow);

        assert (p.getName().equals("Chamade Coriola"));
        assert (p.getPersonnummer().equals("8512021234"));
        assert (p.getSenastBetaldAvgift().equals(LocalDate.parse("2018-03-12")));
        assert (p.getName().equals("blablabla")==false);
        assert (p.getPersonnummer().equals("")==false);
        assert (p.getSenastBetaldAvgift().equals("")==false);

        System.out.println(gr.createOnePerson(firstRow,secondRow).toString());
    }



    @Test
    public void readFiletoListTest() {

        String filename = "src/Sprint_2/Inlämning_2/customers.txt";

        assert (gr.readFiletoList(filename).size()==14);
        assert (gr.readFiletoList(filename).get(0).getName().equals("Alhambra Aromes"));
        assert (gr.readFiletoList(filename).get(1).getName().equals("Bear Belle"));
        assert (gr.readFiletoList(filename).get(13).getName().equals("Nahema Ninsson"));
        assert (gr.readFiletoList(filename).get(5).getPersonnummer().equals("7911061234"));
        assert (gr.readFiletoList(filename).get(8).getPersonnummer().equals("8906138493"));
        assert (gr.readFiletoList(filename).get(13).getPersonnummer().equals("7805211234"));
        assert (gr.readFiletoList(filename).get(0).getSenastBetaldAvgift().toString().equals("2022-07-01"));
        assert (gr.readFiletoList(filename).get(13).getSenastBetaldAvgift().toString().equals("2022-08-04"));

        assert (gr.readFiletoList(filename).size()!=0);
        assert (gr.readFiletoList(filename).get(13).getName().equals("")==false);
        assert (gr.readFiletoList(filename).get(13).getPersonnummer().equals("")==false);
        assert (gr.readFiletoList(filename).get(13).getSenastBetaldAvgift().toString().equals("")==false);
    }



    @Test
    public void annualPaymentValidTest(){
        String firstRow = "8512021234, Chamade Coriola";
        String secondRow = "2018-03-12";
        Person p = gr.createOnePerson(firstRow,secondRow);

        String firstRow2 = "8512021234, Micke Mus";
        String secondRow2 = "2022-03-13";
        Person p2 = gr.createOnePerson(firstRow2,secondRow2);

        LocalDate testNowDate = LocalDate.of(2022,10,17); //freezing now-date to make test independent of when test is executed.

        assert (gr.annualPaymentValid(p,testNowDate)==false);
        assert (gr.annualPaymentValid(p2,testNowDate)==true);



    }


    @Test
    public void getCustomerPaymentStatusTest(){
        String filename = "src/Sprint_2/Inlämning_2/customers.txt";
        List<Person> list = gr.readFiletoList(filename);
        LocalDate testNowDate = LocalDate.of(2022,10,17); //freezing now-date to make test independent of when test is executed.
        //uttdrag från customers.txt
        //8512021234, Chamade Coriola
        //2018-03-12
        //7608021234, Diamanda Djedi
        //2022-01-30
        //7805211234, Nahema Ninsson
        //2022-08-04
        //8204021234, Bear Belle
        //2019-12-02

        System.out.println(gr.getCustomerPaymentStatus(list,"8512021234",testNowDate));
        System.out.println(gr.getCustomerPaymentStatus(list,"7608021234",testNowDate));
        System.out.println(gr.getCustomerPaymentStatus(list,"Nahema Ninsson",testNowDate));
        System.out.println(gr.getCustomerPaymentStatus(list,"Bear Belle",testNowDate));
        System.out.println(gr.getCustomerPaymentStatus(list,"xxx xxx",testNowDate));
        assert (gr.getCustomerPaymentStatus(list,"8512021234",testNowDate).equals("Chamade Coriola (8512021234) är en före detta kund (ogiltig betalningsstatus).\n"));
        assert (!gr.getCustomerPaymentStatus(list,"8512021234",testNowDate).equals("bla bla bla"));
    }

    @Test
    public void takeInputTest(){
        String testInput1 = "Bear Belle";
        String testInput2 = "7608021234";
        String testInput3 = "Nahema Ninsson";
        String testInput4 = "8512021234";

        assert (gr.takeInput(testInput1).equals("Bear Belle"));
        assert (gr.takeInput(testInput2).equals("7608021234"));
        assert (gr.takeInput(testInput3).equals("Nahema Ninsson"));
        assert (gr.takeInput(testInput4).equals("8512021234"));
        assert (!gr.takeInput(testInput1).equals("xxxxxx"));
    }







}
