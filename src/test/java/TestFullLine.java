import static org.junit.Assert.*;
import org.junit.Test;
import tetris.ucp.Board;

public class TestFullLine {

    @Test
    public void testFullLine() {
        Board tablero = new Board();
        String[] tableroNuevo = {   "0000000000",
                                    "0000000000",
                                    "0000000000",
                                    "0000000000",
                                    "0000000000",
                                    "0000000000",
                                    "0000000000",
                                    "0000000000",
                                    "0000000000",
                                    "0000000000",
                                    "0000000000",
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

        tablero.checkBoard();
        
        String[] expectedTablero = {    "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
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