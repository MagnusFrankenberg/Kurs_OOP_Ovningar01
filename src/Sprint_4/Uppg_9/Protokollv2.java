package Sprint_4.Uppg_9;

public class Protokollv2 {

    protected static final int WAITING = 0;
    protected static final int SENTRIDDLE = 1;
    protected static final int AGAIN = 4;

    protected int state = 0;
    protected int currentriddle=0;

    protected int currentanswer=0;

    String[] riddles = {"Vad är det för farkost som läses likadant framifrån som bakifrån?",
            "Var har havet ingen bölja, floden inget vatten, skogen inga träd, bergen inga höjder och staden inga hus?",
            "Vem är stackaren som blir både plundrad och utkastad?",
            "Vem har flest människor till middag?",
            "Vem har hals men inget huvud?"};

    protected int numberOfRiddles = riddles.length;
    String[] answers = {"kajak", "på kartan", "julgranen","kannibalen","flaskan"};

    public String processInput(String input) {
        String output = "";
        if (state == WAITING) {
            output = riddles[currentriddle];
            state = SENTRIDDLE;
        } else if (state == SENTRIDDLE) {
            if (input.equalsIgnoreCase(answers[currentanswer])) {
                currentanswer++;
                currentriddle++;
                if(currentriddle<numberOfRiddles) {
                    output = "Rätt!  " + riddles[currentriddle];
                    state = SENTRIDDLE;
                }else {
                    output = "Grattis! Du har svarat rätt på alla "+numberOfRiddles+" Gåtor. Spela igen?(y/n)";
                    state = AGAIN;
                }
            } else {
                output = "Fel!, försök igen.  " + riddles[currentriddle];
            }
        } else if (state == AGAIN) {
            if (input.equalsIgnoreCase("y")) {
                currentriddle = 0;
                currentanswer = 0;
                output = "Då kör vi igen!  " + riddles[currentriddle];
                state = SENTRIDDLE;
            } else if (input.equalsIgnoreCase("n")) {
                output = "Hej Då";
            } else {
                output = "Ogiltig input, Vill du spela igen?   Press (y) for yes, (n) for no";
            }
        }
        return output;
    }
}



