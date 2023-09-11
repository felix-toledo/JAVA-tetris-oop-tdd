import static org.junit.Assert.*;

import org.junit.Test;

import tetris.ucp.pieces.PieceDog;
import tetris.ucp.pieces.PieceT;
import tetris.ucp.pieces.PieceL;
import tetris.ucp.pieces.PieceSquare;
import tetris.ucp.pieces.PieceStick;
import tetris.ucp.Board;


public class TestColition {
     
     @Test
     public void createBoard_setItForColition_createPiece_checkColitions(){
          Board colitionBoard = new Board();
          PieceSquare cuadrado = new PieceSquare();

          String[] excpectedBoard = {   "0011000000",
                                        "0011000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          assertArrayEquals(excpectedBoard, colitionBoard.insertPieceInBoard(cuadrado, 2));


          String[] expectedBoard2 =  {  "0000000000",
                                        "0011000000",
                                        "0011000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          String[] finalBoard1 = colitionBoard.updateBoardOnTick(cuadrado);

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
          
          assertArrayEquals(boardExpected2, colitionBoard.updateBoardOnTick(te));
          //assertArrayEquals(boardExpected2, colitionBoard.updateBoardOnTick(te));

     }
}
