package Sprint_4.Uppg_15a;

public interface Queable <T>{
/*
  Generics, kö-klass
  Gör ett generiskt kö-interface med följande metoder:
    • put
    • take
    • size
    Skriv den implementerande kö-klassen
 */

    public void put(T content);
    public T take();
    public int size();

}
