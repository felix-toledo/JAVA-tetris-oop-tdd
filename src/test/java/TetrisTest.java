import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tetris.ucp.pieces.TheDog;
import tetris.ucp.pieces.TheL;
import tetris.ucp.pieces.TheStick;
import tetris.ucp.pieces.TheSquare;
import tetris.ucp.pieces.TheT;

public class TetrisTest 
{
    @Test
    
    public void checkStick()
    {
        TheStick palo = new TheStick();
        String figura = palo.showPiece();
        assertEquals("1000100010001000", figura);
    }

    @Test
    public void checkRightL(){
     TheL eleDerecha = new TheL(true);
     String figura = eleDerecha.showPiece();
     assertEquals("1000100011000000", figura);
    }

    @Test
    public void checkLeftL(){
     TheL eleIzquierda = new TheL(false);
     String figura = eleIzquierda.showPiece();
     assertEquals("0100010011000000", figura);
    }

    @Test
    public void checkLeftDog(){
     TheDog perroIzquierdo = new TheDog(false);
     String figura = perroIzquierdo.showPiece();
     assertEquals("1100011000000000", figura);
    }

    @Test
    public void checkRightDog(){
     TheDog perroDerecho = new TheDog(true);
     String figura = perroDerecho.showPiece();
     assertEquals("0110110000000000", figura);
    }

    @Test
    public void checkSquare(){
     TheSquare cuadrado = new TheSquare();
     String figura = cuadrado.showPiece();
     assertEquals("1100110000000000", figura);
    }

   @Test
    public void checkT()
    {
        TheT talleres = new TheT();
        String figura = talleres.showPiece();
        assertEquals("0100111000000000", figura);
    }

}