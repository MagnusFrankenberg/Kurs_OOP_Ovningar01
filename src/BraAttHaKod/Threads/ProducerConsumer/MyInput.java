package BraAttHaKod.Threads.ProducerConsumer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MyInput {

    MyQueue queue;
    int antalProducenter;
    int antalKonsumenter;

    List<Producer> producers;
    List<Consumer> consumers;


    public MyInput(MyQueue queue) {
        this.queue = queue;

        antalProducenter = Integer.parseInt(JOptionPane.showInputDialog("Ange antal producenter"));
        antalKonsumenter = Integer.parseInt(JOptionPane.showInputDialog("Ange antal konsumenter"));

        producers = createProducers();
        consumers = createConsumers();
    }

    public List<Producer> createProducers(){
        List<Producer> producerList = new ArrayList<>();
        for (int i = 0; i < antalProducenter; i++) {
            int intervall = Integer.parseInt(JOptionPane.showInputDialog(null,"Med vilket intervall ska Producent "+(i+1)+" lägga saker i kön?","Producent nr: "+(i+1),3));
            String ord = JOptionPane.showInputDialog(null,"Vilket ord ska läggas i kön?","Producent nr: "+(i+1),3);
            producerList.add(new Producer(ord,intervall,queue));
        }
        return producerList;
    }

    public List<Consumer> createConsumers(){
        List<Consumer> consumerList = new ArrayList<>();
        for (int i = 0; i < antalKonsumenter; i++) {
            int intervall = Integer.parseInt(JOptionPane.showInputDialog(null,"Med vilket intervall ska Konsument "+(i+1)+"plocka saker från kön?","Konsument nr: "+(i+1),3));
            consumerList.add(new Consumer(intervall,queue));
        }
        return consumerList;
    }

}


