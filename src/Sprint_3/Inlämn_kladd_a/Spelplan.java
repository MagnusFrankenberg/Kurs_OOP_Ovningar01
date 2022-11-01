package Sprint_3.Inlämn_kladd_a;

import java.util.*;


public class Spelplan{


    List<Bricka> brickor;
    List<Position> positioner;

    int storlek;  //antal rutor på varje sida
    int antalRutor; //totalt antal rutor på spelplanen


    Comparator<Position> c = new Comparator(){
        @Override
        public int compare(Object o1, Object o2) {
            if(((Position)o1).getNumber()>((Position)o2).getNumber()) return -1;
            if(((Position)o1).getNumber()<((Position)o2).getNumber()) return 1;
            return 0;
        }
    };



    //constructor som tar in spelplanens storlek(antal rutor på varje sida)
    //skapar lista med positioner
    //skapar numrerade brickor som kopplas till en position på spelplanen
    public Spelplan(int storlek) {
        this.storlek = storlek;
        this.antalRutor = storlek * storlek;
        this.positioner = createPositioner();
        this.brickor = createBrickor();
        putBrickorOnPositions();
        Collections.sort(this.positioner,c);


       // printBrickor();
    }



    //skapa upp numrerade brickor och lägg i lista, shuffle för slumpmässighet.
    //lägg till brickor på slumpartade positioner
    public List<Bricka> createBrickor() {
        List<Bricka> bricklist = new ArrayList<>();
        for (int i = 1; i <= (antalRutor - 1); i++) {
            bricklist.add(new Bricka(i));
        }
        return bricklist;
    }

    public void putBrickorOnPositions(){
        //lägg bricka på slumpartad position
        Collections.shuffle(brickor);
        Collections.shuffle(positioner);
        for (int i = 0; i < brickor.size(); i++) {
            positioner.get(i).setBricka(brickor.get(i));
        }
    }



    //Skapa upp Position-objekt och lägg i lista
    public List<Position> createPositioner() {
        int number = 1;
        List<Position> list = new ArrayList<>();
        for (int i = 1; i <= storlek; i++) {
            for (int j = 1; j <= storlek; j++) {
                Position p = new Position(i, j, number);
                list.add(p);
                number++;
            }
        }
        return list;
    }

    //kontrollerar om en position är en möjlig ny position jämfört med nuvarande position
    public boolean isPossibleNewPosition(Position nowP, Position newP) {
        boolean inomSpelplan = false;
        boolean oldTillNewOK = false;

        //finns positionen på spelplan?
        for (Position p : positioner) {
            if (p.getNumber()==newP.getNumber())
                inomSpelplan = true;
        }

        //ligger ny position bredvid nuvarande position?
        if (newP.getCol() == nowP.getCol()) {
            if (Math.abs(newP.getRow() - nowP.getRow()) == 1) {
                oldTillNewOK = true;
            }
        } else if (newP.getRow() == nowP.getRow()) {
            if (Math.abs(newP.getCol() - nowP.getCol()) == 1) {
                oldTillNewOK = true;
            }
        }
        return inomSpelplan && oldTillNewOK;
    }

    public Position findEmptyPosition(){
        Position emptyPosition=null;
        for(Position p:positioner){
            if(p.getBricka()==null)
                emptyPosition = p;
        }
        return emptyPosition;
    }


    public String printBrickor() {
        int count = 0;
        String s="";
        for (Position p: positioner) {
            if(p.getBricka()==null){
                System.out.println(count+":             Position:"+p.getNumber());
                s+=String.format("%d:                   Position:%d\n",count,p.getNumber());
            }else {
                System.out.print(count + ":  ");
                System.out.println("BrickNo: " + p.getBricka().getBricknummer() + " Position:" + p.getNumber());
                s+=String.format("%d:  BrickNo: %d  Position: %d\n",count,p.getBricka().getBricknummer(),p.getNumber());
                count++;
            }
        }
        System.out.println("_________________________");
        return s;
    }



        public static void main (String[]args){
            Spelplan sp = new Spelplan(4);
        }



}












