package Sprint_2.Inlämning_2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GymReception {

    protected Boolean isTest;
    protected PersonalTraining pt;


    //skapar instans av main, kör programmet i icke-test läge
    public static void main(String[] args) {
        GymReception g = new GymReception(false);
    }

    //konstruktor med isTest-parameter som bestämmer om programmet ska köras i test-läge eller ej
    public GymReception(boolean isTest) {
        this.isTest = isTest;
        pt = new PersonalTraining(isTest);

        //om ej test kör programmet:
        if (!isTest) {

            String filename1 = "src/Sprint_2/Inlämning_2/customers.txt";
            CustomerLists c1 = new CustomerLists();
            c1.customerList = new ArrayList<>(readFiletoList(filename1));

            while (true) {
                String input = takeInput(null);
                String output = getCustomerPaymentStatus(c1.customerList, input, null);
                System.out.println(output);
            }
        }
    }

    //utför String.trim på 2 strings i array som tas in
    public String[] trimArray(String[] s) {
        String temp;
        String[] out = new String[2];
        for (int i = 0; i < s.length; i++) {
            temp = s[i].trim();
            out[i] = temp;
        }
        return out;
    }


    // converterar sträng till LocalDate
    public LocalDate stringToDate(String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        return date;
    }


    // skapar upp ett Personobjekt
    public Person createOnePerson(String firstRow, String secondRow) {
        String[] row1 = firstRow.split(",");
        row1 = trimArray(row1);

        LocalDate row2 = stringToDate(secondRow);

        Person p = new Person(row1[0], row1[1], row2);
        return p;
    }


    //läser txt-fil och lägger skapade personobjekt i lista
    public List<Person> readFiletoList(String filename) {
        List<Person> lista = new ArrayList<>();
        String row1;
        String row2;
        try (BufferedReader buf = new BufferedReader(new FileReader(filename))) {
            while ((row1 = buf.readLine()) != null && (row2 = buf.readLine()) != null) {
                lista.add(createOnePerson(row1, row2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


    //kontrollerar om senaste betalning fortfarande är giltig (+testdatum)
    public Boolean annualPaymentValid(Person p, LocalDate nowDateAsTest) {
        LocalDate currentDate;
        if (this.isTest) {
            currentDate = nowDateAsTest;
        } else {
            currentDate = LocalDate.now();
        }

        LocalDate dateOneYearAgo = currentDate.minusYears(1);
        LocalDate lastPaymentDate = p.getSenastBetaldAvgift();

        if (lastPaymentDate.isBefore(dateOneYearAgo)) {
            return false;
        } else {
            return true;
        }
    }

    //returnerar String med status på gymbesökare + registrerar kundbesök för giltig kund (+testdatum)
    public String getCustomerPaymentStatus(List<Person> plist, String input, LocalDate nowDateAsTest) {
        String s = "";
        Boolean foundperson = false;
        for (Person p : plist) {
            if (p.getPersonnummer().equals(input) || p.getName().equals(input)) {
                foundperson = true;
                if (annualPaymentValid(p, nowDateAsTest)) {
                    s = p.toString() + " är en nuvarande kund (giltig betalningsstatus).\n";
                    if(pt.writeTrainingSessionToFile(p, nowDateAsTest))
                        s+="Gymbesök Registrerat\n";
                } else {
                    s = p.toString() + " är en före detta kund (ogiltig betalningsstatus).\n";
                }
            }
        }
        if (foundperson == false)
            s = "Kunde inte hitta någon person med angivet namn eller personnummer (obehörig!)\n";
        return s;
    }

    //returnerar input från system.in eller från test.
    public String takeInput(String testInput) {
        String input = null;
        Scanner sc;
        if (isTest) {
            sc = new Scanner(testInput);
        } else {
            sc = new Scanner(System.in);
        }
        System.out.println("Ange namn eller personnummer (format: Förnamn Efternamn eller ÅÅMMDDXXXX");
        try {
            input = sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }
}