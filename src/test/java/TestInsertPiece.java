import static org.junit.Assert.*;

import org.junit.Test;

import tetris.ucp.Board;
import tetris.ucp.pieces.PieceDog;
import tetris.ucp.pieces.PieceSquare;

public class TestInsertPiece 
{
    @Test
    public void insert_square_in_board(){
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
          //assertEquals(posExpected, perritoDerecho.getPosInBoard());

          String [] newExpected = {     "0011000000",
                                        "0011000000",
                                        "0011000000", 
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000", 
                                        "0000000000",
                                        "0000000000",
                                        "0000000000"};

          assertArrayEquals(newExpected, b1.updateBoardOnTick(perritoDerecho));
    }
}