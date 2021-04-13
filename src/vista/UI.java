package vista;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class UI extends JFrame {

	private JPanel contentPane;
	protected JPanel botonera;
	protected JLabel lblMensaje;
	protected JButton btnReiniciar;

	/**
	 * Create the frame.
	 */
	public UI() {
		int dimension = 3;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		botonera = new JPanel();
		botonera.setForeground(new Color(0, 0, 0));
		botonera.setBounds(97, 56, 228, 181);
		contentPane.add(botonera);
		botonera.setLayout(new GridLayout(3, 3, 0, 0));
		contentPane.setBackground(new Color(102, 117, 127));

		JLabel lblNewLabel = new JLabel("MENSAJE:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 11, 97, 34);
		contentPane.add(lblNewLabel);

		lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMensaje.setForeground(new Color(85, 172, 238));
		lblMensaje.setBounds(106, 11, 221, 30);
		contentPane.add(lblMensaje);

		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReiniciar.setForeground(Color.BLACK);

		btnReiniciar.setVisible(false);
		btnReiniciar.setBounds(335, 17, 89, 23);
		contentPane.add(btnReiniciar);

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				JButton comp = new JButton();
				comp.setName(i + ":" + j);
				botonera.add(comp);

			}
		}

		activarPanel(true);
	}

	protected void activarPanel(boolean bandera) {
		Component[] botones = this.botonera.getComponents();
		
		for (Component boton : botones) {
			((JButton) boton).setEnabled(bandera);
		}

	}

}
