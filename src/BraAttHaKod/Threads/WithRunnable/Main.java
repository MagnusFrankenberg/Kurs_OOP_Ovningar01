package BraAttHaKod.Threads.WithRunnable;

public class Main {

    public static void main(String[] args) {
        Thread myRunnableTread = new Thread(new MyRunnable());
        myRunnableTread.start();
    }
}
