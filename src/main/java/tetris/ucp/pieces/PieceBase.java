package tetris.ucp.pieces;

import Interfaces.IRotator;

public class PieceBase implements IRotator{
     protected int actualPos;
     protected String [] figure;
     
     public String rotateRight(){
          actualPos++;
               if (actualPos == 4){
                    actualPos = 0;
               }
          return showPiece();
     }

     public String rotateLeft(){
          actualPos--;
               if (actualPos == -1){
                    actualPos = 3;
               }
          return showPiece();
     }

     public String showPiece(){
        return (figure[actualPos]);
         
     }
}