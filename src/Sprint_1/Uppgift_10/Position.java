package Sprint_1.Uppgift_10;

public enum Position {

    LEVEL_1("Verkställande Direktör"),
    LEVEL_2("Direktör"),
    LEVEL_3("Senior Manager"),
    LEVEL_4("Senior Specialist"),
    LEVEL_5("Manager"),
    LEVEL_6("Specialist"),
    LEVEL_7("Junior Manager"),
    LEVEL_8("Regular staff"),
    LEVEL_9("Probation");

        public final String level;
        Position(String s){
            level = s;
        }
    }

