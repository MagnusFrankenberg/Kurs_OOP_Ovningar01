package Sprint_3.Uppgift_14c;

public class Consumer implements Runnable{

    int time;
    MyQueue q;

    public Consumer(int time, MyQueue q) {
        this.time = time;
        this.q = q;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                String s = (String) q.take();
                System.out.println("Konsumenten tar ut " + s);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}
