import static org.junit.Assert.assertEquals;

import java.util.function.Predicate;

import org.junit.Test;

import tetris.ucp.pieces.*;

public class PiecesPositionTest {
     @Test
     public void testEle(){
          PieceL ele = new PieceL(false);
          assertEquals("0011001000100000", ele.showPieceInPosition(2));

          PieceL eleDer = new PieceL(true);
          assertEquals("0000111010000000", eleDer.showPieceInPosition(3));
     }

     @Test
     public void testDog(){
          PieceDog dog = new PieceDog(false);
          assertEquals("0100110010000000", dog.showPieceInPosition(1));

          PieceDog dogDer = new PieceDog(true);
          assertEquals("0110110000000000", dogDer.showPieceInPosition(0));
     }

}
