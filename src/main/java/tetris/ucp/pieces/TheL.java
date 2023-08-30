package tetris.ucp.pieces;


public class TheL extends Pieces{
     boolean isRight;

     String [] right = {"1000100011000000", "right2", "right3", "right4"};
     String [] left = {"0100010011000000", "left2", "left3", "left4"};

     public TheL(boolean isRightAnswer){
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