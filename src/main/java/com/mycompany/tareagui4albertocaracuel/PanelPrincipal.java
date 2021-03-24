/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tareagui4albertocaracuel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author alberto
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;
    private int tipoOperacion;

    // Constructor
    public PanelPrincipal() {
        initComponents();
        tipoOperacion = -1; // No hay operaciones en la calculadora
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.white);

        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón
        if (o instanceof JButton) {
            System.out.println(((JButton) o).getText());
            areaTexto.setText(((JButton) o).getText());
        }

        ArrayList<String> lista = new ArrayList<>();

        if (o instanceof JButton) {
            lista.add(((JButton) o).getText());
        }

        String cadena="";

        switch ( lista.get(lista.size() - 1)) {

            case "+":
                lista.remove(lista.size() - 1);
                break;
            case "=":
                lista.remove(lista.size() - 1);
                break;
            case "C":
                lista.remove(lista.size() - 1);
                break;
            case "-":
                lista.remove(lista.size() - 1);
                break;
            case "/":
                lista.remove(lista.size() - 1);
                break;
            case "*":
                lista.remove(lista.size() - 1);
                break;

        }
        
        switch ( lista.get(0)) {

            case "+":
                lista.remove(lista.size() - 1);
                break;
            case "=":
                lista.remove(lista.size() - 1);
                break;
            case "C":
                lista.remove(lista.size() - 1);
                break;
            case "-":
                lista.remove(lista.size() - 1);
                break;
            case "/":
                lista.remove(lista.size() - 1);
                break;
            case "*":
                lista.remove(lista.size() - 1);
                break;

        }
        //recorro la lista y hago un String
        for (int i = 0; i < lista.size(); i++) {
            cadena += lista.get(i);

        }

        int resultado = Integer.parseInt(cadena);
        String numCadena = String.valueOf(resultado);
        
        PanelBotones nuevo = new PanelBotones();

        //boton igual
        if (o == nuevo.grupoBotones[14]) {

            System.out.println(resultado);
            areaTexto.setText(numCadena);
        }
        //boton borrar
        if (o == nuevo.grupoBotones[15]) {

            lista.clear();
        }

    }
}
