package tetris.ucp;
import java.util.Random;

import tetris.ucp.pieces.PieceBase;


public class Board {
     //Creo el tablero.
     public String [] board = {    "0000000000",
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
          //linea 0+1 -> primer linea de la pieza
          board[actualPosition[1]] = "0000000000";

          for (int i = 0; i < 4; i++) {
               board[actualPosition[1] + i + 1] = lineUpdate(actualPosition[1] + i + 2, pieceToUpdate, actualPosition[0], i + 1);
          }
     
          pieceToUpdate.setActualPos(actualPosition[0], actualPosition[1]+1);
          
          return board;
     }
     
     public String[] insertPieceInBoard(PieceBase piece, int position){

          for (int i = 0; i < 4; i++) {
               board[i] = lineUpdate(i + 1, piece, position, i + 1);
          }

          piece.setActualPos(position, 0);

          return board;
     }
}
