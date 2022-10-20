package Sprint_2.Uppgift_12;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
    }

    public Main() {
        ListManager lm = new ListManager();
        lm.addObjectsToList();

        int antalobjekt = lm.getFordonList().size();
        JOptionPane.showMessageDialog(null, "Du har skapat " + antalobjekt + " objekt");

        String s = "Dina Objekt är:\n";
        for (Fordon fd : lm.getFordonList())
            s+=fd.printMe()+"\n";
            JOptionPane.showMessageDialog(null,s);


        SerializeObjects so = new SerializeObjects();
        String filename = "src/Sprint_2/Uppgift_12/myFordon.ser";
        so.serialize(lm.getFordonList(),filename);

        JOptionPane.showMessageDialog(null, "Tömmer listan på innehåll");
        lm.getFordonList().clear();
        JOptionPane.showMessageDialog(null, "Listan har nu storleken: "+lm.getFordonList().size());

        DeserializeObjects dso = new DeserializeObjects();
        lm.fordonList.addAll(dso.deserialize(filename));

        JOptionPane.showMessageDialog(null,"Deserialisering har utförts\n" +
                "Listan har nu storleken "+lm.getFordonList().size());


        String s2 = "Efter Deserialisering,\nDina objekt är:\n\n";
        for (Fordon fd : lm.getFordonList())
            s2+=fd.printMe()+"\n";
        JOptionPane.showMessageDialog(null,s2);





    }


}
