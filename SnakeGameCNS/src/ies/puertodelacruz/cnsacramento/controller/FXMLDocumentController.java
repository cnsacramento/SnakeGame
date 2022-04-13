/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.controller;

import ies.puertodelacruz.cnsacramento.model.Escenario;
import ies.puertodelacruz.cnsacramento.model.Partida;
import ies.puertodelacruz.cnsacramento.model.Serpiente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 *
 * @author christian
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas escenarioCanvas;
    private GraphicsContext graficos;
    private Partida partida;
    private final double dimensionSerpiente = 10;
    private Serpiente serpiente;
    private Escenario escenario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partida = new Partida();
        double ancho = escenarioCanvas.getWidth();
        double alto = escenarioCanvas.getHeight();
        partida.empezarPartida(ancho, alto);
        escenario = partida.getEscenario();
        serpiente = escenario.getSerpiente();
        System.out.println("Escenario tamaño -> (" + escenario.getTamanioX() + "," + escenario.getTamanioY() + ")");
        graficos = escenarioCanvas.getGraphicsContext2D();
        graficos.fillRect(serpiente.getPosicionX(), serpiente.getPosicionY(), dimensionSerpiente, dimensionSerpiente);
        mostrarGraficos();
    }

    
    public void mostrarGraficos() {
        final double VELOCIDAD_JUEGO = 100;
        Timeline fps = new Timeline();
        fps.setCycleCount(Animation.INDEFINITE);
        fps.getKeyFrames().add(new KeyFrame(Duration.millis(VELOCIDAD_JUEGO), (t) -> {
            if(serpiente.getEnMovimiento()) {
                graficos.clearRect(0, 0, escenarioCanvas.getWidth(), escenarioCanvas.getHeight());
                if (escenario.getColisionDetectada()) {
                    graficos.fillRect(serpiente.getPosicionAnteriorX(), serpiente.getPosicionAnteriorY(), dimensionSerpiente, dimensionSerpiente);
                    fps.stop();
                    System.out.println("GAME OVER");

                }
                System.out.println(escenario.getColisionDetectada());

                serpiente.continuarMoviendo(dimensionSerpiente);
                escenario.detectarColision();
                graficos.fillRect(serpiente.getPosicionX(), serpiente.getPosicionY(), dimensionSerpiente, dimensionSerpiente);
            }
           
        }));
        
        fps.play();
        
    }
    
    @FXML
    private void moverSerpiente(KeyEvent event) {
        
        KeyCode tecla = event.getCode();
        switch(tecla) {
            case UP:
                System.out.println("Subiendo...");
                serpiente.mover("UP", dimensionSerpiente);
                System.out.println("Posicion serpiente -> (" + serpiente.getPosicionX() + ", " + serpiente.getPosicionY() + ")");
                break;
            case DOWN:
                System.out.println("Bajando...");
                serpiente.mover("DOWN", dimensionSerpiente);
                System.out.println("Posicion serpiente -> (" + serpiente.getPosicionX() + ", " + serpiente.getPosicionY() + ")");
                break;
            case LEFT:
                System.out.println("Izquierda...");
                serpiente.mover("LEFT", dimensionSerpiente);
                System.out.println("Posicion serpiente -> (" + serpiente.getPosicionX() + ", " + serpiente.getPosicionY() + ")");
                break;
            case RIGHT:
                System.out.println("Derecha...");
                serpiente.mover("RIGHT", dimensionSerpiente);
                System.out.println("Posicion serpiente -> (" + serpiente.getPosicionX() + ", " + serpiente.getPosicionY() + ")");
                break;
            default:
                break;
        }
    }
    
}
