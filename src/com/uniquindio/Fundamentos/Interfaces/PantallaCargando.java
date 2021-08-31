package com.uniquindio.Fundamentos.Interfaces;

import javax.swing.*;

import com.uniquindio.Fundamentos.Mundo.Aerolinea;
import com.uniquindio.Fundamentos.Serializacion.Persistencia;
import com.uniquindio.Fundamentos.Util.Util;

import java.awt.*;
import java.io.File;
/*DEMO POR INFORUX*/
@SuppressWarnings("serial")
public class PantallaCargando extends JWindow {
    private VentanaPrincipal miV;
	private static Persistencia serializar = new Persistencia();
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel imageLabel = new JLabel();
  JPanel southPanel = new JPanel();
  FlowLayout southPanelFlowLayout = new FlowLayout();
  JProgressBar progressBar = new JProgressBar();
  ImageIcon imageIcon;

  public PantallaCargando(ImageIcon imageIcon) {
    this.imageIcon = imageIcon;
    dibujaVentana();
    
    
  }

  public void dibujaVentana() {
    imageLabel.setIcon(imageIcon);
    this.getContentPane().setLayout(borderLayout1);
    southPanel.setLayout(southPanelFlowLayout);
    southPanel.setBackground(Color.BLACK);
    this.getContentPane().add(imageLabel, BorderLayout.CENTER);
    this.getContentPane().add(southPanel, BorderLayout.SOUTH);
    southPanel.add(progressBar, null);
    progressBar.setStringPainted(true);
    progressBar.setString("Cargando...");
    this.pack();
  }

  public void setProgresoMax(int maxProgress)
  {
    progressBar.setMaximum(maxProgress);}

  public void setProgreso(int progress)
  {
    final int progreso = progress;
        progressBar.setValue(progreso);}

  public void setProgreso(String message, int progress)
  {
    final int progreso = progress;
    final String theMessage = message;
    setProgreso(progress);
    progressBar.setValue(progreso);
    setMessage(theMessage);  }

  private void setMessage(String message)
 {
    if (message==null){
      message = "";
      progressBar.setStringPainted(false);}
    else{
      progressBar.setStringPainted(true);}

    progressBar.setString(message); }

public void velocidadDeCarga(){
	Aerolinea aerolinea;
	File miF=new File(Util.disco() + "CaribeAirlines/Datos/Datos.dat");	
	File miFA = new File(Util.disco() + "CaribeAirlines/Facturas/");
	File miFAA = new File(Util.disco() + "CaribeAirlines/Datos/");
	if (miF.exists()){
		 aerolinea = serializar.deserializar();
		} else {
		 aerolinea = new Aerolinea();
		 miFAA.mkdirs();
		 miFA.mkdirs();
		}
    for (int i = 0; i <= 100; i++)
    {
      for (long j=0; j<100000; ++j)
      {
        String poop = " " + (j + i);
      }
     setProgreso("" + i, i);  
   }
    this.miV = new VentanaPrincipal(aerolinea);
    dispose();
	miV.setVisible(true);
	}


}