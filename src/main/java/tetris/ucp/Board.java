package tetris.ucp;
import java.util.Random;

import javax.xml.namespace.QName;

import tetris.ucp.pieces.PieceBase;


public class Board {
     //Creo el tablero.
     public String [] board = {  "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000"};

     //Funcion que me va a servir para actualizar una linea del tablero con UNA LINEA de la pieza.
     public String lineUpdate(int lineToUpdate, PieceBase pieceToInsert, int positionToInsert, int lineInPieceToActualize){
          StringBuilder lineOfTheBoard = new StringBuilder(board[lineToUpdate-1]); //extraigo la linea del tablero.
          String lineOfThePieceToInsert = pieceToInsert.showPiece().substring((lineInPieceToActualize*4)-4, (lineInPieceToActualize*4)-1);//extraigo la linea de la pieza
          lineOfTheBoard.replace(positionToInsert, positionToInsert + lineOfThePieceToInsert.length(), lineOfThePieceToInsert); //agrego la linea de la pieza en la posición deseada
          String lineUpdated = lineOfTheBoard.toString();

          return lineUpdated; // devuelvo la linea actualizada
     }

     public String[] updateBoardOnTick(PieceBase pieceToUpdate){
          int[] actualPosition = pieceToUpdate.getPosInBoard();
          board[actualPosition[1]+4] = lineUpdate(actualPosition[1]+5, pieceToUpdate, actualPosition[0], 4);
          pieceToUpdate.setActualPos(actualPosition[0], actualPosition[1]+1);

          return board;
     }
     
     public String[] insertPieceInBoard(PieceBase piece, int position){
          board[3] = lineUpdate(4, piece, position, 4);
          board [2] = lineUpdate(3, piece, position, 3);
          board [1] = lineUpdate(2, piece, position, 2);
          board [0] = lineUpdate(1, piece, position, 1);

          piece.setActualPos(position, 0);

          return board;
     }
}
