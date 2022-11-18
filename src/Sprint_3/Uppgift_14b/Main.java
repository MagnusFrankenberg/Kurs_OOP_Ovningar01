package Sprint_3.Uppgift_14b;

public class Main {

    public static void main(String[] args) {

        MyQueue q1 = new MyQueue();

        Producer p1 = new Producer("Kaka nr",700,q1);
        Consumer c1 = new Consumer(2000,q1);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);

        t1.start();
        t2.start();

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            System.out.println("Ett exception hände");
        }

        t1.interrupt();
        t2.interrupt();

        System.out.println("Det finns "+ q1.leftInQueue()+" kakor kvar i kön");
        q1.printQueue();



    }
}
