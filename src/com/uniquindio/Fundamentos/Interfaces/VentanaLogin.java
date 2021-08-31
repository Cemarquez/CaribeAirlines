package com.uniquindio.Fundamentos.Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.uniquindio.Fundamentos.Interfaces.Reservas.VentanaReservas;
import com.uniquindio.Fundamentos.Mundo.Admin;
import com.uniquindio.Fundamentos.Mundo.Aerolinea;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
@SuppressWarnings("serial")
public class VentanaLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldCorreo;
	private JPasswordField passwordFieldContraseña;
	private JLabel lblFotocontrasea;
	private JLabel lblFotocorreo;
	private VentanaLogin miVentanaLogin = this;
	private Aerolinea aerolinea;
	private JButton Botoncontinuar;
	private ArrayList<Cliente> misClientes;
    private Cliente clienteLogeado;
    private VentanaPrincipal miVentanaPrincipal;
    
	public VentanaLogin(VentanaPrincipal miVentanaPrincipal, Aerolinea aerolinea) {
		this.miVentanaPrincipal = miVentanaPrincipal;
		this.aerolinea = aerolinea;
		misClientes = aerolinea.getMisClientes();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 461);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 
        //Eventos
 
		contentPane.setFocusable(true);
		construirPanelSuperior();
		construirPanelMedio();
		construirPanelInferior();
	
		
		setLocationRelativeTo(null);
	}
	
	public void construirPanelSuperior()
	{
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		JPanel panelTodo = new JPanel();
		panelTodo.setBackground(Color.WHITE);
		panelTodo.setBorder(new EmptyBorder(0, 0, 45, 0));
		
		contentPane.add(panelTodo);
		panelTodo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLabelfoto = new JLabel("");
		lblLabelfoto.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/icono-usuariogrande.png")));
		panelTodo.add(lblLabelfoto);
	}
	
	public void construirPanelMedio()
	{
		JPanel panelMedio = new JPanel();
		panelMedio.setBackground(Color.WHITE);
		
		
		contentPane.add(panelMedio);
		GridBagLayout gbl_panelMedio = new GridBagLayout();
		gbl_panelMedio.columnWidths = new int[]{51, 133, 10, 0};
		gbl_panelMedio.rowHeights = new int[]{61, 0, 0, 0, 0};
		gbl_panelMedio.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelMedio.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMedio.setLayout(gbl_panelMedio);
		{
			JPanel panelCorreo = new JPanel();
			panelCorreo.setBackground(Color.WHITE);
			GridBagConstraints gbc_panelCorreo = new GridBagConstraints();
			gbc_panelCorreo.anchor = GridBagConstraints.NORTH;
			gbc_panelCorreo.insets = new Insets(0, 0, 5, 5);
			gbc_panelCorreo.gridx = 1;
			gbc_panelCorreo.gridy = 0;
			panelMedio.add(panelCorreo, gbc_panelCorreo);
			panelCorreo.setLayout(new BoxLayout(panelCorreo, BoxLayout.Y_AXIS));
			{
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panelCorreo.add(panel);
				panel.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblCorreo = new JLabel("CORREO:");
					lblCorreo.setForeground(new Color(255, 127, 80));
					lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
					panel.add(lblCorreo, BorderLayout.WEST);
					lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
				}
			}
			{
				JPanel panelFotoCorreo = new JPanel();
				panelFotoCorreo.setBorder(new EmptyBorder(0, 0, 10, 0));
				panelFotoCorreo.setBackground(Color.WHITE);
				panelCorreo.add(panelFotoCorreo);
				{
					lblFotocorreo = new JLabel("");
					lblFotocorreo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/icono-usuario.png")));
				}
				{
					textFieldCorreo = new JTextField();
				
					textFieldCorreo.setColumns(10);
				}
				GroupLayout gl_panelFotoCorreo = new GroupLayout(panelFotoCorreo);
				gl_panelFotoCorreo.setHorizontalGroup(
					gl_panelFotoCorreo.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelFotoCorreo.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblFotocorreo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCorreo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
				gl_panelFotoCorreo.setVerticalGroup(
					gl_panelFotoCorreo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelFotoCorreo.createSequentialGroup()
							.addGroup(gl_panelFotoCorreo.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFotocorreo)
								.addGroup(gl_panelFotoCorreo.createSequentialGroup()
									.addGap(11)
									.addComponent(textFieldCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				panelFotoCorreo.setLayout(gl_panelFotoCorreo);
			}
		}
		{
			JPanel panelContraseña = new JPanel();
			panelContraseña.setBackground(Color.WHITE);
			GridBagConstraints gbc_panelContraseña = new GridBagConstraints();
			gbc_panelContraseña.insets = new Insets(0, 0, 5, 5);
			gbc_panelContraseña.gridx = 1;
			gbc_panelContraseña.gridy = 1;
			panelMedio.add(panelContraseña, gbc_panelContraseña);
			panelContraseña.setLayout(new BoxLayout(panelContraseña, BoxLayout.Y_AXIS));
			{
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panelContraseña.add(panel);
				panel.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:");
					lblContrasea.setForeground(new Color(255, 127, 80));
					lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
					panel.add(lblContrasea, BorderLayout.WEST);
				}
			}
			{
				JPanel panelFotoContraseña = new JPanel();
				panelFotoContraseña.setBackground(Color.WHITE);
				panelContraseña.add(panelFotoContraseña);
				{
					lblFotocontrasea = new JLabel("");
					lblFotocontrasea.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/icono-llave.png")));
				}
				{
					passwordFieldContraseña = new JPasswordField();
					passwordFieldContraseña.setEchoChar('*');
					passwordFieldContraseña.addKeyListener(new KeyListener() {
						
						@Override
						public void keyTyped(KeyEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void keyReleased(KeyEvent e) {
							
						}
						
						@Override
						public void keyPressed(KeyEvent e) {
							
							if(e.getKeyCode() == KeyEvent.VK_ENTER)
							{
								iniciarSesion();
							}
						}
					});
				}
				GroupLayout gl_panelFotoContraseña = new GroupLayout(panelFotoContraseña);
				gl_panelFotoContraseña.setHorizontalGroup(
					gl_panelFotoContraseña.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelFotoContraseña.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFotocontrasea)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordFieldContraseña, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
				gl_panelFotoContraseña.setVerticalGroup(
					gl_panelFotoContraseña.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelFotoContraseña.createSequentialGroup()
							.addGroup(gl_panelFotoContraseña.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelFotoContraseña.createSequentialGroup()
									.addGap(11)
									.addComponent(passwordFieldContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblFotocontrasea))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				panelFotoContraseña.setLayout(gl_panelFotoContraseña);
			}
		}
		JPanel panelInferior = new JPanel();
		GridBagConstraints gbc_panelInferior = new GridBagConstraints();
		gbc_panelInferior.insets = new Insets(0, 0, 0, 5);
		gbc_panelInferior.gridx = 1;
		gbc_panelInferior.gridy = 3;
		panelMedio.add(panelInferior, gbc_panelInferior);
		panelInferior.setBackground(Color.WHITE);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
		{
			Botoncontinuar = new JButton("");
			Botoncontinuar.setBorder(null);
			Botoncontinuar.setAlignmentX(0.5f);
			Botoncontinuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Botoncontinuar.setFocusPainted(false);
			Botoncontinuar.setContentAreaFilled(false);
			Botoncontinuar.addActionListener(this);
			Botoncontinuar.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/Boton-ingresar.png")));
			panelInferior.add(Botoncontinuar);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panelInferior.add(panel);
			{
				JLabel labelRegistro = new JLabel("\u00BFA\u00FAn no eres miembro? \u00A1registrate!");
				labelRegistro.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						VentanaRegistrar miVR = new VentanaRegistrar(miVentanaPrincipal);
						miVR.setVisible(true);
						miVentanaLogin.dispose();
					}
				});
				labelRegistro.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 11));
				labelRegistro.setBounds(54, 375, 165, 14);
				panel.add(labelRegistro);
			}
		}
		
		
	}
	
	public void construirPanelInferior()
	{
	}
	
	public void iniciarSesion()
	{
		String correo = textFieldCorreo.getText();
		String contraseña = passwordFieldContraseña.getText();
		Admin administrador = aerolinea.getAdministrador();
		if(correo.equals(administrador.getUsuario()))
        {
     	   if(contraseña.equals(administrador.getContraseña()))
     	   {
     		   VentanaFuncionesAdmin miVentanaFuncionesAdmin = new VentanaFuncionesAdmin(miVentanaPrincipal);
     		   miVentanaFuncionesAdmin.setVisible(true);
     		   this.dispose();
     		   
     	   }
     	   else
     	   {
     		   JOptionPane.showMessageDialog(null, "La contraseña o email son incorrectos. ", "Error", JOptionPane.WARNING_MESSAGE);
     	   }
        }
        else
        {
     	   if (misClientes.isEmpty()) {
       			JOptionPane.showMessageDialog(null, "No hay ningún usuario registrado, por favor registre uno", "Error", JOptionPane.WARNING_MESSAGE);
       		}
     	   if(verificarDatos(correo, contraseña) == true)
     	   {
     		   clienteLogeado = obtenerClienteLogeado(correo, contraseña);
     		   VentanaFuncionesCliente miVentanaFuncionesCliente = new VentanaFuncionesCliente(miVentanaPrincipal, clienteLogeado);
     		   miVentanaFuncionesCliente.setVisible(true);
     		   this.dispose();
     		   
     	   }
     	   else
      	   {
      		   JOptionPane.showMessageDialog(null, "La contraseña o email son incorrectos. ", "Error", JOptionPane.WARNING_MESSAGE);
      	   }
     	   
        }
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String correo = textFieldCorreo.getText();
		String contraseña = passwordFieldContraseña.getText();
		Admin administrador = aerolinea.getAdministrador();
		if (arg0.getSource() == Botoncontinuar) {
	           if(correo.equals(administrador.getUsuario()))
	           {
	        	   if(contraseña.equals(administrador.getContraseña()))
	        	   {
	        		   VentanaFuncionesAdmin miVentanaFuncionesAdmin = new VentanaFuncionesAdmin(miVentanaPrincipal);
	        		   miVentanaFuncionesAdmin.setVisible(true);
	        		   this.dispose();
	        		   
	        	   }
	        	   else
	        	   {
	        		   JOptionPane.showMessageDialog(null, "La contraseña o email son incorrectos. ", "Error", JOptionPane.WARNING_MESSAGE);
	        	   }
	           }
	           else
	           {
	        	   if (misClientes.isEmpty()) {
	          			JOptionPane.showMessageDialog(null, "No hay ningún usuario registrado, por favor registre uno", "Error", JOptionPane.WARNING_MESSAGE);
	          		}
	        	   if(verificarDatos(correo, contraseña) == true)
	        	   {
	        		   clienteLogeado = obtenerClienteLogeado(correo, contraseña);
	        		   VentanaFuncionesCliente miVentanaFuncionesCliente = new VentanaFuncionesCliente(miVentanaPrincipal, clienteLogeado);
	        		   miVentanaFuncionesCliente.setVisible(true);
	        		   this.dispose();
	        		   
	        	   }
	        	   else
	         	   {
	         		   JOptionPane.showMessageDialog(null, "La contraseña o email son incorrectos. ", "Error", JOptionPane.WARNING_MESSAGE);
	         	   }
	        	   
	           }
				
			}
	}

	
	
	
	
	public Cliente obtenerClienteLogeado (String correo, String contraseña)
	{
		Cliente cliente = null;
		Cliente miC;
		boolean loEs = false;
		for (int i = 0; i < misClientes.size()&&loEs == false; i++) {
	        miC = misClientes.get(i);
	        if(correo.equals(miC.getCorreo()))
	        {
	        	if(contraseña.equals(miC.getContraseña()))
	        	{
	        		cliente = miC;
	        		loEs = true;
	        	}
	        }
		}
		
		return cliente;
	}
	public boolean verificarDatos(String correo, String contraseña) {
		boolean esIgual = false;
		
		Cliente miC;
			for (int i = 0; i < misClientes.size()&&esIgual==false; i++) {
		        miC = misClientes.get(i);
		        if(correo.equals(miC.getCorreo()))
		        {
		        	if(contraseña.equals(miC.getContraseña()))
		        	{
		        		esIgual = true;
		        	}
		        }
			}
		
		

		return esIgual;
	}

	public Cliente getClienteLogeado() {
		return clienteLogeado;
	}
	
	
	
	
	}


