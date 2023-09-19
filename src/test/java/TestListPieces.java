import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.function.Predicate;

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

     @Test
     public void give_all_pieces_looking_at_right(){
          Board tabla = new Board();
          for (int i = 0; i < 100; i++){
               tabla.setRandomPieceInPieces();
          }
          
          Predicate<PieceBase> filtroT = p -> p instanceof PieceT;
          Predicate<PieceBase> filtroDerecha = p -> p.isLookingRight();

          Predicate<PieceBase> filtroTAndDerecha = filtroT.and(filtroDerecha);

          long result = tabla.pieces.stream().filter(filtroTAndDerecha).count();

          assertNotNull(tabla.pieces);
          assertTrue(result>0);
          
     }

     @Test
     public void giveTwoPieces_filterOne(){
          Board tabla = new Board();
          PieceT te = new PieceT();
          PieceT te2 = new PieceT();
          PieceT te3 = new PieceT();
          PieceL l = new PieceL(false);

          te.rotateRight();
          te2.rotateRight();

          tabla.setRandomPieceInPieces(l);
          tabla.setRandomPieceInPieces(te);
          tabla.setRandomPieceInPieces(te2);
          tabla.setRandomPieceInPieces(te3);

          Predicate<PieceBase> filtroT = p -> p instanceof PieceT;
          Predicate<PieceBase> filtroDerecha = p -> p.isLookingRight();

          Predicate<PieceBase> filtroTAndDerecha = filtroT.and(filtroDerecha);

          long result = tabla.pieces.stream().filter(filtroTAndDerecha).count();
          long resultT = tabla.pieces.stream().filter(filtroT).count();

          assertNotNull(tabla.pieces);
          assertEquals(2, result);
          assertEquals(3, resultT);
     }
}