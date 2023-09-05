import static org.junit.Assert.*;

import org.junit.Test;

import tetris.ucp.Board;
import tetris.ucp.pieces.PieceDog;
import tetris.ucp.pieces.PieceSquare;
import tetris.ucp.pieces.PieceStick;

public class TestInsertPiece 
{
    @Test
    public void insert_square_in_board_check_if_update(){
     Board b1 = new Board();
     PieceSquare cuadrado = new PieceSquare();
     String [] expected = { "0011000000",
                            "0011000000",
                            "0000000000", 
                            "0000000000",
                            "0000000000",
                            "0000000000",
                            "0000000000", 
                            "0000000000",
                            "0000000000",
                            "0000000000"};

     String [] tableroConInsertado = b1.insertPieceInBoard(cuadrado, 2);

     assertArrayEquals(expected, tableroConInsertado); 
    }

    @Test
    public void insert_rightDog_in_board(){
          Board b1 = new Board();
          PieceDog perritoDerecho = new PieceDog(true);
          String [] expected = {   "0001100000",
                                   "0011000000",
                                   "0000000000", 
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000", 
                                   "0000000000",
                                   "0000000000",
                                   "0000000000"};

          String [] tableroConInsertado = b1.insertPieceInBoard(perritoDerecho, 2);

          assertArrayEquals(expected, tableroConInsertado); 
    }

    @Test
    public void insert_leftDog_in_board(){
          Board b1 = new Board();
          PieceDog perritoDerecho = new PieceDog(false);
          String [] expected = {   "0011000000",
                                   "0001100000",
                                   "0000000000", 
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000", 
                                   "0000000000",
                                   "0000000000",
                                   "0000000000"};

          String [] tableroConInsertado = b1.insertPieceInBoard(perritoDerecho, 2);
          int [] posExpected = {2, 0};

          assertArrayEquals(expected, tableroConInsertado);
          assertArrayEquals(posExpected, perritoDerecho.getPosInBoard());
          //assertArrayEquals(posExpected, b1.updateBoardOnTick(perritoDerecho));

            String [] newExpected = {   "0000000000",
                                        "0011000000",
                                        "0001100000", 
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000", 
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          assertArrayEquals(newExpected, b1.updateBoardOnTick(perritoDerecho));

          String [] newExpected1 = {    "0000000000",
                                        "0000000000",
                                        "0011000000", 
                                        "0001100000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000", 
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          assertArrayEquals(newExpected1, b1.updateBoardOnTick(perritoDerecho));

          String [] newExpected2 = {    "0000000000",
                                        "0000000000",
                                        "0000000000", 
                                        "0011000000",
                                        "0001100000",
                                        "0000000000",
                                        "0000000000", 
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          assertArrayEquals(newExpected2, b1.updateBoardOnTick(perritoDerecho));
    }

    @Test
    public void insert_stick_in_board(){
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
                                    "0000000000"};

      assertArrayEquals(expectedBoard, b2.insertPieceInBoard(palito, 5));

      String[] expectedBoard2 = {   "0000000000",
                                    "0000010000",
                                    "0000010000", 
                                    "0000010000",
                                    "0000010000",
                                    "0000000000",
                                    "0000000000", 
                                    "0000000000",
                                    "0000000000",
                                    "0000000000"};
      
      assertArrayEquals(expectedBoard2, b2.updateBoardOnTick(palito));    
      
      String[] expectedBoard3 = {   "0000000000",
                                    "0000000000",
                                    "0000010000", 
                                    "0000010000",
                                    "0000010000",
                                    "0000010000",
                                    "0000000000", 
                                    "0000000000",
                                    "0000000000",
                                    "0000000000"};

      assertArrayEquals(expectedBoard3, b2.updateBoardOnTick(palito)); 

    }
}