package control;

import modelo.Coordenada;
import modelo.GestionDatos;
import utiles.RespuestaColocacion;

public class Controlador {
	private GestionDatos gestion;

	public Controlador() {
		super();
		gestion = new GestionDatos();
	}
	
	
	public RespuestaColocacion realizarJugada(String posicion){
		return this.gestion.realizarJugada(new Coordenada(posicion));
	}

	public String getTipoName() {
		return this.gestion.getTipoActualName();
	}

	public String getTipoAnteriorName() {
		return this.gestion.getTipoAnteriorName();
	}
	
	public boolean isMover() {
		return this.gestion.isMover();
	}
	
	public RespuestaColocacion isTresEnRaya() {
		return this.gestion.isTresEnRaya();
	}
	
	public void reiniciarJuego() { 
		this.gestion = new GestionDatos();
	}

	

//	public String getErrorName() {
//		return this.gestion.getErrorActualName();
//	}

}
