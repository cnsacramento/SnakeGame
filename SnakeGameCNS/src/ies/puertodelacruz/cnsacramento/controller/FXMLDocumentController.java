/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.controller;

import ies.puertodelacruz.cnsacramento.model.Partida;
import java.awt.GraphicsConfiguration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author christian
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas escenarioCanvas;
    private GraphicsContext graficos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Partida partida = new Partida();
        double ancho = escenarioCanvas.getWidth();
        double alto = escenarioCanvas.getHeight();
        partida.empezarPartida(ancho, alto);
        graficos = escenarioCanvas.getGraphicsContext2D();
        mostrarGraficos();
    }

    
    public void mostrarGraficos() {
        
        graficos.fillRect(0, 0, 10, 10);
    }
    
}
