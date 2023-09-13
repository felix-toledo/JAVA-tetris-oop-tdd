package tetris.ucp;

import tetris.ucp.pieces.PieceBase;

public class Clock {
     //DIAGRAMA UML
     public void tick(){
          setTimer();
     }


     //Funciones que uso para hacer andar el clock.
     private int timer = 0;     

     public int getTimer(){
          return timer;
     }

     private void setTimer(){
          timer = timer + 1;
     }
}
