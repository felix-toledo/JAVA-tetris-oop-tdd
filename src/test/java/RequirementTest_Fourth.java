import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tetris.ucp.Board;
import tetris.ucp.pieces.PieceSquare;
import tetris.ucp.pieces.PieceStick;

public class RequirementTest_Fourth {
     @Test
    public void insert_stick_in_board_rotate_and_cant_go_down_anymore(){
      Board b2 = new Board();
      PieceStick palito = new PieceStick();

      String[] expectedBoard = {    "0000010000",
                                    "0000010000",
                                    "0000010000", 
                                    "0000010000",
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
                                    "0000000000"};

      assertArrayEquals(expectedBoard, b2.insertPieceInBoard(palito, 5));
 
      b2.updateBoardOnTick(palito, true);
      b2.updateBoardOnTick(palito, true);
      palito.rotateRight();
      
      String[] expectedBoard4 = {   "0000000000",
                                    "0000000000",
                                    "0000000000", 
                                    "0000011110",
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
                                    "0000000000"};
     
     assertArrayEquals(expectedBoard4, b2.updateBoardOnTick(palito, true));

     palito.rotateRight();
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);
     b2.updateBoardOnTick(palito, true);

      String[] expectedBoard7 = {  "0000000000",
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
                                   "0000010000", 
                                   "0000010000",
                                   "0000010000",
                                   "0000010000"};
                                    
      assertArrayEquals(expectedBoard7, b2.updateBoardOnTick(palito, true));
      assertArrayEquals(expectedBoard7, b2.updateBoardOnTick(palito, true)); // Aca veo que no me devuelva error, ya que no puede bajar más
      }

      @Test
     public void check_if_loose(){
          Board tablero = new Board();
          PieceStick palo1 = new PieceStick();
          PieceStick palo2 = new PieceStick();
          PieceStick palo3 = new PieceStick();
          PieceStick palo4 = new PieceStick();
          PieceStick palo5 = new PieceStick();

          String [] expected = {   "1000000000",
                                   "1000000000",
                                   "1000000000", 
                                   "1000000000",
                                   "1000000000",
                                   "1000000000",
                                   "1000000000", 
                                   "1000000000",
                                   "1000000000",
                                   "1000000000",
                                   "1000000000",
                                   "1000000000", 
                                   "1000000000",
                                   "1000000000",
                                   "1000000000",
                                   "1000000000", 
                                   "1000000000",
                                   "1000000000",
                                   "1000000000",
                                   "1000000000"};

          tablero.insertPieceInBoard(palo1, 0);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo2, 0);
          for (int i = 0; i < 12; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo3, 0);
          for (int i = 0; i < 8; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo4, 0);
          for (int i = 0; i < 4; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo5, 0);
          

          String[] finalBoard = tablero.getBoard();
          assertArrayEquals(expected, finalBoard);
          assertEquals(false, tablero.checkBoard());
     }
}
