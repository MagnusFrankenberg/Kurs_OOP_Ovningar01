package Sprint_3.Uppgift_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class TextEditor extends JFrame implements ActionListener {

    String dirpath = "src/Sprint_3/Uppgift_4/";


    JPanel bottomPane = new JPanel();
    JPanel buttonPane = new JPanel();
    JTextArea tarea = new JTextArea(20, 40);
    JScrollPane scrollp = new JScrollPane(tarea);

    JLabel labfilename = new JLabel("Filnamn");
    JTextField tffilename = new JTextField();
    JButton butOpen = new JButton("Öppna");
    JButton butSave = new JButton("Spara");
    JButton butPrint = new JButton("Skriv ut");
    JButton butQuit = new JButton("Avsluta");


    public TextEditor() {

        bottomPane.setLayout(new BorderLayout());
        add(bottomPane);

        buttonPane.setLayout(new GridLayout(1, 6));
        bottomPane.add(buttonPane, BorderLayout.NORTH);
        bottomPane.add(scrollp, BorderLayout.CENTER);

        buttonPane.add(labfilename);
        buttonPane.add(tffilename);
        buttonPane.add(butOpen);
        buttonPane.add(butSave);
        buttonPane.add(butPrint);
        buttonPane.add(butQuit);

        butOpen.addActionListener(this);
        butSave.addActionListener(this);
        butPrint.addActionListener(this);
        butQuit.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void openTextFromFile() {

        String filename = dirpath + tffilename.getText();
        try {
            tarea.read(new FileReader(filename), null);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Kunde inte hitta filen, kontrollera filnamnet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveTextToFile(){
        String filename = dirpath+tffilename.getText();
        try{
            tarea.write(new FileWriter(filename));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void textToPrinter(){
        try {
            tarea.print();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj.equals(butOpen)) {
            openTextFromFile();
        } else if (obj.equals(butSave)) {
            saveTextToFile();
        } else if (obj.equals(butPrint)) {
            textToPrinter();
        } else if (obj.equals(butQuit)) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        TextEditor te = new TextEditor();
    }
}
