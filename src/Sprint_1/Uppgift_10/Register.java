package Sprint_1.Uppgift_10;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Register {


    List<Kund> kundLista = new ArrayList<>();
    List<Lån> lånLista = new ArrayList<>();
    List<Konto> kontoLista = new ArrayList<>();
    List<KundProdukt> kundProduktLista = new ArrayList<>();
    List<Avtalstillfälle> avtalstillfälleLista = new ArrayList<>();
    List<Anställd> anställdLista = new ArrayList<>();

    StödMetoder stödMetoder = new StödMetoder();

    private void skapaNyKund() {
        String namn = JOptionPane.showInputDialog("Ange För -och Efternamn");
        String adress = JOptionPane.showInputDialog("Ange Adress");
        String personnummer = null;
        boolean redanUpptaget = false;
        while (redanUpptaget) {
            redanUpptaget = false;
            personnummer = JOptionPane.showInputDialog("Ange personnummer YYYYMMDD-XXXX");
            for (Kund k : kundLista) {
                if (personnummer.equals(k.getPersonnummer())) {
                    JOptionPane.showMessageDialog(null, "Personnummer redan registrerat");
                    redanUpptaget = true;
                }
            }
        }
        kundLista.add(new Kund(namn, adress, personnummer));
    }

    private void skapaNyttLån() {

        //ta in lånetyp
        String[] options = {LåneTyp.BILLÅN.låneprodukt, LåneTyp.BOSTADSLÅN.låneprodukt,
                LåneTyp.KONSUMTIONSLÅN.låneprodukt, LåneTyp.FÖRETAGSLÅN.låneprodukt};
        int välja = JOptionPane.showOptionDialog(null, "Val av Lånetyp", "Lånetyper",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);

        LåneTyp låneTyp = null;
        switch (välja) {
            case 0 -> låneTyp = LåneTyp.BILLÅN;
            case 1 -> låneTyp = LåneTyp.BOSTADSLÅN;
            case 2 -> låneTyp = LåneTyp.KONSUMTIONSLÅN;
            case 3 -> låneTyp = LåneTyp.FÖRETAGSLÅN;
        }

        //ta in beloppet
        Boolean försökIgen = false;
        double belopp = 0;
        do {
            försökIgen = false;
            try {
                belopp = Double.parseDouble(JOptionPane.showInputDialog("Ange lånebelopp"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");
                försökIgen = true;
            }
        } while (försökIgen);

        //ta in räntesats
        försökIgen = false;
        double räntesats = 0;
        do {
            försökIgen = false;
            try {
                räntesats = Double.parseDouble(JOptionPane.showInputDialog("Ange räntesats i procent"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");
                försökIgen = true;
            }
        } while (försökIgen);

        //idnummer genereras
        String prefixLån = "01-";
        String idnummer = "";
        do {
            försökIgen = false;
            idnummer = stödMetoder.skapaIdNummer(prefixLån, 8);
            for (Lån l : lånLista) {
                if (idnummer.equals(l.getIdNummer())) {
                    försökIgen = true;
                }
            }
        } while (försökIgen);

        lånLista.add(new Lån(idnummer, låneTyp, belopp, räntesats));
    }

    private void skapaNyttKonto() {

        //ta in kontotyp
        String[] options = {KontoTyp.PERSONKONTO.kontoprodukt, KontoTyp.SPARKONTO.kontoprodukt,
                KontoTyp.FÖRMÖGENHETSKONTO.kontoprodukt, KontoTyp.VÄRDEPAPPERSKONTO.kontoprodukt,
                KontoTyp.INVESTERINGSSPARKONTO.kontoprodukt};
        int välja = JOptionPane.showOptionDialog(null, "Val av Kontotyp", "Kontotyper",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);

        KontoTyp kontoTyp = null;
        switch (välja) {
            case 0 -> kontoTyp = KontoTyp.PERSONKONTO;
            case 1 -> kontoTyp = KontoTyp.SPARKONTO;
            case 2 -> kontoTyp = KontoTyp.FÖRMÖGENHETSKONTO;
            case 3 -> kontoTyp = KontoTyp.VÄRDEPAPPERSKONTO;
            case 4 -> kontoTyp = KontoTyp.INVESTERINGSSPARKONTO;
        }

        //ta in belopp
        Boolean försökIgen = false;
        double belopp = 0;
        do {
            försökIgen = false;
            try {
                belopp = Double.parseDouble(JOptionPane.showInputDialog("Ange belopp att sätta in"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");
                försökIgen = true;
            }
        } while (försökIgen);

        //ta in räntesats
        försökIgen = false;
        double räntesats = 0;
        do {
            försökIgen = false;
            try {
                räntesats = Double.parseDouble(JOptionPane.showInputDialog("Ange räntesats i procent"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Otillåten input, försök igen");
                försökIgen = true;
            }
        } while (försökIgen);

        //generera idnummer (=kontonummer)
        String prefixKonto = "02-";
        String idnummer = "";
        do {
            försökIgen = false;
            idnummer = stödMetoder.skapaIdNummer(prefixKonto, 8);
            for (Konto k : kontoLista) {
                if (idnummer.equals(k.getIdNummer())) {
                    försökIgen = true;
                }
            }
        } while (försökIgen);

        kontoLista.add(new Konto(idnummer, kontoTyp, belopp, räntesats));
    }


    private void skapaNyKundProdukt() {

        //Ny eller existerande kund?
        String[] options = {"Ny Kund", "Existerande kund"};
        int välja = JOptionPane.showOptionDialog(null, "Ny eller existerande kund?", "Skapa Ny Kundprodukt",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);

        Kund kund = null;
        //skapa ny kund först
        if (välja == 0) {
            skapaNyKund();
            kund = kundLista.get(kundLista.size() - 1);
        }
        //hitta existerande kund
        if (välja == 1) {
            Boolean försökIgen = false;
            do {
                försökIgen = false;
                String persnr = JOptionPane.showInputDialog("Ange personnummer på redan registrerad kund (YYYYMMDD-XXXX)");
                for (Kund k : kundLista) {
                    if (persnr.equals(k.getPersonnummer())) {
                        kund = k;
                    } else {
                        JOptionPane.showMessageDialog(null, "Kunde inte hitta någon kund med personnummer: " + persnr);
                        försökIgen = true;
                    }
                }
            } while (försökIgen);
        }
        //skapa ny produkt
        Bankprodukt bankprodukt = null;
        String[] options2 = {"Nytt Konto", "Nytt Lån"};
        int välja2 = JOptionPane.showOptionDialog(null, "Vilken typ av produkt ska skapas?", "Skapa Ny Kundprodukt",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, 0);

        switch (välja2) {
            case 0: {
                skapaNyttKonto();
                bankprodukt = kontoLista.get(kontoLista.size()-1);
                break;
            }
            case 1: {
                skapaNyttLån();
                bankprodukt = lånLista.get(lånLista.size()-1);
                break;
            }
        }
        kundProduktLista.add(new KundProdukt(kund,bankprodukt));
    }

    public void skapaNyttAvtalstillfälle(){
        String[] options3 = {"Ja", "Nej"};
        int välja3 = JOptionPane.showOptionDialog(null, "Vill du gå vidare och skapa ett nytt avtal", "Skapa Nytt Avtal",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options3, 0);

        if(välja3==1) {
            return;
        }


        //gäller avtalet befintlig eller ny KundProdukt?
        String[] options4 = {"Befintlig", "Ny"};
        int välja4 = JOptionPane.showOptionDialog(null, "Gäller detta avtal en befintlig eller ny Kundprodukt?", "Skapa Nytt Avtal",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options4, 0);






        //Lägg in felhantering
        LocalDate datum = LocalDate.parse(JOptionPane.showInputDialog("Ange datum för avtalets verkställande"));






    }

}


