package modelo;

import utiles.RespuestaColocacion;

public class Tablero {

	private int dimension = 3;
	private Tipo matriz[][] = new Tipo[dimension][dimension];
	private String errorActual = "";

	public Tipo getValorCasilla(int x, int y) {
		return matriz[x][y];
	}

	public Tablero() {
		super();
		inicializarMatriz();
	}

	private void inicializarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = Tipo.blanco;
			}
		}
	}

	public boolean limpiarCasilla(Coordenada coordenada) {
		if (getPosicion(coordenada) != Tipo.blanco) {
			setPosicion(coordenada, Tipo.blanco);
			return true;
		}
		return false;
	}

	private void setPosicion(Coordenada coordenada, Tipo blanco) {
		matriz[coordenada.getX()][coordenada.getY()] = blanco;

	}

	public boolean borrarCasilla(Coordenada coordenada, Tipo tipo) {
		// primero hay que borrar una casilla no bloqueada de tu turno
		if (isPropiedad(coordenada, tipo) && !comprobarCasillaBloqueada(coordenada)) {
			limpiarCasilla(coordenada);
			return true;
		}
		return false;
	}

	public boolean colocarFicha(Coordenada coordenada, Tipo tipoActual) {
		
		if (matriz[coordenada.getX()][coordenada.getY()] == Tipo.blanco) {
			matriz[coordenada.getX()][coordenada.getY()] = tipoActual;
//			System.out.println("coordenada puesta");
			return true;
		}
		return false;
	}

	public Tipo getPosicion(Coordenada coordenada) {
		return matriz[coordenada.getX()][coordenada.getY()];
	}

	private boolean isLibre(Coordenada coordenada) {
		return getPosicion(coordenada) == Tipo.blanco;
	}

	/**
	 * 
	 * @param coordenada
	 * @return false si encuentra una libre y true en caso contrario
	 */
	public boolean comprobarCasillaBloqueada(Coordenada coordenada) {
		for (int x = coordenada.getX() - 1; x <= coordenada.getX() + 1; x++)
			for (int y = coordenada.getY() - 1; y <= coordenada.getY() + 1; y++)
				if (x >= 0 && x < this.dimension && y >= 0 && y < this.dimension)
					if (this.isLibre(new Coordenada(x, y)))
						return false;
		return true;
	}

	public String getErrorActual() {
		return this.errorActual;
	}

	public boolean isPropiedad(Coordenada coordenada, Tipo tipo) {
		return getPosicion(coordenada) == tipo;
	}
	
	public boolean isHorizontal() {
		boolean bandera = false;
		for (int i = 0; i < matriz.length; i++) {
			if( matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][1] != Tipo.blanco  ) {
				bandera= true;
			}
		}
		return bandera;
	}
	
	public boolean isVertical() {
		boolean bandera = false;
		for (int j = 0; j < matriz.length; j++) {
			if( matriz[0][j] == matriz[1][j] && matriz[1][j] == matriz[2][j] && matriz[1][j] != Tipo.blanco  ) {
				bandera= true;
			}
		}
		return bandera;
	}
	public boolean isDiagonal(){
		boolean bandera=false;
		if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[1][1] !=Tipo.blanco) {
			bandera = true;
		}
		if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[0][2] !=Tipo.blanco) {
			bandera=true;
		}
		return bandera;
	}
	
	public boolean isTresEnRaya() {
		if(isHorizontal() || isDiagonal() || isVertical()) {
			return true;
		}
		return false;
	}
	

}
