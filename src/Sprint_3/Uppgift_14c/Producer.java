package Sprint_3.Uppgift_14c;

public class Producer implements Runnable {


    String s;
    int time;
    MyQueue q;

    public Producer(String s, int time,MyQueue q) {
        this.s = s;
        this.time = time;
        this.q = q;
    }

    @Override
    public void run() {
        int count = 1;
        while (!Thread.interrupted()) {
            try {
                q.put(s+": "+count);
                System.out.println("Producenten lägger in " + s+": "+count);
                Thread.sleep(time);
                count++;
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
