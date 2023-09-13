package tetris.ucp;

public class Tetris {
     //TETRIS BASADO EN EL DIAGRAMA UML
     public Board board = new Board();
     public Clock clock = new Clock();
          

     public void start(){
          clock.tick();
          board.insertPieceInBoard();
     }

     public boolean state(){
          return board.checkWinning();
     }

     public void rotateLeft(){
          board.currentPiece.rotateLeft();
     }

     public void rotateRight(){
          board.currentPiece.rotateRight();
     }

     public void tick(){
          clock.tick();
          board.updateBoardOnTick();
          if(state()){
               System.out.println("Has ganado!");
          }
     }
}
