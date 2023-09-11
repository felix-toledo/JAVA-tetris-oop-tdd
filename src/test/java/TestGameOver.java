import static org.junit.Assert.*;
import org.junit.Test;

public class TestGameOver {

    @Test
    public void testGameOverCantPlacePiece() {
        String tablero = "1111111111" +
                         "0000000000" +
                         "0000000000" +
                         "0000000000" +
                         "0000000000" +
                         "0000000000" +
                         "0000000000" +
                         "0000000000" +
                         "0000000000" +
                         "0000000000";

        boolean gameOver = tablero.substring(0, 10).chars().filter(c -> c == '1').count() >= 8;

        assertTrue(gameOver);
    }