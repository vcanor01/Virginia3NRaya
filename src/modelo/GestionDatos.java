package modelo;

import utiles.RespuestaColocacion;

public class GestionDatos {
	private Tablero tablero;
	private Juego juego;
	private Coordenada antigua = null;

	public GestionDatos() {
		super();
		tablero = new Tablero();
		juego = new Juego();
	}

	public RespuestaColocacion realizarJugada(Coordenada coordenada) {
		RespuestaColocacion respuesta = new RespuestaColocacion();
		// A partir de la septima jugada
		if (juego.isMover()) {
			if (tablero.borrarCasilla(coordenada, this.juego.getTurnoActual())) {
				this.juego.setMover(false);
				antigua = coordenada;
				return new RespuestaColocacion(true, "", tablero.getPosicion(coordenada));
			} else {
				return new RespuestaColocacion(false, "Esa casilla no es tuya", tablero.getPosicion(coordenada));
			}
			// luego hay que colocar en un casilla libre contigua
		} else if (juego.isJugadaMovimiento()) {
			return colocarFicha(coordenada, antigua);
		} else {
			return colocarFicha(coordenada);
		}

	}

	private RespuestaColocacion colocarFicha(Coordenada coordenada, Coordenada antigua) {
		if (coordenada.isContigua(antigua)) {
			return colocarFicha(coordenada);
		}
		return new RespuestaColocacion(false, "No es contigua", tablero.getPosicion(coordenada));
	}

	private RespuestaColocacion colocarFicha(Coordenada coordenada) {
		boolean colocada = this.tablero.colocarFicha(coordenada, this.juego.getTurnoActual());
		if (colocada) {
			this.juego.incrementaJugada();
			return new RespuestaColocacion(true, "", tablero.getPosicion(coordenada));
		}
		return new RespuestaColocacion(false, "Casilla no vacia", tablero.getPosicion(coordenada));
	}

	public String getTipoActualName() {
		return this.juego.getTurnoActualName();
	}

	public String getTipoAnteriorName() {
		return this.juego.getTurnoAnteriorName();
	}
	
	public boolean isMover() {
		return this.juego.isMover();
	}
	
	public RespuestaColocacion isTresEnRaya() {
		boolean ganador =false;
		if(tablero.isTresEnRaya()) {
			ganador= true;
			return new RespuestaColocacion(ganador,"¡HAS GANADO! Jugador: "+ this.getTipoAnteriorName());
		}
		return new RespuestaColocacion(ganador, "Sigue jugando");
	}

	

//	public RespuestaColocacion getErrorActualName() {
//		return this.tablero.getErrorActual();
//	}
//	
}
