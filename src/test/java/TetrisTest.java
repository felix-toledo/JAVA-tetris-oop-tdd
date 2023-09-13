import static org.junit.Assert.*;

import org.junit.Test;

import tetris.ucp.*;
import tetris.ucp.pieces.*;

import tetris.ucp.Tetris;



public class TetrisTest {
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
                                   "1111111100",
                                   "1111111110", 
                                   "1111111110",
                                   "1111111110",
                                   "1111111110"};

          tablero.insertPieceInBoard(palo1, 0);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo2, 1);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo3, 2);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo4, 3);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo5, 4);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo6, 5);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo7, 6);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo8, 7);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo9, 8);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo10, 0);
          tablero.currentPiece.rotateRight();
          for (int i = 0; i < 15; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(palo11, 4);
          tablero.currentPiece.rotateRight();
          for (int i = 0; i < 15; i++){
               tablero.updateBoardOnTick();
          }

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
                                   "0000000011"};

          tablero.insertPieceInBoard(paloForWinning, 9);
          for (int i = 0; i < 16; i++){
               tablero.updateBoardOnTick();
          }
          tablero.insertPieceInBoard(CuadradoForWinning, 8);
          for (int i = 0; i < 18; i++){
               tablero.updateBoardOnTick();
          }
          tablero.checkBoard();
          
          String[] finalBoard2 = tablero.getBoard();
          assertArrayEquals(expected2, finalBoard2);
          assertTrue(tablero.checkWinning());

     }

     @Test
     public void tetrisTest(){
          Tetris juego = new Tetris();
          juego.start();

          String [] boardGame = juego.board.getBoard();     

          assertNotNull(boardGame);

          juego.tick();

          assertEquals(true, juego.board.getBoard()[1].contains("1"));

          juego.rotateRight();
          assertNotNull(juego.board.currentPiece.getPiece());
     
          juego.rotateLeft();
          assertNotNull(juego.board.currentPiece.getPiece());
     }

     @Test
     public void clockTest(){
          Clock reloj = new Clock();
          assertEquals(0, reloj.getTimer());
          reloj.tick();
          assertEquals(1, reloj.getTimer());
     }
}
