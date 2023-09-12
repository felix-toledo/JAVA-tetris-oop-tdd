package tetris.ucp.pieces;


public class PieceL extends PieceBase{
     boolean isRight;

     String [] right = {"1000100011000000", "0010111000000000", "1100010001000000", "0000111010000000"};
     String [] left = {"0100010011000000", "0100011100000000", "0011001000100000", "0000011100010000"};

     public PieceL(boolean isRightAnswer){
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