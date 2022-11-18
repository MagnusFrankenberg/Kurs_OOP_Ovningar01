package BraAttHaKod.Threads.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Thread> myThreads = new ArrayList<>();

        MyQueue q1 = new MyQueue();
        MyInput myInput = new MyInput(q1);

        for (int i = 0; i < myInput.producers.size(); i++) {
            myThreads.add(new Thread(myInput.producers.get(i)));
        }

        for (int i = 0; i < myInput.consumers.size(); i++) {
            myThreads.add(new Thread(myInput.consumers.get(i)));
        }

        for (Thread t : myThreads) {
            t.start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Ett exception hände");
        }

        for (Thread t : myThreads) {
            t.interrupt();
        }

        System.out.println("Det finns " + q1.leftInQueue() + " objekt kvar i kön");
        q1.printQueue();


    }
}
