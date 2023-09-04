package tetris.ucp;
import tetris.ucp.pieces.PieceBase;


public class Board {

     public String [] tablero = {  "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000",
                                   "0000000000"};

     public String insertPiece(PieceBase pieza, int posicion){
          return pieza.showPiece();
          
     }
}
