import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tetris.ucp.pieces.PieceDog;
import tetris.ucp.pieces.PieceT;
import tetris.ucp.pieces.PieceL;
import tetris.ucp.pieces.PieceSquare;
import tetris.ucp.pieces.PieceStick;

public class RequirementTest_Second {
     @Test
     public void checkRightDogRot_toRight(){
          PieceDog perro = new PieceDog(true);
          assertEquals("0110110000000000", perro.getPiece());
          assertEquals("1000110001000000", perro.rotateRight());
          assertEquals("0110110000000000", perro.rotateRight());
          assertEquals("1000110001000000", perro.rotateRight());
          assertEquals("0110110000000000", perro.rotateRight());
     }

     @Test
     public void checkLeftDogRot_toRight(){
          PieceDog perro = new PieceDog(false);
          assertEquals("1100011000000000", perro.getPiece());
          assertEquals("0100110010000000", perro.rotateRight());
          assertEquals("1100011000000000", perro.rotateRight());
          assertEquals("0100110010000000", perro.rotateRight());
          assertEquals("1100011000000000", perro.rotateRight());
     }

     @Test
     public void checkRightDogRot_toLeft(){
          PieceDog perro = new PieceDog(true);
          assertEquals("0110110000000000", perro.getPiece());
          assertEquals("1000110001000000", perro.rotateLeft());
          assertEquals("0110110000000000", perro.rotateLeft());
          assertEquals("1000110001000000", perro.rotateLeft());
          assertEquals("0110110000000000", perro.rotateLeft());
     }

     @Test
     public void checkLeftDogRot_toLeft(){
          PieceDog perro = new PieceDog(false);
          assertEquals("1100011000000000", perro.getPiece());
          assertEquals("0100110010000000", perro.rotateLeft());
          assertEquals("1100011000000000", perro.rotateLeft());
          assertEquals("0100110010000000", perro.rotateLeft());
          assertEquals("1100011000000000", perro.rotateLeft());
     }

     @Test
     public void TRotation_toRight(){
          PieceT talleres = new PieceT();
          assertEquals("1110010000000000", talleres.getPiece());
          assertEquals("0100011001000000", talleres.rotateRight());
          assertEquals("0100111000000000", talleres.rotateRight());
          assertEquals("0100110001000000", talleres.rotateRight());
          assertEquals("1110010000000000", talleres.rotateRight());
     }

     @Test
     public void TRotation_toLeft(){
          PieceT talleres = new PieceT();
          assertEquals("1110010000000000", talleres.getPiece());
          assertEquals("0100110001000000", talleres.rotateLeft());
          assertEquals("0100111000000000", talleres.rotateLeft());
          assertEquals("0100011001000000", talleres.rotateLeft());
          assertEquals("1110010000000000", talleres.rotateLeft());
     }
     
     @Test
     public void LRotationRight_toright(){
          PieceL L = new PieceL(true);
          assertEquals("1000100011000000", L.getPiece());
          assertEquals("0010111000000000", L.rotateRight());
          assertEquals("1100010001000000", L.rotateRight());
          assertEquals("0000111010000000", L.rotateRight());
          assertEquals("1000100011000000", L.rotateRight());
     }

     @Test
     public void LRotationRight_toleft(){
          PieceL L = new PieceL(true);
          assertEquals("1000100011000000", L.getPiece());
          assertEquals("0000111010000000", L.rotateLeft());
          assertEquals("1100010001000000", L.rotateLeft());
          assertEquals("0010111000000000", L.rotateLeft());
          assertEquals("1000100011000000", L.rotateLeft());
     }

     @Test
     public void LRotationLeft_toright(){
          PieceL L = new PieceL(false);
          assertEquals("0100010011000000", L.getPiece());
          assertEquals("0100011100000000", L.rotateRight());
          assertEquals("0011001000100000", L.rotateRight());
          assertEquals("0000011100010000", L.rotateRight());
          assertEquals("0100010011000000", L.rotateRight());
     }

     @Test
      public void LRotationLeft_toleft(){
          PieceL L = new PieceL(false);
          assertEquals("0100010011000000", L.getPiece());
          assertEquals("0000011100010000", L.rotateLeft());
          assertEquals("0011001000100000", L.rotateLeft());
          assertEquals("0100011100000000", L.rotateLeft());
          assertEquals("0100010011000000", L.rotateLeft());
     }

     @Test
      public void checkTheSquare_toLeft(){
          PieceSquare cuadrado = new PieceSquare();
          assertEquals("1100110000000000", cuadrado.getPiece());
          assertEquals("1100110000000000", cuadrado.rotateLeft());
          assertEquals("1100110000000000", cuadrado.rotateLeft());
          assertEquals("1100110000000000", cuadrado.rotateLeft());
          assertEquals("1100110000000000", cuadrado.rotateLeft());
     }
      @Test
      public void checkTheSquare_toRight(){
          PieceSquare cuadrado = new PieceSquare();
          assertEquals("1100110000000000", cuadrado.getPiece());
          assertEquals("1100110000000000", cuadrado.rotateRight());
          assertEquals("1100110000000000", cuadrado.rotateRight());
          assertEquals("1100110000000000", cuadrado.rotateRight());
          assertEquals("1100110000000000", cuadrado.rotateRight());
     }

     @Test
     public void StickRotation_toRight(){
          PieceStick talleres = new PieceStick();
          assertEquals("1000100010001000", talleres.getPiece());
          assertEquals("1111000000000000", talleres.rotateRight());
          assertEquals("1000100010001000", talleres.rotateRight());
          assertEquals("1111000000000000", talleres.rotateRight());
          assertEquals("1000100010001000", talleres.rotateRight());
     }

     @Test
     public void StickRotation_toLeft(){
          PieceStick talleres = new PieceStick();
          assertEquals("1000100010001000", talleres.getPiece());
          assertEquals("1111000000000000", talleres.rotateLeft());
          assertEquals("1000100010001000", talleres.rotateLeft());
          assertEquals("1111000000000000", talleres.rotateLeft());
          assertEquals("1000100010001000", talleres.rotateLeft());
     }

}