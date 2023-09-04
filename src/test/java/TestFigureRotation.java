import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tetris.ucp.pieces.PieceDog;
import tetris.ucp.pieces.PieceT;
import tetris.ucp.pieces.PieceL;
import tetris.ucp.pieces.PieceSquare;


public class TestFigureRotation {
     @Test
     public void checkRightDogRot_toRight(){
          PieceDog perro = new PieceDog(true);
          assertEquals("0110110000000000", perro.showPiece());
          assertEquals("right2", perro.rotateRight());
          assertEquals("right3", perro.rotateRight());
          assertEquals("right4", perro.rotateRight());
          assertEquals("0110110000000000", perro.rotateRight());
     }

     @Test
     public void checkLeftDogRot_toRight(){
          PieceDog perro = new PieceDog(false);
          assertEquals("1100011000000000", perro.showPiece());
          assertEquals("left2", perro.rotateRight());
          assertEquals("left3", perro.rotateRight());
          assertEquals("left4", perro.rotateRight());
          assertEquals("1100011000000000", perro.rotateRight());
     }

     @Test
     public void checkRightDogRot_toLeft(){
          PieceDog perro = new PieceDog(true);
          assertEquals("0110110000000000", perro.showPiece());
          assertEquals("right4", perro.rotateLeft());
          assertEquals("right3", perro.rotateLeft());
          assertEquals("right2", perro.rotateLeft());
          assertEquals("0110110000000000", perro.rotateLeft());
     }

     @Test
     public void checkLeftDogRot_toLeft(){
          PieceDog perro = new PieceDog(false);
          assertEquals("1100011000000000", perro.showPiece());
          assertEquals("left4", perro.rotateLeft());
          assertEquals("left3", perro.rotateLeft());
          assertEquals("left2", perro.rotateLeft());
          assertEquals("1100011000000000", perro.rotateLeft());
     }

     @Test
     public void TRotation_toRight(){
          PieceT talleres = new PieceT();
          assertEquals("0100111000000000", talleres.showPiece());
          assertEquals("t2", talleres.rotateRight());
          assertEquals("t3", talleres.rotateRight());
          assertEquals("t4", talleres.rotateRight());
          assertEquals("0100111000000000", talleres.rotateRight());
     }

     @Test
     public void TRotation_toLeft(){
          PieceT talleres = new PieceT();
          assertEquals("0100111000000000", talleres.showPiece());
          assertEquals("t4", talleres.rotateLeft());
          assertEquals("t3", talleres.rotateLeft());
          assertEquals("t2", talleres.rotateLeft());
          assertEquals("0100111000000000", talleres.rotateLeft());
     }
     
     @Test
     public void LRotationRight_toright(){
          PieceL L = new PieceL(true);
          assertEquals("1000100011000000", L.showPiece());
          assertEquals("right2", L.rotateRight());
          assertEquals("right3", L.rotateRight());
          assertEquals("right4", L.rotateRight());
          assertEquals("1000100011000000", L.rotateRight());
     }

     @Test
     public void LRotationRight_toleft(){
          PieceL L = new PieceL(true);
          assertEquals("1000100011000000", L.showPiece());
          assertEquals("right4", L.rotateLeft());
          assertEquals("right3", L.rotateLeft());
          assertEquals("right2", L.rotateLeft());
          assertEquals("1000100011000000", L.rotateLeft());
     }

     @Test
     public void LRotationLeft_toright(){
          PieceL L = new PieceL(false);
          assertEquals("0100010011000000", L.showPiece());
          assertEquals("left2", L.rotateRight());
          assertEquals("left3", L.rotateRight());
          assertEquals("left4", L.rotateRight());
          assertEquals("0100010011000000", L.rotateRight());
     }

     @Test
      public void LRotationLeft_toleft(){
          PieceL L = new PieceL(false);
          assertEquals("0100010011000000", L.showPiece());
          assertEquals("left4", L.rotateLeft());
          assertEquals("left3", L.rotateLeft());
          assertEquals("left2", L.rotateLeft());
          assertEquals("0100010011000000", L.rotateLeft());
     }

     @Test
      public void checkTheSquareLeft_toright(){
          PieceSquare cuadrado = new PieceSquare();
          assertEquals("1100110000000000", cuadrado.showPiece());
          assertEquals("1100110000000000", cuadrado.rotateLeft());
          assertEquals("1100110000000000", cuadrado.rotateLeft());
          assertEquals("1100110000000000", cuadrado.rotateLeft());
          assertEquals("1100110000000000", cuadrado.rotateLeft());
     }

     //Stick left and right
     //cuadrado a left

}
