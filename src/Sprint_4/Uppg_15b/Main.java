package Sprint_4.Uppg_15b;

public class Main {

    public static void main(String[] args) {
        QueueClass<Integer> genericqueue = new QueueClass<>();
        genericqueue.put(12);
        genericqueue.put(45);
        genericqueue.put(76);

        System.out.println(genericqueue.size());
        System.out.println(genericqueue.take());
        System.out.println(genericqueue.size());
        System.out.println(genericqueue.take());
        System.out.println(genericqueue.size());
    }
}
