package tetris.ucp;

import tetris.ucp.pieces.PieceBase;

public class Clock {
     private int timer = 0;

     public void tick(PieceBase piece){
          setTimer();
     }

     public void setTimer(){
          timer = timer + 1;
     }
}
