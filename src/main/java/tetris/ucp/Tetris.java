package tetris.ucp;

public class Tetris {
     public Board board = new Board();
     public Clock clock = new Clock();
          

     public void start(){
          clock.setTimer();
          board.insertPieceInBoard();
     }

     public boolean state(){
          return board.game;
     }

     public void rotateLeft(){
          board.currentPiece.rotateLeft();
     }

     public void rotateRight(){
          board.currentPiece.rotateRight();
     }

     public void tick(){
          clock.setTimer();
          board.updateBoardOnTick();
     }
}
