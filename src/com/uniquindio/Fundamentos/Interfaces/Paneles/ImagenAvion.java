package com.uniquindio.Fundamentos.Interfaces.Paneles;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.uniquindio.Fundamentos.Interfaces.VentanaPago;
import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.VentanaSillas;
import com.uniquindio.Fundamentos.Mundo.Avion;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Pasajero;
import com.uniquindio.Fundamentos.Mundo.RegistroVueloPorPasajero;
import com.uniquindio.Fundamentos.Mundo.Silla;
import com.uniquindio.Fundamentos.Mundo.Vuelo;

/**
 * Panel que contiene la imagen del avión con todas sus sillas
 * 
 * @author Cesar Marquez - Brian Giraldo
 *
 */
@SuppressWarnings("serial")
public class ImagenAvion extends JPanel implements ActionListener {

	private int contador;
	private JButton BotonesSillasEje[];
	private JButton botonesSillasEco[];
	private Avion avion;
	private VentanaPrincipal miVentanaPrincipal;
	private int pasajerosTotal;
	private Cliente miCliente;
	private Vuelo vueloSeleccionado;
	private ImagenAvion p = this;
	private ImageIcon imagen;
	ArrayList<Pasajero> misPasajeros;
	private ArrayList<Pasajero> pasajeros;
	private ArrayList<Silla> sillasSeleccionadas = new ArrayList<Silla>();
	private String modalidad;
	private String fechaaRegreso;

	/**
	 * Constructor del panel
	 * @param vueloSeleccionado Vuelo seleccionado por el usuario.
	 * @param pasajerosTotal Número de pasajeros seleccionado por el usuario.
	 * @param miClienteLogeado Cliente actualmente logeado.
	 * @param miVentanaPrincipal Ventana principal del programa.
	 * @param pasajeros Lista de pasajeros.
	 */
	public ImagenAvion(Vuelo vueloSeleccionado, int pasajerosTotal, Cliente miClienteLogeado,
			VentanaPrincipal miVentanaPrincipal, ArrayList<Pasajero> pasajeros, String modalidad, String fechaaRegreso) {

		super(new BorderLayout());
		this.vueloSeleccionado = vueloSeleccionado;
		this.pasajerosTotal = pasajerosTotal;
		this.miCliente = miClienteLogeado;
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.fechaaRegreso = fechaaRegreso;
		avion = vueloSeleccionado.getAvion();
		contador = 1;
		misPasajeros = vueloSeleccionado.getPasajerosEnVuelo();
		imagen = new ImageIcon("src/imagenes/avionPequeño.png");
		this.modalidad = modalidad;
		this.pasajeros = pasajeros;
		setPreferredSize(new Dimension(imagen.getIconWidth(), imagen.getIconHeight()));
		setOpaque(false);

		JPanel panelEjecutivas = new JPanel();
		panelEjecutivas.setBorder(new EmptyBorder(28, 150, 10, 160));
		dibujarSillasEjecutivas(panelEjecutivas);
		add(panelEjecutivas, BorderLayout.NORTH);

		// Adiciona las imágenes de las sillas económicas
		JPanel panelEconomicas = new JPanel();
		panelEconomicas.setBorder(new EmptyBorder(20, 155, 10, 160));
		dibujarSillasEconomicas(panelEconomicas);
		add(panelEconomicas, BorderLayout.CENTER);
	}

	public void paint(Graphics pGrafica) {
		pGrafica.drawImage(imagen.getImage(), 0, 0, null, null);
		super.paint(pGrafica);
	}

	/**
	 * Método que dibujar las sillas ejecutivas en el panel que ingresa como parámetro
	 * @param panelEjecutivas
	 */
	public void dibujarSillasEjecutivas(JPanel panelEjecutivas) {
		int j = 0;

		BotonesSillasEje = new JButton[12];
		panelEjecutivas.setLayout(new GridLayout(Avion.SILLAS_EJECUTIVAS / 4, 5, 4, 5));

		boolean centinela = false;
		Silla[] misSillas = avion.getSillasEjecutivas();
		for (int i = 0; i < BotonesSillasEje.length; i++) {
			centinela = false;

			BotonesSillasEje[i] = new JButton("");

			BotonesSillasEje[i].addActionListener(this);

			panelEjecutivas.add(BotonesSillasEje[i]);
			for (j = j; j < misSillas.length && centinela == false; j++) {
				String numero = misSillas[j].getNumero();
				BotonesSillasEje[i].setName(numero);
				if (misSillas[j].sillaAsignada() == false) {
					BotonesSillasEje[i].setIcon(
							new ImageIcon(VentanaSillas.class.getResource("/imagenes/silla-ejec-libre.png")));
				} else {
					BotonesSillasEje[i].setIcon(
							new ImageIcon(VentanaSillas.class.getResource("/imagenes/silla-ejec-asig.png")));
				}
				BotonesSillasEje[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				BotonesSillasEje[i].setFocusPainted(false);
				BotonesSillasEje[i].setContentAreaFilled(false);
				BotonesSillasEje[i].setBorder(null);
				centinela = true;
			}

			if (i % 4 == 1) {
				panelEjecutivas.add(new JLabel(" "));
			}

			panelEjecutivas.setOpaque(false);

		}

	}

	/**
	 * Método que dibujar las sillas económicas en el panel que ingresa como parámetro.
	 * @param panelEconomicas
	 */
	public void dibujarSillasEconomicas(JPanel panelEconomicas) {
		int j = 0;

		panelEconomicas.setLayout(new GridLayout(Avion.SILLAS_ECONOMICAS / 6, 7, 5, 4));
		botonesSillasEco = new JButton[138];
		boolean centinela = false;
		Silla[] misSillas = avion.getSillasEconomicas();
		for (int i = 0; i < botonesSillasEco.length; i++) {
			centinela = false;
			botonesSillasEco[i] = new JButton("");

			botonesSillasEco[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			botonesSillasEco[i].setFocusPainted(false);
			botonesSillasEco[i].setContentAreaFilled(false);
			botonesSillasEco[i].setBorder(null);
			botonesSillasEco[i].addActionListener(this);

			panelEconomicas.add(botonesSillasEco[i]);
			for (j = j; j < misSillas.length && centinela == false; j++) {
				String numero = misSillas[j].getNumero();
				botonesSillasEco[i].setName(numero);
				if (misSillas[j].sillaAsignada() == false) {
					botonesSillasEco[i].setIcon(
							new ImageIcon(VentanaSillas.class.getResource("/imagenes/silla-econ-libre.png")));
				} else {
					botonesSillasEco[i].setIcon(
							new ImageIcon(VentanaSillas.class.getResource("/imagenes/silla-econ-asig.png")));
				}
				centinela = true;
			}

			if (i % 6 == 2) {
				panelEconomicas.add(new JLabel(" "));
			}

			panelEconomicas.setOpaque(false);

		}

	}

	/**
	 * Método que permite buscar una silla en la clase económica que contenga el número especificado.
	 * @param numero Representa el número de la silla a buscar.
	 * @return Retorna la silla encontrada.
	 */
	public Silla buscarSillaEco(String numero) {
		Silla silla = null;
		boolean centinela = false;
		Silla[] misSillasEco = avion.getSillasEconomicas();
		for (int i = 0; i < misSillasEco.length && centinela == false; i++) {
			String numeroActual = misSillasEco[i].getNumero();
			if (numeroActual.equals(numero)) {
				silla = misSillasEco[i];
				centinela = true;
			}
		}

		return silla;
	}

	/**
	 * Método que permite buscar una silla en la clase ejecutiva que contenga el número especificado.
	 * @param numero Representa el número de la silla a buscar.
	 * @return Retorna la silla encontrada.
	 */
	public Silla buscarSillaEje(String numero) {
		Silla silla = null;
		boolean centinela = false;
		Silla[] misSillasEje = avion.getSillasEjecutivas();
		for (int i = 0; i < misSillasEje.length && centinela == false; i++) {
			String numeroActual = misSillasEje[i].getNumero();
			if (numeroActual.equals(numero)) {
				silla = misSillasEje[i];
				centinela = true;
			}
		}

		return silla;
	}

	/**
	 * Asigna la silla al pasajero en la clase.
	 * 
	 * @param pClase    Clase elegida por el pasajero. Clase pertenece
	 *                  {Clase.EJECUTIVA, Clase.ECONOMICA}.
	 * @param pPasajero Pasajero a asignar.
	 * @return Silla asignada al pasajero o null si no se pudo asignar una silla al
	 *         pasajero en la clase especificada.
	 */

	public Pasajero buscarPasajeroSinSilla() {
		Pasajero pasajero = null;
		Silla[] misSillasEco = avion.getSillasEconomicas();
		Silla[] misSillasEje = avion.getSillasEjecutivas();
		boolean centinela = false;
		for (int i = 0; i < misSillasEco.length && centinela == false; i++) {
			Silla miSilla = misSillasEco[i];
			for (int j = 0; j < misPasajeros.size() && centinela == false; j++) {
				if (miSilla.sillaAsignadaPasajero(misPasajeros.get(j)) == false) {
					pasajero = misPasajeros.get(j);
				}
			}
		}

		for (int i = 0; i < misSillasEje.length && centinela == false; i++) {
			Silla miSilla = misSillasEje[i];
			for (int j = 0; j < misPasajeros.size() && centinela == false; j++) {
				if (miSilla.sillaAsignadaPasajero(misPasajeros.get(j)) == false) {
					pasajero = misPasajeros.get(j);
				}
			}
		}

		return pasajero;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		for (int i = 0; i < BotonesSillasEje.length; i++) {
			if (arg0.getSource() == BotonesSillasEje[i]) {
				if (contador < pasajerosTotal) {
					Silla miSilla = buscarSillaEje(BotonesSillasEje[i].getName());
					if (miSilla.sillaAsignada() == true) {
						JOptionPane.showMessageDialog(null, "La silla seleccionada ya está asignada a otro pasajero."
								+ "\n" + "Por favor reintente con otra", "Error", JOptionPane.WARNING_MESSAGE);
					} else {

						Pasajero pPasajero = buscarPasajeroSinSilla();
						RegistroVueloPorPasajero registro = new RegistroVueloPorPasajero(vueloSeleccionado, pPasajero,
								miSilla);
						miVentanaPrincipal.añadirRegistroPorPasajero(registro);
						avion.asignarSilla(miSilla, pPasajero);
						sillasSeleccionadas.add(miSilla);
						BotonesSillasEje[i].setIcon(
								new ImageIcon(VentanaSillas.class.getResource("/imagenes/silla-ejec-asig.png")));
						
						contador++;
					}
				} else {
					Silla miSilla = buscarSillaEje(BotonesSillasEje[i].getName());
					if (miSilla.sillaAsignada() == true) {
						JOptionPane.showMessageDialog(null, "La silla seleccionada ya está asignada a otro pasajero."
								+ "\n" + "Por favor reintente con otra", "Error", JOptionPane.WARNING_MESSAGE);
					} else {
						Pasajero pPasajero = buscarPasajeroSinSilla();
						RegistroVueloPorPasajero registro = new RegistroVueloPorPasajero(vueloSeleccionado, pPasajero,
								miSilla);
						miVentanaPrincipal.añadirRegistroPorPasajero(registro);
						avion.asignarSilla(miSilla, pPasajero);
						sillasSeleccionadas.add(miSilla);
						BotonesSillasEje[i].setIcon(
								new ImageIcon(VentanaSillas.class.getResource("/imagenes/silla-ejec-asig.png")));
						VentanaPago miVP = new VentanaPago(pasajeros, vueloSeleccionado, sillasSeleccionadas, miCliente,
								miVentanaPrincipal, modalidad, fechaaRegreso);
						miVP.setVisible(true);
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(p);
						frame.dispose();

					}
				}

			}
		}

		for (int j = 0; j < botonesSillasEco.length; j++) {
			if (arg0.getSource() == botonesSillasEco[j]) {
				if (contador < pasajerosTotal) {
					Silla miSilla = buscarSillaEco(botonesSillasEco[j].getName());
					if (miSilla.sillaAsignada() == true) {
						JOptionPane.showMessageDialog(null, "La silla seleccionada ya está asignada a otro pasajero."
								+ "\n" + "Por favor reintente con otra", "Error", JOptionPane.WARNING_MESSAGE);

					} else {
						Pasajero pPasajero = buscarPasajeroSinSilla();
						sillasSeleccionadas.add(miSilla);
						RegistroVueloPorPasajero registro = new RegistroVueloPorPasajero(vueloSeleccionado, pPasajero,
								miSilla);
						miVentanaPrincipal.añadirRegistroPorPasajero(registro);
						avion.asignarSilla(miSilla, pPasajero);
						botonesSillasEco[j].setIcon(
								new ImageIcon(VentanaSillas.class.getResource("/imagenes/silla-econ-asig.png")));
						contador++;

					}
				} else {
					Silla miSilla = buscarSillaEco(botonesSillasEco[j].getName());
					if (miSilla.sillaAsignada() == true) {
						JOptionPane.showMessageDialog(null, "La silla seleccionada ya está asignada a otro pasajero."
								+ "\n" + "Por favor reintente con otra", "Error", JOptionPane.WARNING_MESSAGE);
					} else {
						Pasajero pPasajero = buscarPasajeroSinSilla();
						RegistroVueloPorPasajero registro = new RegistroVueloPorPasajero(vueloSeleccionado, pPasajero,
								miSilla);
						miVentanaPrincipal.añadirRegistroPorPasajero(registro);
						sillasSeleccionadas.add(miSilla);
						avion.asignarSilla(miSilla, pPasajero);
						botonesSillasEco[j].setIcon(
								new ImageIcon(VentanaSillas.class.getResource("/imagenes/silla-econ-asig.png")));
						VentanaPago miVP = new VentanaPago(pasajeros, vueloSeleccionado, sillasSeleccionadas, miCliente,
								miVentanaPrincipal, modalidad, fechaaRegreso);
						miVP.setVisible(true);
						JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(p);
						frame.dispose();

					}
				}

			}

		}

	}
}
