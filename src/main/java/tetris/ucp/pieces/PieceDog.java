package tetris.ucp.pieces;

public class PieceDog extends PieceBase{
     boolean isRight;

     String [] right = {"0110110000000000", "1000110001000000", "0110110000000000", "1000110001000000"};
     String [] left = {"1100011000000000", "0100110010000000", "1100011000000000", "0100110010000000"};

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

     @Override
     public String showPieceInPosition(int position){
          if (isRight){
               return(right[position]);
          } else {
               return(left[position]);
          }
     }
}