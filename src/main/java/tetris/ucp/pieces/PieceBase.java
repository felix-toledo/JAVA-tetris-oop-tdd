package tetris.ucp.pieces;

import Interfaces.IRotator;

public class PieceBase implements IRotator{
     protected int actualPos;
     protected String [] figure;
     protected int [] posInBoard = {0, 0, actualPos};

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

     public void setActualPos(int x, int y){
          posInBoard[0] = x;
          posInBoard[1] = y;
          posInBoard[2] = actualPos;
     }

     public int [] getPosInBoard(){
          return posInBoard;
     }

     public String showPieceInPosition(int position){
          return (figure[position]);
     }

     public void setPosition(int position){
          actualPos = position;
     }

     public String showPiece(){
        return (figure[actualPos]);    
     }
}