import static org.junit.Assert.*;
import org.junit.Test;
import tetris.ucp.*;
import tetris.ucp.pieces.*;

public class RequirementTest_Third {
     @Test
     public void check_table_lenght(){
          Tetris juego = new Tetris();
          //Chequeo de largo del tablero.
          assertEquals(20 ,juego.board.getBoard().length);

          //Chequeo del ancho del tablero
          assertEquals(10 ,juego.board.getBoard()[2].length());
     }

     @Test
     public void piece_cooming_from_up(){
          Tetris juego = new Tetris();
          PieceSquare cuadrado = new PieceSquare();

          String[] expectedBoard ={"0011000000",
                                   "0011000000",
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

          //LA PIEZA VA INGRESANDO POR LA PARTE DE ARRIBA.
          assertArrayEquals(expectedBoard, juego.board.insertPieceInBoard(cuadrado, 2));
          
          String[] expectedBoard2 ={    "0000000000",
                                        "0011000000",
                                        "0011000000",
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
                                        
          //LA PIEZA VA BAJANDO A MEDIDA QUE SE LLAMA EL UPDATE BOARD ON TICK.
          assertArrayEquals(expectedBoard2, juego.board.updateBoardOnTick(cuadrado, true));
     
          //LA PIEZA ACTUAL SOLAMENTE ES LA QUE DESCIENDE A MEDIDA QUE EL RELOJ AVANZA.
          assertEquals(cuadrado, juego.board.currentPiece);
     }

     @Test
     public void piece_down_tick_up(){
          Tetris juego = new Tetris();

          juego.start();
          assertEquals(1, juego.clock.getTimer());

          juego.tick();
          assertEquals(2, juego.clock.getTimer());

          assertNotNull(juego.board.getBoard());
     }

     @Test
     public void thePiece_can_go_inside_some_spaces(){
          Board colitionBoard = new Board();
          PieceT te = new PieceT();

          //HAGO UN ESPACIO PARA QUE LA T PUEDA ENTRAR
          String[] boardForTesting = {  "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0010100000",
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

          colitionBoard.setBoard(boardForTesting);

          String[] boardExpected = {    "0011100000",
                                        "0001000000",
                                        "0000000000",
                                        "0000000000",
                                        "0010100000",
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

          assertArrayEquals(boardExpected, colitionBoard.insertPieceInBoard(te, 2));

          String[] boardExpected2 = {   "0000000000",
                                        "0000000000",
                                        "0000000000",
                                        "0011100000",
                                        "0011100000",
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
          
          colitionBoard.updateBoardOnTick(te, true);
          colitionBoard.updateBoardOnTick(te, true);
          colitionBoard.updateBoardOnTick(te, true);
          assertArrayEquals(boardExpected2, colitionBoard.updateBoardOnTick(te, true));
          
          //ACA DEMUESTRO QUE SI ESTOY TESTEANDO NO AGREGA OTRA COSA.
          assertArrayEquals(boardExpected2, colitionBoard.updateBoardOnTick(te, true));

          //REQUERIMIENTO 4, DETENIENDO MOVIMIENTO PIEZA ACTUAL.
          //ACA MOSTRAMOS QUE SI NO ESTA TESTEANDO, REALMENTE AGREGA OTRA PIEZA CUANDO YA NO TIENE MÁS ESPACIO PARA BAJAR
          colitionBoard.updateBoardOnTick(te, false);
          boolean firstLineContainsOne = false;
          if(colitionBoard.getBoard()[0].contains("1")){
               firstLineContainsOne = true;
          }

          assertTrue(firstLineContainsOne);
          // ACA TERMINA
     }

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
}
