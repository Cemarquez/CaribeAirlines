package com.uniquindio.Fundamentos.Interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
@SuppressWarnings("serial")
public class VentanaGestionarCuenta extends JFrame implements ActionListener {
    private Cliente clienteLogeado;
	private JPanel contentPane, datos, panel, panel_1, panel_2, panel_7;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDocumento;
	private JLabel lblNombreDeUsuario;
	private JLabel lblEmail;
	private JLabel lblCelular;
	private JLabel lblContra;
	private JLabel lblConfirmeContra;
	private JButton btnListo;
	private JTextField nN;
	private JPanel panel_8;
	private JTextField aA;
	private JPanel panel_9;
	private JTextField cC;
	private JPanel panel_10;
	private JTextField direc;
	private JPanel panel_11;
	private JPanel panel_12;
	private JTextField email;
	private JPanel panel_13;
	private JPasswordField pass;
	private JPanel panel_14;
	private JPasswordField cofPass;
	private JLabel lblNewLabel;

	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnVolver;
	private JPanel panel_5;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaFuncionesCliente miVentanaFuncionesCliente;
	private JDateChooser dateChooser;
	

	
	/**
	 * Create the frame.
	 */
	public VentanaGestionarCuenta(VentanaPrincipal miVentanaPrincipal, Cliente miCliente, VentanaFuncionesCliente miVentanaFuncionesCliente) 
	{
		this.miVentanaFuncionesCliente = miVentanaFuncionesCliente;
		this.miVentanaPrincipal = miVentanaPrincipal;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		clienteLogeado = miCliente;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		constBaner();
		constPanelMedio();
		constPanelInferior();
		
		getContentPane().add(datos);
		getContentPane().add(panel);
		setLocationRelativeTo(null);
	}
	
	public void constBaner()
	{
		lblNewLabel = new JLabel("");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setIcon(new ImageIcon(VentanaRegistrar.class.getResource("/imagenes/registratbaner.jpg")));
		contentPane.add(lblNewLabel);
	}
	
	public void constPanelMedio()
	{
		
		datos = new JPanel();
		datos.setLayout(new GridLayout(1, 0, 0, 0));
		panel_1 = new JPanel();
		datos.add(panel_1);
		panel_1.setLayout(new GridLayout(8, 1, 0, 0));
		{
			lblNombres = new JLabel("   Nombres");
			lblNombres.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
			lblNombres.setVerticalAlignment(SwingConstants.BOTTOM);
			panel_1.add(lblNombres);
		}
		{
			panel_7 = new JPanel();
			panel_7.setBorder(new EmptyBorder(0, 0, 0, 10));
			panel_1.add(panel_7);
			{
				nN = new JTextField(clienteLogeado.getNombre());
				panel_7.add(nN);
				nN.setColumns(17);
			}
		}
		{
			lblApellidos = new JLabel("   Apellidos");
			lblApellidos.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
			lblApellidos.setVerticalAlignment(SwingConstants.BOTTOM);
			panel_1.add(lblApellidos);
		}
		{
			panel_8 = new JPanel();
			panel_1.add(panel_8);
			{
				aA = new JTextField(clienteLogeado.getApellido());
				panel_8.add(aA);
				aA.setColumns(17);
			}
		}
		{
			lblDocumento = new JLabel("   Documento de Identidad");
			lblDocumento.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
			lblDocumento.setVerticalAlignment(SwingConstants.BOTTOM);
			panel_1.add(lblDocumento);
		}
		{
			panel_9 = new JPanel();
			panel_1.add(panel_9);
			{
				cC = new JTextField(clienteLogeado.getCedula());
				panel_9.add(cC);
				cC.setColumns(17);
			}
		}
		{
			lblCelular = new JLabel("   Direcci\u00F3n");
			lblCelular.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
			lblCelular.setVerticalAlignment(SwingConstants.BOTTOM);
			panel_1.add(lblCelular);
		}
		{
			panel_10 = new JPanel();
			panel_1.add(panel_10);
			{
				direc = new JTextField(clienteLogeado.getDireccion());
				panel_10.add(direc);
				direc.setColumns(17);
			}
		}
		panel_2 = new JPanel();
		datos.add(panel_2);
		panel_2.setLayout(new GridLayout(8, 1, 0, 0));
		{
			lblNombreDeUsuario = new JLabel("   Fecha de Nacimiento");
			lblNombreDeUsuario.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
			lblNombreDeUsuario.setVerticalAlignment(SwingConstants.BOTTOM);
			panel_2.add(lblNombreDeUsuario);
		}
		{
			panel_11 = new JPanel();
			panel_2.add(panel_11);
			{
				dateChooser = new JDateChooser();
				Calendar c3 = new GregorianCalendar();
			     dateChooser.setCalendar(c3);
				panel_11.add(dateChooser);
			}
		}
		{
			lblEmail = new JLabel("   Correo Electronico");
			lblEmail.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
			lblEmail.setVerticalAlignment(SwingConstants.BOTTOM);
			panel_2.add(lblEmail);
		}
		{
			panel_12 = new JPanel();
			panel_2.add(panel_12);
			{
				email = new JTextField(clienteLogeado.getCorreo());
				panel_12.add(email);
				email.setColumns(17);
			}
		}
		{
			lblContra = new JLabel("   Contrase\u00F1a");
			lblContra.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
			lblContra.setVerticalAlignment(SwingConstants.BOTTOM);
			panel_2.add(lblContra);
		}
		{
			panel_13 = new JPanel();
			panel_2.add(panel_13);
			{
				
				pass = new JPasswordField(clienteLogeado.getContraseña());
				pass.setColumns(17);
				panel_13.add(pass);
			}
		}
		{
			lblConfirmeContra = new JLabel("   Confirme Contrase\u00F1a");
			lblConfirmeContra.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
			lblConfirmeContra.setVerticalAlignment(SwingConstants.BOTTOM);
			panel_2.add(lblConfirmeContra);
		}
		{
			panel_14 = new JPanel();
			panel_2.add(panel_14);
			{
				cofPass = new JPasswordField(clienteLogeado.getContraseña());
				cofPass.setColumns(17);
				panel_14.add(cofPass);
			}
		}
	}
	public void constPanelInferior()
	{
		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		{
			panel_5 = new JPanel();
			panel.add(panel_5);
		}
		panel_3 = new JPanel();
		panel.add(panel_3);
		btnListo = new JButton("¡Guardar!");
		panel_3.add(btnListo);
		btnListo.setForeground(new Color(128, 0, 0));
		btnListo.setFont(new Font("Bookman Old Style", Font.BOLD, 14));
		btnListo.setBackground(new Color(255, 255, 255));
		btnListo.addActionListener(this);
		panel_4 = new JPanel();
		panel.add(panel_4);
		{
			btnVolver = new JButton("Volver");
			btnVolver.setFont(new Font("Bookman Old Style", Font.BOLD, 11));
			btnVolver.addActionListener(this);
			panel_4.add(btnVolver);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String nombre = nN.getText();
		String apellido = aA.getText();
		String correo = email.getText();
		String direccion = direc.getText();
		String contraseña = pass.getText();
		String confirmarContra = cofPass.getText();
		String cedula = cC.getText();
		int dia = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
		int mes = dateChooser.getCalendar().get(Calendar.MONTH);
		int año = dateChooser.getCalendar().get(Calendar.YEAR);
		String fechaNacimiento = dia+"/"+mes+"/"+año;

		if (e.getSource() == btnListo) {
			if (nombre.equals("") || apellido.equals("") || correo.equals("") || direccion.equals("")
					|| contraseña.equals("") || cedula.equals("") || fechaNacimiento.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Faltan campos por ser llenados. Por favor revise y continue de nuevo.", "Error",
						JOptionPane.WARNING_MESSAGE);
			} else {
				// Patrón para validar el email
				Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

				Matcher mather = pattern.matcher(correo);

				if (mather.find() == false) {
					JOptionPane.showMessageDialog(null, "El correo ingresado es invalido.", "Error",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if(miVentanaPrincipal.correoRegistrado(correo) == true)
					{
						JOptionPane.showMessageDialog(null, "Este correo ya está registrado, por favor reintente con otro.", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
					else {
					if (!(contraseña.equals(confirmarContra))) {
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Error",
								JOptionPane.WARNING_MESSAGE);
					} else {
						clienteLogeado.actualizarDatos(nombre, apellido, correo, direccion, contraseña, cedula, fechaNacimiento);
						miVentanaPrincipal.serializar();
						miVentanaFuncionesCliente.setVisible(true);
						this.dispose();
					}
					}
				}
			}
		}
			
		
		if(e.getSource()==btnVolver)
		{
			
			miVentanaPrincipal.setVisible(true);
			this.dispose();
		}
	}

}
