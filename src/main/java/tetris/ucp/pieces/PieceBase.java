package tetris.ucp.pieces;

import Interfaces.IRotator;

public class PieceBase implements IRotator{

     //Cumplimiento nombrando variables y metodos en el diagrama UML.
     private String name;

     public String rotateRight(){
          actualPos++;
               if (actualPos == 4){
                    actualPos = 0;
               }
          return getPiece();
     }

     public String rotateLeft(){
          actualPos--;
               if (actualPos == -1){
                    actualPos = 3;
               }
          return getPiece();
     }

     
     //Variables varias que voy a usar para hacer diferentes cosas.
     private int actualPos;
     protected String [] figure;
     private int [] posInBoard = {0, 0, actualPos};


     //Métodos por fuera del diagrama UML, si bien no estan, usamos para setear algunas cosas con respecto a la pieza.
     public String showPieceInPosition(int position){
          return (figure[position]);
     }
     
     //ENCAPSULAMIENTO
     public void setPosInBoard(int x, int y){
          posInBoard[0] = x;
          posInBoard[1] = y;
          posInBoard[2] = actualPos;
     }

     public int [] getPosInBoard(){
          return posInBoard;
     }

     public void setPosition(int position){
          actualPos = position;
     }

     public int getActualPos(){
          return actualPos;
     }

     public String getPiece(){
        return (figure[actualPos]);    
     }

     public String getName(){
          return name;
     }

}