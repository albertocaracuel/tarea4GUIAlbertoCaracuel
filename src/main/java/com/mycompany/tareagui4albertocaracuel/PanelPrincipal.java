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

   //creo un array en el q guardo los valores introducidos por calculadora
    private ArrayList<String> lista = new ArrayList<>();
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
        //introduzco todos los valores de los botones a los q se ha dado en el array
        lista.add(((JButton) o).getText());

        //si el ultimo valor es un igual
        if (lista.get(lista.size() - 1) == "=") {
            //llamada al metodo limpiar array
            limpiarArray();
            //4 if en los q si la lista contiene algun operando me ejecuta su metodo especifico
            if (lista.contains("-")) {
                calculoResta();
            }

            if (lista.contains("x")) {
                calculoMultiplicacion();
            }

            if (lista.contains("d")) {
                calculoDivision();
            }
            
            if (lista.contains("s")) {
                calculoSuma();
            }

        }
        //borrarMemoria
        borrarMemoria();

    }
    //metodo en el q mediante dos switch limpio el valor cero y el valor fina si alguno
    //de ellos son operadores y no numeros
    //este metodo me sirve para al hacer operaciones no me errores
    private void limpiarArray() {
        
        switch (lista.get(lista.size() - 1)) {

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

        switch (lista.get(0)) {

            case "+":
                lista.remove(0);
                break;
            case "=":
                lista.remove(0);
                break;
            case "C":
                lista.remove(0);
                break;
            case "-":
                lista.remove(0);
                break;
            case "/":
                lista.remove(0);
                break;
            case "*":
                lista.remove(0);
                break;

        }

        for (int x = 0; x < lista.size(); x++) {
            System.out.println(lista.get(x));
        }
    }
    //metodo en el q al darle a la tecla C borro todo lo que hay en la lista
    //y me muestra un cero
    private void borrarMemoria() {
        if (lista.get(lista.size() - 1) == "C") {

            lista.clear();
            areaTexto.setText("0");
        }
    }
    //Los metodos de calculo estan condicionados a que solo puede haber dos operandos
    //que es lo que pedia la tarea
    private void calculoResta() {
        //creo un string
        String cadena = "";
        //recorro la lista y junto todos sus valores en un String
        for (int i = 0; i < this.lista.size(); i++) {
            cadena += this.lista.get(i);

        }
        //divido el String en dos bloques segun encuentre el operando
        String[] parts = cadena.split("-");
        //convierto la primera parte en un int
        int resultado;
        resultado = Integer.valueOf(parts[0]);
        //convierto la segunda parte en un int
        int resultado1;
        resultado1 = Integer.valueOf(parts[1]);
        //creo el int final q hara la operacion q le corresponda a esos dos
        int finals;
        finals = resultado - resultado1;
        //paso el int a String para poder ponerlo en la pantalla
        String numCadena = String.valueOf(finals);
        //muestro los resultados
        System.out.println(finals);
        areaTexto.setText(numCadena);
    }

    private void calculoMultiplicacion() {
       //creo un string
        String cadena = "";
        //recorro la lista y junto todos sus valores en un String
        for (int i = 0; i < this.lista.size(); i++) {
            cadena += this.lista.get(i);

        }
        //divido el String en dos bloques segun encuentre el operando
        String[] parts = cadena.split("x");
        //convierto la primera parte en un int
        int resultado;
        resultado = Integer.valueOf(parts[0]);
        //convierto la segunda parte en un int
        int resultado1;
        resultado1 = Integer.valueOf(parts[1]);
        //creo el int final q hara la operacion q le corresponda a esos dos
        int finals;
        finals = resultado * resultado1;
        //paso el int a String para poder ponerlo en la pantalla
        String numCadena = String.valueOf(finals);
        //muestro los resultados
        System.out.println(finals);
        areaTexto.setText(numCadena);
    }

    private void calculoDivision() {
      //creo un string
        String cadena = "";
        //recorro la lista y junto todos sus valores en un String
        for (int i = 0; i < this.lista.size(); i++) {
            cadena += this.lista.get(i);

        }
        //divido el String en dos bloques segun encuentre el operando
        String[] parts = cadena.split("d");
        //convierto la primera parte en un int
        int resultado;
        resultado = Integer.valueOf(parts[0]);
        //convierto la segunda parte en un int
        int resultado1;
        resultado1 = Integer.valueOf(parts[1]);
        //creo el int final q hara la operacion q le corresponda a esos dos
        int finals;
        finals = resultado / resultado1;
        //paso el int a String para poder ponerlo en la pantalla
        String numCadena = String.valueOf(finals);
        //muestro los resultados
        System.out.println(finals);
        areaTexto.setText(numCadena);
    }
    
    private void calculoSuma(){
    //creo un string
        String cadena = "";
        //recorro la lista y junto todos sus valores en un String
        for (int i = 0; i < this.lista.size(); i++) {
            cadena += this.lista.get(i);

        }
        //divido el String en dos bloques segun encuentre el operando
        String[] parts = cadena.split("s");
        //convierto la primera parte en un int
        int resultado;
        resultado = Integer.valueOf(parts[0]);
        //convierto la segunda parte en un int
        int resultado1;
        resultado1 = Integer.valueOf(parts[1]);
        //creo el int final q hara la operacion q le corresponda a esos dos
        int finals;
        finals = resultado + resultado1;
        //paso el int a String para poder ponerlo en la pantalla
        String numCadena = String.valueOf(finals);
        //muestro los resultados
        System.out.println(finals);
        areaTexto.setText(numCadena);
    }
}
