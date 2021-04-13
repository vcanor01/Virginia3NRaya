package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;

import modelo.Tipo;
import utiles.RespuestaColocacion;
import vista.UI;

public class ParaUI extends UI {
	private ActionListener acctionListener;
	private Controlador control;

	public ParaUI() {
		super();
		this.preparameEsaBotonera();
		control = new Controlador();
		
		
	}

	private void preparameEsaBotonera() {
		// Si dos acciones están vinculadas secuencialmente
		// deben estar en su propio metodo
		this.crearActionListenerParaBotones();
		this.addEventosALaBotonera();
	}
	
	private void prepararBotonReiniciar() {
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.reiniciarJuego();
				reiniciarBotonera();
				lblMensaje.setText("");
				btnReiniciar.setVisible(false);
				activarPanel(true);
			}
		});
	}
	
	private void crearActionListenerParaBotones() {
		this.acctionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// objeto componente que dispara el evento
				JButton boton = (JButton) e.getSource();
				String[] split = boton.getName().split(":");
//				System.out.println("posicion x" + split[0]);
//				System.out.println("posicion y" + split[1]);
				// llegare aqui cuando alguien hay pulsado un boton
//				de la botonera
				RespuestaColocacion respuestaColocacion = control.realizarJugada(boton.getName());
				if(respuestaColocacion.isRespuesta()) {
					//si estoy aqui es porque ha habido un cambio
					//por lo tanto debo mostrarlo
					boton.setText(respuestaColocacion.getTipo().getNombre());
				}
				lblMensaje.setText(respuestaColocacion.getMensaje());
				
				RespuestaColocacion respuestaColocacionTresEnRaya = control.isTresEnRaya();
				
				if(respuestaColocacionTresEnRaya.isRespuesta()) {
					lblMensaje.setText(respuestaColocacionTresEnRaya.getMensaje());
					btnReiniciar.setVisible(true);
					activarPanel(false);
					prepararBotonReiniciar();
				}
			}
		};
	}

	private void addEventosALaBotonera() {
		Component[] bartolo = this.botonera.getComponents();
		// os presento, otra vez, a la estructura foreach
		for (Component component : bartolo) {
			((JButton) component).addActionListener(this.acctionListener);
		}
	}
	
	//mismo metodo de arriba, pero le voy poniendo el texto en blanco.
	private void reiniciarBotonera() {
		Component[] botones = this.botonera.getComponents();
		for (Component component : botones) {
			((JButton) component).setText("");
		}
	}

}
