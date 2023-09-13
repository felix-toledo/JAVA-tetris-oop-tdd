import static org.junit.Assert.*;

import org.junit.Test;

import tetris.ucp.pieces.PieceDog;
import tetris.ucp.pieces.PieceT;
import tetris.ucp.pieces.PieceL;
import tetris.ucp.pieces.PieceSquare;
import tetris.ucp.pieces.PieceStick;
import tetris.ucp.Board;


public class TestPiecePositionInBoard {
     
     @Test
     public void createBoard__createPiece_checkLeaveTheBoard_atSides(){
          Board colitionBoard = new Board();
          PieceSquare cuadrado = new PieceSquare();

          String[] expectedBoard2 =  {  "0000000011",
                                        "0000000011",
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
                                        "0000000000"};
          assertArrayEquals(expectedBoard2, colitionBoard.insertPieceInBoard(cuadrado, 8));
     }

     @Test
     public void createBoard__createPiece_checkLeaveTheBoard_atBottom(){
          Board colitionBoard = new Board();
          PieceSquare cuadrado = new PieceSquare();

          String[] expectedBoard2 =  {  "0000000000",
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
                                        "0110000000",
                                        "0110000000"};

          colitionBoard.insertPieceInBoard(cuadrado, 1);
          for(int i = 0; i<19; i++){
                         colitionBoard.updateBoardOnTick(cuadrado, true);
          }
          String[] finalBoard1 = colitionBoard.updateBoardOnTick(cuadrado, true);
          assertArrayEquals(expectedBoard2, finalBoard1);
     }


     @Test
     public void testColition(){
          Board colitionBoard = new Board();
          PieceT te = new PieceT();

          String[] boardForTesting = {  "0000000000",
                                        "0000000000",
                                        "0010100000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          colitionBoard.setBoard(boardForTesting);

          String[] boardExpected = {    "0011100000",
                                        "0001000000",
                                        "0010100000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          assertArrayEquals(boardExpected, colitionBoard.insertPieceInBoard(te, 2));

          String[] boardExpected2 = {   "0000000000",
                                        "0011100000",
                                        "0011100000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};
          
          assertArrayEquals(boardExpected2, colitionBoard.updateBoardOnTick(te, true));

          assertArrayEquals(boardExpected2, colitionBoard.updateBoardOnTick(te, true));
     }
}