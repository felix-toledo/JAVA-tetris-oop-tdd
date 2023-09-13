import static org.junit.Assert.*;

import org.junit.Test;

import tetris.ucp.pieces.PieceDog;
import tetris.ucp.pieces.PieceL;
import tetris.ucp.pieces.PieceStick;
import tetris.ucp.pieces.PieceSquare;
import tetris.ucp.pieces.PieceT;

public class RequirementTest_First 
{
    @Test
    public void checkStick()
    {
        PieceStick palo = new PieceStick();
        String figura = palo.getPiece();
        assertEquals("1000100010001000", figura);
    }

    @Test
    public void checkRightL(){
     PieceL eleDerecha = new PieceL(true);
     String figura = eleDerecha.getPiece();
     assertEquals("1000100011000000", figura);
    }

    @Test
    public void checkLeftL(){
     PieceL eleIzquierda = new PieceL(false);
     String figura = eleIzquierda.getPiece();
     assertEquals("0100010011000000", figura);
    }

    @Test
    public void checkLeftDog(){
     PieceDog perroIzquierdo = new PieceDog(false);
     String figura = perroIzquierdo.getPiece();
     assertEquals("1100011000000000", figura);
    }

    @Test
    public void checkRightDog(){
     PieceDog perroDerecho = new PieceDog(true);
     String figura = perroDerecho.getPiece();
     assertEquals("0110110000000000", figura);
    }

    @Test
    public void checkSquare(){
     PieceSquare cuadrado = new PieceSquare();
     String figura = cuadrado.getPiece();
     assertEquals("1100110000000000", figura);
    }

   @Test
    public void checkT()
    {
        PieceT talleres = new PieceT();
        String figura = talleres.getPiece();
        assertEquals("1110010000000000", figura);
    }

}