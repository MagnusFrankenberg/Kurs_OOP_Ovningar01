package BraAttHaKod.Generics;

public class Main {

    public static void main(String[] args) {
        QueueClass<String> genericqueue = new QueueClass<>();
        genericqueue.put("Hej");
        genericqueue.put("Magnus");
        genericqueue.put("Frankenberg");

        System.out.println(genericqueue.size());
        System.out.println(genericqueue.take());
        System.out.println(genericqueue.size());
        System.out.println(genericqueue.take());
        System.out.println(genericqueue.size());
    }
}
