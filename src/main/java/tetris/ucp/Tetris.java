package tetris.ucp;
import tetris.ucp.pieces.*;
import java.util.Random;

public class Tetris {
     public Board board = new Board();
     public Clock clock = new Clock(board);

     private PieceBase giveRandomPiece(){
          Random rand = new Random();
          int randomNumber = rand.nextInt(7) + 1;
          
          switch(randomNumber) {
               case 1:
                    PieceDog dogRight = new PieceDog(true);
                    return dogRight;
               case 2:
                    PieceDog dogLeft = new PieceDog(false);
                    return dogLeft;
               case 3:
                    PieceSquare square = new PieceSquare();
                    return square;
               case 4:
                    PieceStick stick = new PieceStick();
                    return stick;
               case 5:
                    PieceT t = new PieceT();
                    return t;
               case 6:
                    PieceL lRight = new PieceL(true);
                    return lRight;
               case 7:
                    PieceL lLeft = new PieceL(false);
                    return lLeft;
          }
          
     }

     public void start(){
          PieceBase pieza = giveRandomPiece();
     }

     public void state(){

     }

     public void rotateLeft(){

     }

     public void rotateRight(){

     }

     public void tick(){

     }
}
