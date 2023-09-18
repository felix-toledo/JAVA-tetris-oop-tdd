package tetris.ucp;
import java.util.Random;

import tetris.ucp.pieces.PieceBase;
import tetris.ucp.pieces.PieceDog;
import tetris.ucp.pieces.PieceL;
import tetris.ucp.pieces.PieceSquare;
import tetris.ucp.pieces.PieceStick;
import tetris.ucp.pieces.PieceT;
import java.util.ArrayList;


public class Board {
     //Presente en el diagrama UML.
     public void lineCount(){
          this.score = score + 1;
     }

     public PieceBase currentPiece;
     public ArrayList<PieceBase> pieces = new ArrayList<>();

     //A partir de acá se cumple toda la funcionalidad del tablero necesaria para jugar.
     public String [] board = {    "0000000000",
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
                                   "0000000000",
                                   "0000000000"};

     public void setRandomPieceInPieces(){   
          setRandomPieceInPieces(giveRandomPiece());
     }
     public void setRandomPieceInPieces(PieceBase pieza){
          pieces.add(pieza);
     }

     public PieceBase giveRandomPiece(){
          Random rand = new Random();
          int randomNumber = rand.nextInt(7) + 1;
          int randomPos = rand.nextInt(3);
          
          switch(randomNumber) {
               case 1:
                    PieceDog dogRight = new PieceDog(true);
                    dogRight.setPosition(randomPos);
                    return dogRight;
               case 2:
                    PieceDog dogLeft = new PieceDog(false);
                    dogLeft.setPosition(randomPos);
                    return dogLeft;
               case 3:
                    PieceSquare square = new PieceSquare();
                    square.setPosition(randomPos);
                    return square;
               case 4:
                    PieceStick stick = new PieceStick();
                    stick.setPosition(randomPos);
                    return stick;
               case 5:
                    PieceT t = new PieceT();
                    t.setPosition(randomPos);
                    return t;
               case 6:
                    PieceL lRight = new PieceL(true);
                    lRight.setPosition(randomPos);
                    return lRight;
               case 7:
                    PieceL lLeft = new PieceL(false);
                    lLeft.setPosition(randomPos);
                    return lLeft;
               default:
                    return new PieceSquare(); 
     }
          }

    private int score;
     

     public int getScore() {
          return score;
     }

     public void setCurrentPiece() {
          this.currentPiece = giveRandomPiece();
     }

     public boolean game = true;
     
     public void setBoard(String[] boardcito){ // JUST FOR TESTING PURPOSE
          board = boardcito;
     }

     public String [] getBoard(){
          return board;
     }
     
     public boolean checkWinning(){
          if(score == 5){
               return true;
          }else {
               return false;
          }
     }

     public boolean checkBoard(){
          if(!game){
               return false;
          }
          for (int i = 0; i < board.length; i++) {
               if (board[i].equals("1111111111")) {
                    lineCount();
                    for (int j = i; j > 0; j--) {
                         board[j] = board[j - 1];
                    }
                    board[0] = "0000000000";
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
          System.out.println(pieceToInsert.getPiece());
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
          String lineOfThePieceToInsert = pieceToInsert.getPiece().substring((lineInPieceToActualize*4)-4, (lineInPieceToActualize*4));//extraigo la linea de la pieza
          String charactersToInsert = compareCharacters(lineOfTheBoard, lineOfThePieceToInsert, pieceToInsert, positionToInsert, lineInPieceToActualize, lineToUpdate);

          if (charactersToInsert.equals("false")){ // Use .equals() to compare strings
               return "false";
          }

          lineOfTheBoard.replace(positionToInsert, positionToInsert + charactersToInsert.length(), charactersToInsert); //agrego la linea de la pieza en la posición deseada
          String lineUpdated = lineOfTheBoard.toString();

          return lineUpdated; // devuelvo la linea actualizada
     }


     public String[] updateBoardOnTick(){
          return updateBoardOnTick(currentPiece, false);
     }
     public String[] updateBoardOnTick(PieceBase pieceToUpdate, boolean isTesting){
          String [] newBoard = getBoard().clone();
          
          int[] actualPosition = pieceToUpdate.getPosInBoard();
          int lineOfBoardToDelete;
          for (int i = 3; i > -1; i--) {
               
                    if(actualPosition[1] + i > 19){
                         lineOfBoardToDelete = 19;
                    } else {
                         lineOfBoardToDelete = actualPosition[1] + i;
                    }
               board[lineOfBoardToDelete] = deleteActualPieceGoingDown(lineOfBoardToDelete, pieceToUpdate, actualPosition[0], i+1);
          }

          for (int i = 3; i > -1; i--) {
               int lineOfBoard;
                    if(actualPosition[1] + i + 1 > 19){
                         lineOfBoard = 19;
                    } else {
                         lineOfBoard = actualPosition[1] + i + 1;
                    }
               String lineToUpdate = lineUpdate(lineOfBoard, pieceToUpdate, actualPosition[0], i+1);
               if(lineToUpdate.equals("false")){ 
                    board = newBoard.clone();
                    if(!isTesting){
                         insertPieceInBoard();
                    }
                    return board;
               } else {
                    board[lineOfBoard] = lineToUpdate;
               }
          }
     
          pieceToUpdate.setPosInBoard(actualPosition[0], actualPosition[1]+1);
          
          return board;
     }
     
     public String[] insertPieceInBoard(){
          setCurrentPiece();
          Random rand = new Random();
          int randomNum = rand.nextInt(10);
          
          return insertPieceInBoard(currentPiece, randomNum);
     }

     public String[] insertPieceInBoard(PieceBase piece, int position){
          checkBoard();
          currentPiece = piece;

          for (int i = 3; i > -1; i--) {
               board[i] = lineUpdate(i, piece, position, i + 1);
          }
          

          piece.setPosInBoard(position, 0);

          return board;
     }
}