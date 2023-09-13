import static org.junit.Assert.*;

import org.junit.Test;

import tetris.ucp.Board;
import tetris.ucp.pieces.*;


public class TetrisTest {
     @Test
     public void check_if_loose(){
          Board tablero = new Board();
          PieceStick palo1 = new PieceStick();
          PieceStick palo2 = new PieceStick();
          PieceSquare Cuadrado = new PieceSquare();

          String [] expected = {   "1100000000",
                                   "1100000000",
                                   "1000000000", 
                                   "1000000000",
                                   "1000000000",
                                   "1000000000",
                                   "1000000000", 
                                   "1000000000",
                                   "1000000000",
                                   "1000000000"};

          tablero.insertPieceInBoard(palo1, 0);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo2, 0);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(Cuadrado, 0);

          String[] finalBoard = tablero.getBoard();
          assertArrayEquals(expected, finalBoard);
          assertEquals(false, tablero.checkBoard());
     }
     @Test
     public void check_if_win(){
          Board tablero = new Board();
          PieceStick palo1 = new PieceStick();
          PieceStick palo2 = new PieceStick();
          PieceStick palo3 = new PieceStick();
          PieceStick palo4 = new PieceStick();
          PieceStick palo5 = new PieceStick();
          PieceStick palo6 = new PieceStick();
          PieceStick palo7 = new PieceStick();
          PieceStick palo8 = new PieceStick();
          PieceStick palo9 = new PieceStick();
          PieceStick palo10 = new PieceStick();
          PieceStick palo11 = new PieceStick();
          PieceStick paloForWinning = new PieceStick();

          PieceSquare CuadradoForWinning = new PieceSquare();

          String [] expected = {   "0000000000",
                                   "0000000000",
                                   "0000000000", 
                                   "0000000000",
                                   "0000000000",
                                   "1111111100",
                                   "1111111110", 
                                   "1111111110",
                                   "1111111110",
                                   "1111111110"};

          tablero.insertPieceInBoard(palo1, 0);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo2, 1);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo3, 2);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo4, 3);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo5, 4);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo6, 5);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo7, 6);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo8, 7);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo9, 8);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo10, 0);
          tablero.currentPiece.rotateRight();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(palo11, 4);
          tablero.currentPiece.rotateRight();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();

          String[] finalBoard = tablero.getBoard();
          assertArrayEquals(expected, finalBoard);

          String [] expected2= {   "0000000000",
                                   "0000000000",
                                   "0000000000", 
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000", 
                                   "0000000000",
                                   "0000000000",
                                   "0000000011"};

          tablero.insertPieceInBoard(paloForWinning, 9);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.insertPieceInBoard(CuadradoForWinning, 8);
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.updateBoardOnTick();
          tablero.checkBoard();
          
          String[] finalBoard2 = tablero.getBoard();
          assertArrayEquals(expected2, finalBoard2);
          assertTrue(tablero.checkWinning());

          

     }
}
