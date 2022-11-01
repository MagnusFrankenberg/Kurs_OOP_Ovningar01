package Sprint_3.Inlämn_kladd_a;

import javax.swing.*;
import java.util.*;

public class Spel {

    Spelplan sp;

    public Spel() {
        //startar upp ny spelplan (storlek=4x4 rutor)
        this.sp = new Spelplan(4);


        while(!gameCompleted(sp.positioner)){

            // Position tryMoveThis = //input from swing
            JOptionPane.showMessageDialog(null,"Nuvarande spelplan:\n"+sp.printBrickor());


            int tryMove = Integer.parseInt(JOptionPane.showInputDialog("Vilken bricka vill du flytta?\nAnge Brickans Position\n"+sp.printBrickor()));
            Position tryPos=null;
            for(Position p: sp.positioner){
                if(p.getNumber()==tryMove)
                    tryPos = p;
            }
            Position currentEmpty= sp.findEmptyPosition();
          //  JOptionPane.showMessageDialog(null,"Du vill flytta bricka "+ tryPos.getBricka().getBricknummer()+"\n från position "+tryPos.getNumber()+" till position "+currentEmpty.getNumber());

            if(moveABricka(tryPos)){
                JOptionPane.showMessageDialog(null,"Sucessfully moved, se nya positioner:\n"+sp.printBrickor());

            }else{
                JOptionPane.showMessageDialog(null, "Något gick fel");
            }


         //   if(moveABricka(tryMoveThis)){}
                //det som ska hända när man flyttar en bricka
         //
        }




    }

    public boolean moveABricka(Position currentPosition) {
        boolean movedSuccesfully = false;
        if (sp.isPossibleNewPosition(currentPosition, sp.findEmptyPosition())) {
            sp.findEmptyPosition().setBricka(currentPosition.getBricka());
            currentPosition.setBricka(null);
            movedSuccesfully = true;
        }
        return movedSuccesfully;
    }


    public boolean gameCompleted(List<Position> positionList) {
        boolean completed = true;
        for (Position p : positionList) {

            //sista rutan längst ner ska vara tom
            if (p.getNumber() == positionList.size()) {
                if (p.getBricka() != null) {
                    completed = false;
                    break;
                }
            }
            //bricknummret ska vara = positionsnumret på spelplan
            if (p.getNumber() != p.getBricka().getBricknummer()) {
                completed = false;
            }
        }
        return completed;
    }


    public static void main(String[] args) {
        Spel spel = new Spel();

    }

}
