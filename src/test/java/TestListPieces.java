import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tetris.ucp.*;
import tetris.ucp.pieces.*;

public class TestListPieces 
{
    @Test
     public void check_into_list(){
          PieceStick palo = new PieceStick();
          Board tabla = new Board();

          tabla.setRandomPieceInPieces(palo);

          assertEquals(palo, tabla.pieces.get(0));
     }

     @Test
     public void checking_how_many_sticks(){
          Board tabla = new Board();
          for (int i = 0; i < 100; i++){
               tabla.setRandomPieceInPieces();
          }

          

          long counter = tabla.pieces
                         .stream()
                         .filter(piz -> piz instanceof PieceStick)
                         .count();
          
          assertEquals(100, tabla.pieces.size());
          assertNotNull(counter);
     }

     @Test
     public void knowing_how_many_sticks(){
          Board tabla = new Board();
          ArrayList<PieceStick> palos = new ArrayList<>();
          PieceStick palo = new PieceStick();
          PieceStick palo1 = new PieceStick();
          PieceStick palo2 = new PieceStick();

          palos.add(palo);
          palos.add(palo1);
          palos.add(palo2);


          for (int i = 0; i < 3; i++){
               tabla.setRandomPieceInPieces(palos.get(i));
          }

          long counter = tabla.pieces
                         .stream()
                         .filter(piz -> piz instanceof PieceStick)
                         .count();

          assertEquals(3, counter);
     }
}