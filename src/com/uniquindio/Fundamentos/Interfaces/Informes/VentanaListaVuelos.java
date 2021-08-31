package com.uniquindio.Fundamentos.Interfaces.Informes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.uniquindio.Fundamentos.Mundo.Pasajero;
import com.uniquindio.Fundamentos.Mundo.Vuelo;

@SuppressWarnings("serial")
public class VentanaListaVuelos extends JFrame {

	private JPanel contentPane;
	private JButton btnVolver;

	
	public VentanaListaVuelos(ArrayList<Vuelo> vuelos, VentanaReportesVuelo miV, Pasajero pasajero) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaListaVuelos.class.getResource("/imagenes/registratbaner.jpg")));
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel(pasajero.getNombre() + " " + pasajero.getApellido() );
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JPanel panelLista = new JPanel();
		panelLista.setBackground(Color.WHITE);
		scrollPane.setViewportView(panelLista);
		panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
		DefaultListModel<String> modelo = new DefaultListModel<>();
		String origen = null, destino = null, fecha;
		for(int i=0;i<vuelos.size();i++)
		{
			origen = vuelos.get(i).getTrayecto().getOrigen();
			destino = vuelos.get(i).getTrayecto().getDestino();
			fecha = vuelos.get(i).getFecha();
			modelo.addElement(origen + " - " + destino + "     " + fecha +  "     Realizado");
		}
		JList<String> list = new JList<String>(modelo);
		
		
		panelLista.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new EmptyBorder(16, 0, 0, 0));
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miV.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBackground(new Color(255, 204, 0));
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		panel_1.add(btnVolver);
	}

}
