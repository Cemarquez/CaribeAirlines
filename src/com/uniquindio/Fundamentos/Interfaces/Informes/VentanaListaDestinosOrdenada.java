package com.uniquindio.Fundamentos.Interfaces.Informes;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaListaDestinosOrdenada extends JFrame {

	private JPanel contentPane;

	public VentanaListaDestinosOrdenada(String destinos[], VentanaReportesVuelo miV) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 414);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(0, 0, 10, 0));
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaListaDestinosOrdenada.class.getResource("/imagenes/registratbaner.jpg")));
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		DefaultListModel<String> modelo = new DefaultListModel<>();
		String destino=null;
		for(int i=0;i<destinos.length;i++)
		{
			destino = destinos[i];
			modelo.addElement(i+1 + ". "+destinos[i]);
		}
		JList<String> list = new JList<String>(modelo);
		panel_1.add(list);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miV.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(255, 204, 0));
		panel_2.add(btnVolver);
	}

}
