package tetris.ucp;

import tetris.ucp.pieces.PieceBase;

public class Clock {
     private int timer = 0;
     public Board board;

     public Clock(Board board){
          this.board = board;
     }

     public String[] tick(PieceBase piece){
          setTimer();
          return board.updateBoardOnTick(piece);
     }

     private void setTimer(){
          timer = timer + 1;
     }
}
