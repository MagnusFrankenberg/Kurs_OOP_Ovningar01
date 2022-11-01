package Sprint_3.Uppgift_4b;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TextEditor extends JFrame implements ActionListener {

    String dirpath = "src/Sprint_3/Uppgift_4b/";
    String[] fileArray = new String[5];


    JPanel bottomPane = new JPanel();
    JPanel buttonPane = new JPanel();
    JTextArea tarea = new JTextArea(20, 40);
    JScrollPane scrollp = new JScrollPane(tarea);

    JLabel labfilename = new JLabel("Filnamn");
    JComboBox combofileChooser;

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

        readFileCache();
        combofileChooser = new JComboBox(fileArray);
        combofileChooser.setSelectedIndex(-1);
        combofileChooser.setEditable(true);


        buttonPane.add(labfilename);
        buttonPane.add(combofileChooser);
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

    public void readFileCache() {

        try (BufferedReader buf = new BufferedReader(new FileReader(dirpath + "filecache.txt"))) {
            int i = 0;
            while ((fileArray[i] = buf.readLine()) != null) {
                i++;
                if (i > 4)
                    break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFileCache(){
        try(PrintWriter ut = new PrintWriter(new BufferedWriter(new FileWriter(dirpath+"filecache.txt")))){
            for (int i = 0; i < 5; i++) {
                ut.println(fileArray[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateFileArray(){
        String shortfilename = combofileChooser.getSelectedItem().toString();
        String temp;
        for (int i = 4; i > 0; i--) {
            temp=fileArray[i-1];
            fileArray[i]=temp;
        }
        fileArray[0]=shortfilename;
    }

    public void openTextFromFile() {

        String filename = dirpath + combofileChooser.getSelectedItem().toString();
        try {
            tarea.read(new FileReader(filename), null);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Kunde inte hitta filen, kontrollera filnamnet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveTextToFile() {
        String filename = dirpath + combofileChooser.getSelectedItem().toString();
        try {
            tarea.write(new FileWriter(filename));
            updateFileArray();
            System.out.println(Arrays.toString(fileArray));
        } catch (Exception e) {
            e.printStackTrace();
        }
        revalidate();
        combofileChooser.revalidate();
        combofileChooser.repaint();
        repaint();

    }

    public void textToPrinter() {
        try {
            tarea.print();
        } catch (Exception e) {
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
            saveFileCache();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        TextEditor te = new TextEditor();
    }
}
