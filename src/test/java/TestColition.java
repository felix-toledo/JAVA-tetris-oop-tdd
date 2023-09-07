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

          String[] boardForTesting = {  "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0001000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          colitionBoard.setboard(boardForTesting);

          
          String[] excpectedBoard = {   "0011000000",
                                        "0011000000",
                                        "0000000000",
                                        "0000000000",
                                        "0001000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          assertArrayEquals(excpectedBoard, colitionBoard.insertPieceInBoard(cuadrado, 2));




          colitionBoard.updateBoardOnTick(cuadrado);

          String[] expectedBoard2 =  {  "0000000000",
                                        "0000000000",
                                        "0011000000",
                                        "0011000000",
                                        "0001000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};
          assertArrayEquals(expectedBoard2, colitionBoard.updateBoardOnTick(cuadrado));

          String[] finalBoard1 = colitionBoard.updateBoardOnTick(cuadrado);


/* 
          String[] boardForTesting2 = {  "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000010000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};*/
     }
}
