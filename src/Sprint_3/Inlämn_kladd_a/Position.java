package Sprint_3.Inlämn_kladd_a;


public class Position{


   private int number;
   private  int row;
   private  int col;

   private Bricka bricka;


    public Position(int row, int col, int number) {
        this.row = row;
        this.col = col;
        this.number = number;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getNumber() {
        return number;
    }

    public Bricka getBricka() {
        return bricka;
    }

    public void setBricka(Bricka bricka) {
        this.bricka = bricka;
    }
/*
    //används endast i testfasen för att enklare se positioner
    @Override
    public int compare(Object o1, Object o2) {
        if(((Position)o1).number<((Position)o2).number) return-1;
        if(((Position)o1).number>((Position)o2).number) return 1;
        return 0;
    }
*/
}
