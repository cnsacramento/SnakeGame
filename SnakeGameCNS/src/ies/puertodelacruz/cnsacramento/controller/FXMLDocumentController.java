/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.controller;

import ies.puertodelacruz.cnsacramento.model.Partida;
import ies.puertodelacruz.cnsacramento.model.Serpiente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author christian
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas escenarioCanvas;
    private GraphicsContext graficos;
    private Partida partida;
    private double dimensionSerpiente = 10;
    private Serpiente serpiente;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partida = new Partida();
        double ancho = escenarioCanvas.getWidth();
        double alto = escenarioCanvas.getHeight();
        partida.empezarPartida(ancho, alto);
        serpiente = partida.getEscenario().getSerpiente();
        System.out.println("Escenario tamaño X -> " + partida.getEscenario().getTamanioX());
        System.out.println("Escenario tamaño Y -> " + partida.getEscenario().getTamanioY());
        graficos = escenarioCanvas.getGraphicsContext2D();
        mostrarGraficos();
    }

    
    public void mostrarGraficos() {
        
        double posicionXserpiente = partida.getEscenario().getSerpiente().getPosicionX();
        double posicionYserpiente = partida.getEscenario().getSerpiente().getPosicionY();
        graficos.fillRect(posicionXserpiente, posicionYserpiente, dimensionSerpiente, dimensionSerpiente);
    }

    @FXML
    private void moverSerpiente(KeyEvent event) {
        
        KeyCode tecla = event.getCode();
        System.out.println(tecla);
        double posicionXserpiente = partida.getEscenario().getSerpiente().getPosicionX();
        double posicionYserpiente = partida.getEscenario().getSerpiente().getPosicionY();
        System.out.println("Posicion serpiente -> (" + posicionXserpiente + ", " + posicionYserpiente + ")");
        switch(tecla) {
            case UP:
                System.out.println("Subiendo...");
                serpiente.mover("UP", dimensionSerpiente);
                break;
            case DOWN:
                System.out.println("Bajando...");
                serpiente.mover("DOWN", dimensionSerpiente);
                break;
            case LEFT:
                System.out.println("Izquierda...");
                serpiente.mover("LEFT", dimensionSerpiente);
                break;
            case RIGHT:
                System.out.println("Derecha...");
                serpiente.mover("RIGHT", dimensionSerpiente);
                break;
            default:
                break;
        }
    }
    
}
