package Sprint_4.Uppg_6;

import java.util.List;

public class databas {




    Person p1 = new Person("Magnus","Hornsgatan 90","0704975884","19790706");
    Person p2 = new Person("Lisa","Götgatan 3","0714546454","19670423");
    Person p3 = new Person("Edwin","Skånegatan 45","0722323456","20021212");
    Person p4 = new Person("Santi","Krukmakargatan 34","0734556789","19940607");
    Person p5 = new Person("Greta","Tavastgatan 16","0741234567","19871127");
    Person p6 = new Person("Hanna","Brännkyrkagatan 2","0729875432","19760901");

    List<Person> personList = List.of(p1,p2,p3,p4,p5,p6);

    public databas(){
    }

    public Person getPerson(String namn){
        for(var p:personList){
            if(p.namn.equals(namn)){
                return p;
            }
        }
        return null;
    }


}
