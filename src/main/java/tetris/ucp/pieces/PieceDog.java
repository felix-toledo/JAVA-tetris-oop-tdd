package tetris.ucp.pieces;

public class PieceDog extends PieceBase{
     boolean isRight;

     String [] right = {"0110110000000000", "right2", "right3", "right4"};
     String [] left = {"1100011000000000", "left2", "left3", "left4"};

     public PieceDog(boolean isRightAnswer){
          this.isRight = isRightAnswer;
     }
     
     @Override
     public String showPiece(){
          if (isRight){
               return(right[actualPos]);
          } else {
               return(left[actualPos]);
          }
     }
}