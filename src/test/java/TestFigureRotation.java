import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tetris.ucp.pieces.TheDog;
import tetris.ucp.pieces.TheT;
import tetris.ucp.pieces.TheL;
import tetris.ucp.pieces.TheSquare;


public class TestFigureRotation {
     @Test
     public void checkRightDogRot_toRight(){
          TheDog perro = new TheDog(true);
          assertEquals("0110110000000000", perro.showPiece());
          assertEquals("right2", perro.rotatePiece(true));
          assertEquals("right3", perro.rotatePiece(true));
          assertEquals("right4", perro.rotatePiece(true));
          assertEquals("0110110000000000", perro.rotatePiece(true));
     }

     @Test
     public void checkLeftDogRot_toRight(){
          TheDog perro = new TheDog(false);
          assertEquals("1100011000000000", perro.showPiece());
          assertEquals("left2", perro.rotatePiece(true));
          assertEquals("left3", perro.rotatePiece(true));
          assertEquals("left4", perro.rotatePiece(true));
          assertEquals("1100011000000000", perro.rotatePiece(true));
     }

     @Test
     public void checkRightDogRot_toLeft(){
          TheDog perro = new TheDog(true);
          assertEquals("0110110000000000", perro.showPiece());
          assertEquals("right4", perro.rotatePiece(false));
          assertEquals("right3", perro.rotatePiece(false));
          assertEquals("right2", perro.rotatePiece(false));
          assertEquals("0110110000000000", perro.rotatePiece(false));
     }

     @Test
     public void checkLeftDogRot_toLeft(){
          TheDog perro = new TheDog(false);
          assertEquals("1100011000000000", perro.showPiece());
          assertEquals("left4", perro.rotatePiece(false));
          assertEquals("left3", perro.rotatePiece(false));
          assertEquals("left2", perro.rotatePiece(false));
          assertEquals("1100011000000000", perro.rotatePiece(false));
     }

     @Test
     public void TRotation_toRight(){
          TheT talleres = new TheT();
          assertEquals("0100111000000000", talleres.showPiece());
          assertEquals("t2", talleres.rotatePiece(true));
          assertEquals("t3", talleres.rotatePiece(true));
          assertEquals("t4", talleres.rotatePiece(true));
          assertEquals("0100111000000000", talleres.rotatePiece(true));
     }

     @Test
     public void TRotation_toLeft(){
          TheT talleres = new TheT();
          assertEquals("0100111000000000", talleres.showPiece());
          assertEquals("t4", talleres.rotatePiece(false));
          assertEquals("t3", talleres.rotatePiece(false));
          assertEquals("t2", talleres.rotatePiece(false));
          assertEquals("0100111000000000", talleres.rotatePiece(false));
     }
     
     @Test
     public void LRotationRight_toright(){
          TheL L = new TheL(true);
          assertEquals("1000100011000000", L.showPiece());
          assertEquals("right2", L.rotatePiece(true));
          assertEquals("right3", L.rotatePiece(true));
          assertEquals("right4", L.rotatePiece(true));
          assertEquals("1000100011000000", L.rotatePiece(true));
     }

     @Test
     public void LRotationRight_toleft(){
          TheL L = new TheL(true);
          assertEquals("1000100011000000", L.showPiece());
          assertEquals("right4", L.rotatePiece(false));
          assertEquals("right3", L.rotatePiece(false));
          assertEquals("right2", L.rotatePiece(false));
          assertEquals("1000100011000000", L.rotatePiece(false));
     }

     @Test
     public void LRotationLeft_toright(){
          TheL L = new TheL(false);
          assertEquals("0100010011000000", L.showPiece());
          assertEquals("left2", L.rotatePiece(true));
          assertEquals("left3", L.rotatePiece(true));
          assertEquals("left4", L.rotatePiece(true));
          assertEquals("0100010011000000", L.rotatePiece(true));
     }

     @Test
      public void LRotationLeft_toleft(){
          TheL L = new TheL(false);
          assertEquals("0100010011000000", L.showPiece());
          assertEquals("left4", L.rotatePiece(false));
          assertEquals("left3", L.rotatePiece(false));
          assertEquals("left2", L.rotatePiece(false));
          assertEquals("0100010011000000", L.rotatePiece(false));
     }

     @Test
      public void checkTheSquareLeft_toright(){
          TheSquare cuadrado = new TheSquare();
          assertEquals("1100110000000000", cuadrado.showPiece());
          assertEquals("1100110000000000", cuadrado.rotatePiece(false));
          assertEquals("1100110000000000", cuadrado.rotatePiece(false));
          assertEquals("1100110000000000", cuadrado.rotatePiece(false));
          assertEquals("1100110000000000", cuadrado.rotatePiece(false));
     }
}
