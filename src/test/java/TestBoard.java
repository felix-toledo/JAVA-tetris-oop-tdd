import static org.junit.Assert.*;

import org.junit.Test;

import tetris.ucp.*;
import tetris.ucp.pieces.*;


public class TestBoard 
{
    @Test
    public void testBoard(){
     Board tablerito = new Board();
     for(int i = 0; i < 100; i++){
          PieceBase piece = tablerito.giveRandomPiece();
          assertNotNull(piece);
     }
    }
}