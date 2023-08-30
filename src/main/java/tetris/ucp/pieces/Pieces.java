package tetris.ucp.pieces;

import Interfaces.IPiece;

public class Pieces implements IPiece{
     protected int actualPos;
     protected String [] figure;
     public String rotatePiece(boolean toRight){
          if (toRight){
               actualPos++;
               if (actualPos == 4){
                    actualPos = 0;
               }
          } else {
               actualPos--;
               if (actualPos == -1){
                    actualPos = 3;
               }
          }
          return showPiece();
     }

     public String showPiece(){
        return (figure[actualPos]);
         
     }
}