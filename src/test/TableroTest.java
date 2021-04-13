package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Coordenada;
import modelo.Tablero;
import modelo.Tipo;

class TableroTest {

	Tablero tablero;

	@BeforeEach
	void before() {
		tablero = new Tablero();
	}

	@Test
	void test() {
		int dimension = 3;
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				assertEquals(Tipo.blanco, tablero.getValorCasilla(i, j));
			}
		}
	}

	@Test
	void testcomprobarBloqueada() {
		int posX[] = {0,0,1,1,2,2};
		int posY[] = {1,2,2,1,0,1};
		Tipo tipos[]= {Tipo.X,Tipo.O,Tipo.X,Tipo.O,Tipo.X,Tipo.O};
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i],posY[i]), tipos[i]);
		}
		assertTrue(tablero.comprobarCasillaBloqueada(new Coordenada(0,2)));
		assertFalse(tablero.comprobarCasillaBloqueada(new Coordenada(1,1)));
	}
	
	
	
	@Test
	void testIsHorizontal() {
		//Horizontal
		int posX[] = {0,0,0,1,2,2};
		int posY[] = {0,1,2,1,0,2};
		Tipo tipos[]= {Tipo.X,Tipo.X,Tipo.X,Tipo.O,Tipo.O,Tipo.O};
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posX[i],posY[i]), tipos[i]);
		}
		
		assertTrue(tablero.isHorizontal());
		
	}
	
	@Test
	void testIsVertical() {
		//vertical
		int posXvertical[] = {0,1,2,1,2,2};
		int posYvertical[] = {0,0,0,1,1,2};
		Tipo tipos[]= {Tipo.X,Tipo.X,Tipo.X,Tipo.O,Tipo.O,Tipo.O};
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posXvertical[i],posYvertical[i]), tipos[i]);
		}
		
		assertTrue(tablero.isVertical());
		
	}
	
	@Test
	void testIsDiagonal() {
		//Diagonal
		int posXdiagonal[] = {2,1,0,1,2,2};
		int posYdiagonal[] = {0,1,2,0,1,2};
		Tipo tipos[]= {Tipo.X,Tipo.X,Tipo.X,Tipo.O,Tipo.O,Tipo.O};
		for (int i = 0; i < tipos.length; i++) {
			tablero.colocarFicha(new Coordenada(posXdiagonal[i],posYdiagonal[i]), tipos[i]);
		}
		
		assertTrue(tablero.isDiagonal());
		
	}

}
