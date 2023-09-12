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

     public PieceBase currentPiece;

     public void setCurrentPiece(PieceBase currentPiece) {
          this.currentPiece = currentPiece;
     }

     private boolean game = true;
     
     public void setBoard(String[] boardcito){ // JUST FOR TESTING PURPOSE
          board = boardcito;
     }

     public String [] getBoard(){
          return board;
     }
     
     public boolean checkBoard(){
          if(!game){
               return false;
          }
          for (int i = 0; i < board.length; i++) {
               if (board[i].equals("1111111111")) {
                    for (int j = i; j > 0; j--) {
                         board[j] = board[j - 1];
                    }
                    board[0] = "0000000000";
                    return true;
               }
          }
          if (board[0].contains("1")) {
               return false;
          }
          return true;
     }

     public String deleteActualPieceGoingDown(int lineToUpdate, PieceBase pieceToInsert, int positionToInsert, int lineInPieceToActualize){
          int[] actualPosition = pieceToInsert.getPosInBoard();
          StringBuilder lineOfTheBoard = new StringBuilder(board[lineToUpdate]); //extraigo la linea del tablero.
          String lineOfThePieceToInsert = pieceToInsert.showPieceInPosition(actualPosition[2]).substring((lineInPieceToActualize*4)-4, (lineInPieceToActualize*4));//extraigo la linea de la pieza
     
          StringBuilder updatedLine = new StringBuilder(lineOfTheBoard);
          for (int i = positionToInsert; i < positionToInsert + 4; i++) {
               int pieceXPosition = i-positionToInsert;
               char characterOfPiece = lineOfThePieceToInsert.charAt(pieceXPosition);

               if (characterOfPiece == '1') {
                    updatedLine.setCharAt(i, '0');
               }
          }
          return updatedLine.toString();
     }

    public String compareCharacters(StringBuilder lineOfTheBoard, String lineOfThePieceToInsert, PieceBase pieceToInsert, int positionToInsert, int lineInPieceToActualize, int lineToUpdate){
     StringBuilder newStringForLine= new StringBuilder();
     for (int i = positionToInsert; i < positionToInsert + 4; i++ ){
          int pieceXPosition = i-positionToInsert;
          char characterOfPiece = lineOfThePieceToInsert.charAt(pieceXPosition);
          if (i >= lineOfTheBoard.length() && characterOfPiece == "0".charAt(0)) {
               break;
          }
          char characterOfBoard = lineOfTheBoard.charAt(i);
          if (lineToUpdate == 0 && lineInPieceToActualize != 1){
               game = false;
               break; 
          }
          if (characterOfPiece == "1".charAt(0) && characterOfBoard == "1".charAt(0)){
               return "false";
          } else if (characterOfBoard != characterOfPiece){
               newStringForLine.append("1");
          } else {
               newStringForLine.append("0");
          }
     }

     return newStringForLine.toString();
}

     

     //Funcion que me va a servir para actualizar una linea del tablero con UNA LINEA de la pieza.
     public String lineUpdate(int lineToUpdate, PieceBase pieceToInsert, int positionToInsert, int lineInPieceToActualize){
          StringBuilder lineOfTheBoard = new StringBuilder(board[lineToUpdate]); //extraigo la linea del tablero.
          System.out.println(lineOfTheBoard);
          String lineOfThePieceToInsert = pieceToInsert.showPiece().substring((lineInPieceToActualize*4)-4, (lineInPieceToActualize*4));//extraigo la linea de la pieza
          String charactersToInsert = compareCharacters(lineOfTheBoard, lineOfThePieceToInsert, pieceToInsert, positionToInsert, lineInPieceToActualize, lineToUpdate);

          if (charactersToInsert.equals("false")){ // Use .equals() to compare strings
               return "false";
          }

          lineOfTheBoard.replace(positionToInsert, positionToInsert + charactersToInsert.length(), charactersToInsert); //agrego la linea de la pieza en la posición deseada
          String lineUpdated = lineOfTheBoard.toString();

          return lineUpdated; // devuelvo la linea actualizada
     }

     public String[] updateBoardOnTick(PieceBase pieceToUpdate){
          String [] newBoard = getBoard().clone();
          
          int[] actualPosition = pieceToUpdate.getPosInBoard();
          int lineOfBoardToDelete;
          for (int i = 3; i > -1; i--) {
               
                    if(actualPosition[1] + i > 9){
                         lineOfBoardToDelete = 9;
                    } else {
                         lineOfBoardToDelete = actualPosition[1] + i;
                    }
               board[lineOfBoardToDelete] = deleteActualPieceGoingDown(lineOfBoardToDelete, pieceToUpdate, actualPosition[0], i+1);
          }

          for (int i = 3; i > -1; i--) {
               int lineOfBoard;
                    if(actualPosition[1] + i + 1 > 9){
                         lineOfBoard = 9;
                    } else {
                         lineOfBoard = actualPosition[1] + i + 1;
                    }
               String lineToUpdate = lineUpdate(lineOfBoard, pieceToUpdate, actualPosition[0], i+1);
               System.out.println(lineToUpdate);
               if(lineToUpdate.equals("false")){ 
                    board = newBoard.clone();
                    return board;
               } else {
                    board[lineOfBoard] = lineToUpdate;
               }
          }
     
          pieceToUpdate.setActualPos(actualPosition[0], actualPosition[1]+1);
          
          return board;
     }
     
     public String[] insertPieceInBoard(PieceBase piece){
          Random rand = new Random();
          int randomNum = rand.nextInt(10);
          
          return insertPieceInBoard(piece, randomNum);
     }

     public String[] insertPieceInBoard(PieceBase piece, int position){

          for (int i = 3; i > -1; i--) {
               board[i] = lineUpdate(i, piece, position, i + 1);
          }
          

          piece.setActualPos(position, 0);

          return board;
     }
}