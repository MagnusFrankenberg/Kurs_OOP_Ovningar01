package Sprint_4.Uppg_10;

public class Protokoll {

    protected final int INITIAL = 0;
    protected final int INTHELOOP = 1;

    protected int state = INITIAL;

    Person person = null;
    databas db = new databas();
    public Object getOutput(String clientRequest){

        if(state==INITIAL){
            state = INTHELOOP;
            return new Intro();
        }else if(state==INTHELOOP){

            if((person = db.getPerson(clientRequest.trim()))!=null){
                return new Respons(person,true);
            } else {
                return new Respons(null, false);
            }
        }
            return "unexpected state error";
    }


}
