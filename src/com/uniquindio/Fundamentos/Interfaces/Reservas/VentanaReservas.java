package com.uniquindio.Fundamentos.Interfaces.Reservas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.uniquindio.Fundamentos.Interfaces.VentanaFuncionesCliente;
import com.uniquindio.Fundamentos.Interfaces.VentanaPrincipal;
import com.uniquindio.Fundamentos.Interfaces.Paneles.PanelReservas;
import com.uniquindio.Fundamentos.Mundo.Cliente;
import com.uniquindio.Fundamentos.Mundo.Reserva;

@SuppressWarnings("serial")
public class VentanaReservas extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel baner;
	private JPanel panelInferior;
	private JScrollPane scrollPane;
	private JPanel panel;
	private VentanaPrincipal miV;
	private Cliente miCliente;
	private JButton btnVolver;

	
	public VentanaReservas(Cliente miCliente, VentanaPrincipal miV) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReservas.class.getResource("/imagenes/plane.png")));
		
		this.miV = miV;
		this.miCliente = miCliente;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 432);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		constBaner();
		constMedio();
		constInferior();
		setResizable(false);
		setLocationRelativeTo(null);
		
	}
	
	public void constBaner()
	{
		baner = new JPanel();
		baner.setBackground(Color.WHITE);
		contentPane.add(baner);
		baner.setLayout(new BoxLayout(baner, BoxLayout.X_AXIS));
		{
			JLabel labelBaner = new JLabel("");
			labelBaner.setIcon(new ImageIcon(VentanaReservas.class.getResource("/imagenes/banerReservas.png")));
			baner.add(labelBaner);
		}
	}
	
	public void constMedio()
	{
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		{
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new EmptyBorder(10, 0, 0, 0));
			scrollPane.setViewportView(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			ArrayList<Reserva> reservas = miCliente.getReservas();
			JLabel labelInfor = new JLabel("                                                        No hay reservas en lista");
			labelInfor.setFont(new Font("Tahoma", Font.BOLD, 15));
			if(reservas.isEmpty()==true)
			{
				panel.add(labelInfor);
			}
			for(int i = 0; i<reservas.size();i++)
			{
				panel.add(new PanelReservas(miV, reservas.get(i), miCliente));
				
			}
		}
		
		
		
}
	
	public void constInferior()
	{
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.WHITE);
		panelInferior.setBorder(new EmptyBorder(16, 0, 0, 0));
		contentPane.add(panelInferior);
		{
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(this);
			panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
			btnVolver.setBackground(Color.YELLOW);
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
			panelInferior.add(btnVolver);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVolver)
		{
			VentanaFuncionesCliente miVFC = new VentanaFuncionesCliente(miV, miCliente);
			miVFC.setVisible(true);
			this.dispose();
		}
		
	}

}
