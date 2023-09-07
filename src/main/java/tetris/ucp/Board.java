package tetris.ucp;
import java.util.Random;

import tetris.ucp.pieces.PieceBase;

//TODO: 
/*
 * -Numeros random para la posición en la que entra la figura, Y otro para el estado de la figura.
 * -Agregar un estado de pieza actual para saber cual es la que esta descendiendo a medida que el reloj avanza.
 */


public class Board {
     //Creo el tablero.
     public String [] board = {"0000000000",
                              "0000000000",
                              "0000000000",
                              "0000000000",
                              "0000000000",
                              "0000000000",
                              "0000000000",
                              "0000000000",
                              "0000000000",
                              "0000000000"};
     
     public void setboard(String[] boardcito){ // JUST FOR TESTING THINGS. IGNORE
          board = boardcito;
     }

     /*public Board(){
          for (int i=0 ; i < 11; i++){
               board[i] = "0000000000";
          }
     }*/
     

     //Funcion que me va a servir para actualizar una linea del tablero con UNA LINEA de la pieza.
     public String lineUpdate(int lineToUpdate, PieceBase pieceToInsert, int positionToInsert, int lineInPieceToActualize, boolean isDeleting){

          StringBuilder lineOfTheBoard = new StringBuilder(board[lineToUpdate]); //extraigo la linea del tablero.
          String lineOfThePieceToInsert = pieceToInsert.showPiece().substring((lineInPieceToActualize*4)-4, (lineInPieceToActualize*4));//extraigo la linea de la pieza
          //Comparar caracter por caracter la linea que se va a actualizar con la linea que va a ingresar.
          //Si todos los 1 de esa linea no choca con ningun 1 de la linea que ingresa, puede seguir, si no, me devuelve. -> DEBERÍA CHEQUEAR SOLO LA ÚLTIMA LINEA
          //-> LA ULTIMA LINEA TINEE QUE PASAR PRIMERO ASI CHEQUEO PRIMERO ESA Y NO CHOCAN ENTRE LA MISMA PIEZA
          StringBuilder newStringForLine= new StringBuilder();

          //me quede en que si is deleting es igual a true, entonces se debería borrar la figura que esta en las posiciones de la figura en el tablero, pero hay q chequear cuando gira.

          //Esto se puede sacar a otra funcion :)
          for (int i = positionToInsert; i < positionToInsert + 4; i++){
               //i = 2 - 3 - 4 - 5 
               int pieceXPosition = i-positionToInsert;
               //piece -> 0-1-2-3
               char characterOfPiece = lineOfThePieceToInsert.charAt(pieceXPosition);
               char characterOfBoard = lineOfTheBoard.charAt(i);
               System.out.println("compare" + characterOfPiece + " - " + characterOfBoard);
               if(lineInPieceToActualize == 4){
                    if(characterOfPiece == "1".charAt(0) && characterOfBoard == "1".charAt(0)){
                         return "false";
                    }
               }
               if(characterOfPiece == "0".charAt(0)){
                    newStringForLine.append(characterOfBoard);
               }
               if(characterOfPiece == "1".charAt(0)  && characterOfBoard == "1".charAt(0)){
                    newStringForLine.append("1");
               }else if (characterOfPiece == "0".charAt(0) && characterOfBoard == "1".charAt(0)){
                    newStringForLine.append("0");
               }else if(characterOfPiece == "0".charAt(0) && characterOfBoard == "0".charAt(0)){
                    newStringForLine.append("0");
               }else if(characterOfPiece == "1".charAt(0) && characterOfBoard == "0".charAt(0)){
                    newStringForLine.append("1");
               }
               
               //linea que sea de 10 -> "00000/0000/0"
               //Linea de 4 "0010"
          }

          System.out.println(newStringForLine);

          String newPieceOFLine = newStringForLine.toString();
          lineOfTheBoard.replace(positionToInsert, positionToInsert + newPieceOFLine.length(), newPieceOFLine); //agrego la linea de la pieza en la posición deseada
          String lineUpdated = lineOfTheBoard.toString();

          return lineUpdated; // devuelvo la linea actualizada
     }

     public String[] updateBoardOnTick(PieceBase pieceToUpdate){
          int[] actualPosition = pieceToUpdate.getPosInBoard();
          if (actualPosition[1] == 6){
               return board;
          } else{
               //linea 0+1 -> primer linea de la pieza
               for (int i = 3; i > -1; i--) {
                    board[actualPosition[1]] = lineUpdate(actualPosition[1], pieceToUpdate, actualPosition[0], i + 1, true);
               }


               for (int i = 3; i > -1; i--) {
                    board[actualPosition[1] + i + 1] = lineUpdate(actualPosition[1] + i + 1, pieceToUpdate, actualPosition[0], i + 1, false);
                    if(board[actualPosition[1] + i + 1] == "false"){
                         return board;
                    }
               }
          
               pieceToUpdate.setActualPos(actualPosition[0], actualPosition[1]+1);
               
               return board;
          }
     }
     
     public String[] insertPieceInBoard(PieceBase piece, int position){

          for (int i = 3; i > -1; i--) {
               board[i] = lineUpdate(i, piece, position, i + 1, false);
          }
          

          piece.setActualPos(position, 0);

          return board;
     }
}
