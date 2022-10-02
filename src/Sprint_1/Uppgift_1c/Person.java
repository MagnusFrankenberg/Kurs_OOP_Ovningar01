package Sprint_1.Uppgift_1c;



public class Person{
    private String namn;
    private String adress;
    private int ålder;

    public Person(){}
    public Person(String namn, String adress,int ålder){
        this.namn = namn;
        this.adress = adress;
        this.ålder = ålder;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setÅlder(int ålder) {
        this.ålder = ålder;
    }
    public String getNamn(){
        return namn;
    }

    public String getAdress() {
        return adress;
    }

    public int getÅlder() {
        return ålder;
    }





}
