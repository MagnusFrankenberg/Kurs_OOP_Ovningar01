package Sprint_4.Uppg_9;

public class Protokoll {

    protected static final int WAITING = 0;
    protected static final int SENTRIDDLE1 = 1;
    protected static final int SENTRIDDLE2 = 2;
    protected static final int SENTRIDDLE3 = 3;
    protected static final int AGAIN = 4;

    protected int state = 0;

    String[] riddles = {"Vad är det för farkost som läses likadant framifrån som bakifrån?",
            "Var har havet ingen bölja, floden inget vatten, skogen inga träd, bergen inga höjder och staden inga hus?",
            "Vem är stackaren som blir både plundrad och utkastad?"};

    String[] answers = {"kajak", "på kartan", "julgranen"};

    public String processInput(String input) {
        String output = "";
        if (state == WAITING) {
            output = riddles[0];
            state = SENTRIDDLE1;
        } else if (state == SENTRIDDLE1) {
            if (input.equalsIgnoreCase(answers[0])) {
                output = "Rätt!  " + riddles[1];
                state = SENTRIDDLE2;
            } else {
                output = "Fel!, försök igen.  " + riddles[0];
            }
        } else if (state == SENTRIDDLE2) {
            if (input.equalsIgnoreCase(answers[1])) {
                output = "Rätt!  " + riddles[2];
                state = SENTRIDDLE3;
            } else {
                output = "Fel!, försök igen.  " + riddles[1];
            }
        } else if (state == SENTRIDDLE3) {
            if (input.equalsIgnoreCase(answers[2])) {
                output = "Grattis! Du har svarat rätt på alla 3 Gåtor. Spela igen?(y/n)";
                state = AGAIN;
            } else {
                output = "Fel!, försök igen.  " + riddles[2];
            }
        } else if (state == AGAIN) {
            if (input.equalsIgnoreCase("y")) {
                output = "Då kör vi igen!  " + riddles[0];
                state = SENTRIDDLE1;
            } else if (input.equalsIgnoreCase("n")) {
                output = "Hej Då";
            } else {
                output = "Ogiltig input, Vill du spela igen?   Press (y) for yes, (n) for no";
            }
        }
        return output;
    }
}
