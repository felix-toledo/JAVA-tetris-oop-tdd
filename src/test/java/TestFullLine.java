import static org.junit.Assert.*;
import org.junit.Test;
import tetris.ucp.Board;
import tetris.ucp.pieces.PieceDog;
import tetris.ucp.pieces.PieceSquare;
import tetris.ucp.pieces.PieceStick;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestFullLine {

    @Test
    public void testFullLine() {
        //tenes q hacer un new board
        Board tablero = new Board();
        //tenes q hacer un setBoard(tablero)
        //y ahi recien el tablero se pone en 111111 al final
        String[] tableroNuevo = {   "0000000000",
                                    "0000000000",
                                    "0000000000", 
                                    "0000000000",
                                    "0000000000",
                                    "0000000000",
                                    "0000000000", 
                                    "0000000000",
                                    "0011000000",
                                    "1111111111"};

        tablero.setBoard(tableroNuevo);

        tablero.checkLineByLineComplete();
        
        String[] expectedTablero = {    "0000000000",
                                        "0000000000",
                                        "0000000000", 
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000", 
                                        "0000000000",
                                        "0000000000",
                                        "0011000000"};

        assertArrayEquals(expectedTablero, tablero.getBoard());
    }
}
